package com.github;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PictureTest {

    @Test
    public void fromInputLine() {

        String line = "H 3 cat beach sun";

        Picture expected = new Picture('H', List.of("cat", "beach", "sun"));

        Picture actual = Picture.fromInputLine(line);

        Assert.assertEquals(expected, actual);

    }
}