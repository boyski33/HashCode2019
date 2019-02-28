package com.github;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Picture {

    public static int currentId = 0;

    char orientation;
    Set<String> tags;
    int id;

    public Picture(char orientation, Set<String> tags) {
        this.orientation = orientation;
        this.tags = tags;
        this.id = currentId++;
    }


    public static Picture fromInputLine(String line) {
        String[] split = line.split(" ");

        char orientation = split[0].charAt(0);

        Set<String> currentTags = new HashSet<>(
                Arrays.asList(split).subList(2, split.length));

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
                "id=" + id +
                "orientation=" + orientation +
                ", tags=" + tags +
                '}';
    }
}
