package com.github;

import java.util.List;

public class PicturesForSlide {
    public Slide slide;
    public List<Picture> picturesUsed;

    private PicturesForSlide() {
    }

    static PicturesForSlide of(Slide slide, List<Picture> picturesUsed) {
        PicturesForSlide picturesForSlide = new PicturesForSlide();
        picturesForSlide.slide = slide;
        picturesForSlide.picturesUsed = picturesUsed;

        return picturesForSlide;
    }
}

