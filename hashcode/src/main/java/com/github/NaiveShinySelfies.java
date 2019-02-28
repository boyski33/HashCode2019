package com.github;

import com.github.io.InputDataSetReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.disjoint;

public class NaiveShinySelfies implements DataSet {

    private static final int ATTEMPTS = 5_000_000;

    @Override
    public List<String> run() throws IOException, URISyntaxException {
        InputDataSetReader reader = new InputDataSetReader();

        List<Picture> pictures = reader.read("e_shiny_selfies.txt");

        Random random = new Random();
        List<String> result = new ArrayList<>();

        int iterrationsLeft = ATTEMPTS;
        while (iterrationsLeft-- > 0 && pictures.size() > 3) {
            Picture leftFirst = pictures.remove(random.nextInt(pictures.size()));
            Picture leftSecond = pictures.remove(random.nextInt(pictures.size()));
            Picture rightFirst = pictures.remove(random.nextInt(pictures.size()));
            Picture rightSecond = pictures.remove(random.nextInt(pictures.size()));

            Slide first = Slide.of(leftFirst, leftSecond);
            Slide second = Slide.of(rightFirst, rightSecond);

            if (!disjoint(first.tags, second.tags)) {
                result.add(String.valueOf(first.printableIds()));
                result.add(String.valueOf(second.printableIds()));
            } else {
                pictures.add(leftFirst);
                pictures.add(leftSecond);
                pictures.add(rightFirst);
                pictures.add(rightSecond);
            }

        }

        for (int i = 0; i < pictures.size(); i++) {
            if (i == pictures.size() - 1) {
                result.add(Slide.of(pictures.get(i)).printableIds());
                break;
            }

            result.add(Slide.of(pictures.get(i++), pictures.get(i)).printableIds());
        }

        return result;

    }

}
