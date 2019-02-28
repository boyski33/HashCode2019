package com.github;

import static java.util.Collections.disjoint;

import com.github.io.InputDataSetReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NaiveLovelyLandscapes implements DataSet {

    private static final int ATTEMPTS = 15_000_000;

    @Override
    public InterestResult run() throws IOException, URISyntaxException {
        int totalScore = 0;

        InputDataSetReader reader = new InputDataSetReader();
        List<String> ids = new ArrayList<>();

        List<Picture> pictures = reader.read("b_lovely_landscapes.txt");

        Random random = new Random();

        int iterrationsLeft = ATTEMPTS;
        while (iterrationsLeft-- > 0 && pictures.size() > 1) {
            Picture first = pictures.remove(random.nextInt(pictures.size()));
            Picture second = pictures.remove(random.nextInt(pictures.size()));


            if (!disjoint(first.tags, second.tags)) {
                Slide fSlide = Slide.of(first);
                Slide sSlide = Slide.of(second);
                totalScore += fSlide.interestScore(sSlide);


                ids.add(String.valueOf(first.id));
                ids.add(String.valueOf(second.id));
            } else {
                pictures.add(first);
                pictures.add(second);
            }

        }

        for (Picture picture : pictures) {
            ids.add(String.valueOf(picture));
        }

        return new InterestResult(totalScore, ids);
    }

}
