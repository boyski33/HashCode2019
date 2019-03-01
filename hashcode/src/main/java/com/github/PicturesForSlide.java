package com.github;

import com.github.Picture;
import com.github.Slide;

import java.util.List;

class PicturesForSlide {
    Slide slide;
    List<Picture> picturesUsed;

    private PicturesForSlide() {
    }

    static PicturesForSlide of(Slide slide, List<Picture> picturesUsed) {
        PicturesForSlide picturesForSlide = new PicturesForSlide();
        picturesForSlide.slide = slide;
        picturesForSlide.picturesUsed = picturesUsed;

        return picturesForSlide;
    }
}

