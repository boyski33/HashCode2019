package com.github;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataSetUtil {
    public static PicturesForSlide getRandomSlide(List<Picture> pictures) {
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

}
