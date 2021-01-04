package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Common {

    static InputDataType readFood(String path) {
        final List<HashSet<String>> ingredients = new ArrayList<>();
        final List<HashSet<String>> allergens = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                final String[] parts = line.split(" \\(contains ");
                ingredients.add(new HashSet<>(Arrays.asList(parts[0].split(" "))));
                allergens.add(new HashSet<>(Arrays.asList(parts[1].substring(0, parts[1].length() - 1).split(", "))));
            }
            return new InputDataType(ingredients, allergens);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}