package com.github;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static java.util.List.of;

public class SlideTest {

    @Test
    public void intersection_with_one() {
        Picture firstPicture = new Picture('H', new HashSet<>(of("cat", "mouse", "dragon")));
        Picture secondPicture = new Picture('H', new HashSet<>(of("sun", "mouse", "beach")));

        Slide first = Slide.of(firstPicture);
        Slide second = Slide.of(secondPicture);

        Assert.assertEquals(1, first.interestScore(second));

    }

    @Test
    public void intersection_with_two() {
        Picture horizontalPicture = new Picture('H', new HashSet<>(of("A", "B", "C")));
        Picture firstVertical = new Picture('V', new HashSet<>(of("A", "B", "D")));
        Picture secondVertical = new Picture('V', new HashSet<>(of("A", "B", "D")));

        Slide first = Slide.of(horizontalPicture);
        Slide second = Slide.of(firstVertical, secondVertical);

        Assert.assertEquals(2, first.interestScore(second));

    }
}