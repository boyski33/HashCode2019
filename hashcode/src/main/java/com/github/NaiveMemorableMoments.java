package com.github;

import static com.github.DataSetUtil.getRandomSlide;
import static java.util.Collections.disjoint;

import com.github.algorithm.Algorithm;
import com.github.io.InputDataSetReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class NaiveMemorableMoments implements DataSet {

    private Algorithm algorithm;

    public NaiveMemorableMoments(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public InterestResult run() throws IOException, URISyntaxException {

        InputDataSetReader reader = new InputDataSetReader();
        List<Picture> pictures = reader.read("c_memorable_moments.txt");

        return algorithm.calculateScore(pictures);
    }

}
