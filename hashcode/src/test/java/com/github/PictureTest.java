package com.github;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class PictureTest {

    @Test
    public void fromInputLine() {

        String line = "H 3 cat beach sun";

        Picture expected = new Picture('H', Set.of("cat", "beach", "sun"));

        Picture actual = Picture.fromInputLine(line);

        Assert.assertEquals(expected, actual);

    }
}