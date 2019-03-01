package com.github.algorithm;

import com.github.InterestResult;
import com.github.Picture;

import java.util.List;

public interface Algorithm {
    InterestResult calculateScore(List<Picture> pictures);
}
