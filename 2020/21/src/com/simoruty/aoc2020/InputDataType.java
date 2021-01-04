package com.simoruty.aoc2020;

import java.util.HashSet;
import java.util.List;

public class InputDataType {
    public final List<HashSet<String>> ingredients;
    public final List<HashSet<String>> allergens;

    public InputDataType(List<HashSet<String>> ingredients, List<HashSet<String>> allergens) {
        this.ingredients = ingredients;
        this.allergens = allergens;
    }
}
