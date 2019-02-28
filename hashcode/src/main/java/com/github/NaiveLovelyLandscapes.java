package com.github;

import com.github.io.GenerateOutput;
import com.github.io.InputDataSetReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NaiveLovelyLandscapes {

    public List<String> run() throws IOException, URISyntaxException {
        InputDataSetReader reader = new InputDataSetReader();

        List<Picture> pictures = reader.read("b_lovely_landscapes.txt");

        Random random = new Random();
        List<String> result = new ArrayList<>();


        while (!pictures.isEmpty()) {
            Picture picture = pictures.remove(random.nextInt(pictures.size()));
            result.add(String.valueOf(picture.id));
        }

        new GenerateOutput().generate("b_lovely_landscapes", result);


        return result;

    }

}
