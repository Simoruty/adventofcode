package com.simoruty.aoc2020;

import java.util.HashMap;
import java.util.Objects;

public class BagColor {
    private final String color;
    private final HashMap<String, Integer> containedBags;

    public BagColor(String color, HashMap<String, Integer> containedBags) {
        this.color = color;
        this.containedBags = containedBags;
    }

    public String getColor() {
        return color;
    }

    public HashMap<String, Integer> getContainedBags() {
        return containedBags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BagColor bagColor = (BagColor) o;
        return color.equals(bagColor.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "BagColor{" +
                "color='" + color + '\'' +
                ", containedBags=" + containedBags +
                '}';
    }
}