package com.github;

import com.github.io.GenerateOutput;
import com.github.io.InputDataSetReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.disjoint;

public class NaiveLovelyLandscapes implements DataSet {

    private static final int ATTEMPTS = 5_000_000;
    private int count = 0;

    @Override
    public List<String> run() throws IOException, URISyntaxException {
        InputDataSetReader reader = new InputDataSetReader();

        List<Picture> pictures = reader.read("b_lovely_landscapes.txt");

        Random random = new Random();
        List<String> result = new ArrayList<>();


        int iterrationsLeft = ATTEMPTS;
        while (iterrationsLeft-- > 0 && pictures.size() > 1) {
            Picture first = pictures.remove(random.nextInt(pictures.size()));
            Picture second = pictures.remove(random.nextInt(pictures.size()));

            if (!disjoint(first.tags, second.tags)) {
                result.add(String.valueOf(first.id));
                result.add(String.valueOf(second.id));
            } else {
                pictures.add(first);
                pictures.add(second);
            }

        }

        return result;

    }

}
