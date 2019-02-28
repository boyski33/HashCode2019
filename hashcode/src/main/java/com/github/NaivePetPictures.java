package com.github;

import com.github.io.InputDataSetReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.disjoint;

public class NaivePetPictures implements DataSet {

    private static final int ATTEMPTS = 5_000_000;

    @Override
    public InterestResult run() throws IOException, URISyntaxException {
        InputDataSetReader reader = new InputDataSetReader();
        int score = 0;

        List<Picture> pictures = reader.read("d_pet_pictures.txt");

        List<String> result = new ArrayList<>();

        int iterrationsLeft = ATTEMPTS;
        while (iterrationsLeft-- > 0 && pictures.size() > 3) {

            PicturesForSlide first = getSlide(pictures);
            PicturesForSlide second = getSlide(pictures);

            if (first == null || second == null) {
                return new InterestResult(score, result);
            }

            if (!disjoint(first.slide.tags, second.slide.tags)) {
                result.add(String.valueOf(first.slide.printableIds()));
                result.add(String.valueOf(second.slide.printableIds()));
                score += first.slide.interestScore(second.slide);

            } else {
                pictures.addAll(first.picturesUsed);
                pictures.addAll(second.picturesUsed);
            }

        }

        return new InterestResult(score, result);

    }

    private PicturesForSlide getSlide(List<Picture> pictures) {
        Random random = new Random();
        Picture pic = pictures.remove(random.nextInt(pictures.size()));

        if (pic.orientation == 'H') {
            return PicturesForSlide.of(Slide.of(pic), List.of(pic));
        }

        List<Picture> unused = new ArrayList<>();
        Picture second = null;

        // this can timeout
        int maxAttempts = 1000;
        while (second == null) {

            second = pictures.remove(random.nextInt(pictures.size()));
            if (second.orientation == 'V') {
                pictures.addAll(unused);
                return PicturesForSlide.of(Slide.of(pic, second), List.of(pic, second));
            }

            unused.add(second);
            if (maxAttempts-- <= 0) {
                return null;
            }
        }

        pictures.addAll(unused);
        return null;
    }

    private static class PicturesForSlide {
        Slide slide;
        List<Picture> picturesUsed;

        private PicturesForSlide() {
        }

        public static PicturesForSlide of(Slide slide, List<Picture> picturesUsed) {
            PicturesForSlide picturesForSlide = new PicturesForSlide();
            picturesForSlide.slide = slide;
            picturesForSlide.picturesUsed = picturesUsed;

            return picturesForSlide;
        }
    }


}
