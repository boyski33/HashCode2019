package com.github;

import com.github.algorithm.Algorithm;
import com.github.io.InputDataSetReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class NaivePetPictures implements DataSet {

    private static final int ATTEMPTS = 5_000_000;
    private Algorithm algorithm;

    public NaivePetPictures(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public InterestResult run() throws IOException, URISyntaxException {

        InputDataSetReader reader = new InputDataSetReader();
        List<Picture> pictures = reader.read("d_pet_pictures.txt");

        return algorithm.calculateScore(pictures);
    }

}
