package com.github.algorithm;

import static com.github.DataSetUtil.getRandomSlide;
import static java.util.Collections.disjoint;

import com.github.InterestResult;
import com.github.Picture;
import com.github.PicturesForSlide;

import java.util.ArrayList;
import java.util.List;

public class NaiveRandomAlgorithm implements Algorithm {

    private int attempts;

    public NaiveRandomAlgorithm(int attempts) {
        this.attempts = attempts;
    }

    @Override
    public InterestResult calculateScore(List<Picture> pictures) {

        int score = 0;
        List<String> result = new ArrayList<>();

        int iterationsLeft = attempts;
        while (iterationsLeft-- > 0 && pictures.size() > 3) {

            PicturesForSlide first = getRandomSlide(pictures);
            PicturesForSlide second = getRandomSlide(pictures);

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
}
