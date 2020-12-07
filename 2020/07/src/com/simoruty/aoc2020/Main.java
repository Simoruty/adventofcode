package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        ArrayList<BagColor> bagColors = Common.readFromFile("./test/input");
        assert bagColors != null;

        ArrayList<BagColor> matchedRules = new ArrayList<>();
        part1(bagColors, matchedRules, "shiny gold");
        System.out.println("Part1: " + matchedRules.size());

        System.out.println("Part2: " + part2(bagColors, "shiny gold"));

    }

    public static void part1(ArrayList<BagColor> totalRules, ArrayList<BagColor> matchedRules, String color) {
        totalRules.forEach(bagRule -> {
            if (bagRule.getContainedBags().containsKey(color) && !matchedRules.contains(bagRule)) {
                matchedRules.add(bagRule);
                part1(totalRules, matchedRules, bagRule.getColor());
            }
        });
    }

    // We convert each <String,Integer> node into an Integer out of:
    // inner_bag_count + (inner_bag_count * countChildrenBags(current_color)) [recursive]
    // So then we sum everything
    public static int part2(ArrayList<BagColor> totalRules, String color) {
        return Objects.requireNonNull(totalRules.stream().filter(r -> r.getColor().equals(color)).findFirst().orElse(null)).
                getContainedBags().entrySet().stream().
                // Convert from Entry<String:color,Integer:count> -> count + (count* children-count(current_color))
                        map(e -> e.getValue() + (e.getValue() * part2(totalRules, e.getKey()))).
                        reduce(Integer::sum).orElse(0);
    }
}
