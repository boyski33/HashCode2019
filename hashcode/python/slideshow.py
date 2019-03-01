#!/usr/bin/env python

import sys
import time
import random
from collections import namedtuple


MAX_DURATION = 60


Photo = namedtuple('Photo', ['orientation', 'tags'])
Slide = namedtuple('Slide', ['photos', 'tags'])


def read_photos(path):
    with open(path) as f:
        hphotos = []
        vphotos = []
        num_photos = int(f.readline().strip())
        for line in f:
            orientation, num_tags, tags_raw = line.strip().split(' ', 2)
            tags = frozenset(tags_raw.split())
            photo = Photo(orientation=orientation, tags=tags)
            collection = hphotos if orientation == 'H' else vphotos
            collection.append(photo)

    return hphotos, vphotos


def create_slides(hphotos, vphotos):
    slides = [Slide(photos=(photo,), tags=photo.tags) for photo in hphotos]

    vphotos = vphotos[:] # copy to avoid the side effect if in-place shuffling
    random.shuffle(vphotos)
    for i in range(0, len(vphotos), 2):
        photos = tuple(hphotos[i:i+2])
        tags = photos[0].tags | photos[1].tags
        slide = Slide(photos=photos, tags=tags)
        slides.append(slide)

    random.shuffle(slides)

    return slides


def compute_interest(slides):
    interest = 0

    it = iter(slides)
    prev_slide = next(it)
    for next_slide in it:
        common_tags = prev_slide.tags & next_slide.tags
        prev_only_tags = prev_slide.tags - next_slide.tags
        next_only_tags = next_slide.tags - prev_slide.tags

        interest += min(len(tags) for tags in (common_tags, prev_only_tags, next_only_tags))

        prev_slide = next_slide

    return interest


def main():
    random.seed("python")

    print('reading photos')
    hphotos, vphotos = read_photos(sys.argv[1])
    print(len(hphotos), len(vphotos))

    max_total_interest = 0
    start_time = time.time()
    while time.time() < start_time + MAX_DURATION:
        print('creating slides')
        slides = create_slides(hphotos, vphotos)
        print(len(slides))

        # create transitions between slides with similar numbers of tags
        slides.sort(key=lambda slide: len(slide.tags))

        print('computing total interest')
        total_interest = compute_interest(slides)
        print(total_interest)

        if total_interest > max_total_interest:
            max_total_interest = total_interest

    print('max total interest:', max_total_interest)


if __name__ == '__main__':
    main()
