package com.github;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Slide {

    public List<Integer> ids;
    public Set<String> tags;

    public Slide(List<Integer> ids, Set<String> tags) {
        this.ids = ids;
        this.tags = tags;
    }

    public static Slide of(Picture horizontal) {
        return new Slide(List.of(horizontal.id), horizontal.tags);
    }

    public static Slide of(Picture firstVertical, Picture secondVertical) {
        Set<String> combinedTags = new HashSet<>(firstVertical.tags);
        combinedTags.addAll(secondVertical.tags);

        return new Slide(List.of(firstVertical.id, secondVertical.id), combinedTags);
    }

    public int interestScore(Slide slide) {
        Set<String> intersection = new HashSet<>(this.tags);
        intersection.retainAll(slide.tags);

        int both = intersection.size();
        int left = this.tags.size() - both;
        int right = slide.tags.size() - both;

        return Math.min(both, Math.min(left, right));
    }

    public String printableIds() {
        if (ids.size() == 1) {
            return ids.get(0).toString();
        }

        return ids.get(0) + " " + ids.get(1);
    }

    @Override
    public String toString() {
        return "Slide{" +
                "ids=" + ids +
                ", tags=" + tags +
                '}';
    }
}
