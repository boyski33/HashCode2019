package com.github;

import com.github.io.InputDataSetReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.github.DataSetUtil.getRandomSlide;
import static java.util.Collections.disjoint;

public class NaiveMemorableMoments implements DataSet {

    private static final int ATTEMPTS = 15_000_000;

    @Override
    public InterestResult run() throws IOException, URISyntaxException {
        InputDataSetReader reader = new InputDataSetReader();
        int score = 0;

        List<Picture> pictures = reader.read("c_memorable_moments.txt");

        List<String> result = new ArrayList<>();

        int iterationsLeft = ATTEMPTS;
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
