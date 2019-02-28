package com.github;

import java.util.ArrayList;
import java.util.List;

public class Picture {

    char orientation;
    List<String> tags;

    public Picture(char orientation, List<String> tags) {
        this.orientation = orientation;
        this.tags = tags;
    }


    public static Picture fromInputLine(String line) {
        String[] split = line.split(" ");

        char orientation = split[0].charAt(0);

        List<String> currentTags = new ArrayList<>();

        for (int i = 2; i < split.length; i++) {
            currentTags.add(split[i]);
        }

        return new Picture(orientation, currentTags);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture picture = (Picture) o;

        if (orientation != picture.orientation) return false;
        return tags != null ? tags.equals(picture.tags) : picture.tags == null;
    }

    @Override
    public int hashCode() {
        int result = (int) orientation;
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "orientation=" + orientation +
                ", tags=" + tags +
                '}';
    }
}
