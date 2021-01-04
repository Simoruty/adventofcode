package com.simoruty.aoc2020;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        String path = "./test/input";
        InputDataType foods = Common.readFood(path);
        assert foods != null;
        System.out.println("Part1: " + getPart1Sol(foods));
        System.out.println("Part2: " + getPart2Sol(foods));
    }

    public static long getPart1Sol(InputDataType foods) {
        HashSet<String> inertSet = getInertIngredients(foods.ingredients, foods.allergens);
        long total = 0;
        for (String ingredient : inertSet)
            for (HashSet<String> set : foods.ingredients)
                total += set.contains(ingredient) ? 1 : 0;
        return total;
    }

    private static HashSet<String> getInertIngredients(List<HashSet<String>> ingredients, List<HashSet<String>> allergens) {
        final HashSet<String> ingredientsSet = new HashSet<>();
        ingredients.forEach(ingredientsSet::addAll);

        final HashSet<String> allergenSet = new HashSet<>();
        allergens.forEach(allergenSet::addAll);

        final Deque<String> queue = new ArrayDeque<>(allergenSet);
        while (!queue.isEmpty()) {
            final String current = queue.removeLast();
            HashSet<String> possible = null;
            for (int i = 0; i < ingredients.size(); i++) {
                if (!allergens.get(i).contains(current))
                    continue;

                if (possible == null)
                    possible = new HashSet<>(ingredients.get(i));

                else {
                    final HashSet<String> ingredientSubset = ingredients.get(i);
                    possible.removeIf(a -> !ingredientSubset.contains(a));
                }
            }

            if (possible != null && possible.size() > 0)
                ingredientsSet.removeAll(possible);
        }

        return ingredientsSet;
    }

    public static Object getPart2Sol(InputDataType foods) {
        HashSet<String> inertSet = getInertIngredients(foods.ingredients, foods.allergens);

        HashMap<String, String> allergenMap = new HashMap<>();
        HashMap<String, Set<String>> candidateMap = new HashMap<>();
        IntStream.range(0, foods.ingredients.size()).forEach(i -> {
            Set<String> v = foods.ingredients.get(i).stream().filter(a -> !inertSet.contains(a)).collect(Collectors.toSet());
            for (String k : foods.allergens.get(i))
                if (candidateMap.containsKey(k))
                    candidateMap.get(k).retainAll(v);
                else {
                    candidateMap.put(k, new HashSet<>(v));
                    allergenMap.put(k, null);
                }
        });

        while (allergenMap.containsValue(null)) {
            Map.Entry<String, Set<String>> candidate = candidateMap.entrySet().stream().filter(a -> a.getValue().size() == 1).findFirst().get();
            String ingredient = candidate.getValue().stream().findFirst().get();
            allergenMap.put(candidate.getKey(), ingredient);
            candidateMap.values().forEach(a -> a.remove(ingredient));
        }

        return allergenMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).collect(Collectors.joining(","));
    }
}
