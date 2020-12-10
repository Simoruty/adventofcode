package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> jolts = Common.readFromFile("./test/input");
        assert jolts != null;
        System.out.println("Part1: " + part1(jolts));
        System.out.println("Part2: " + part2(jolts));
    }

    public static int part1(ArrayList<Integer> jolts) {

        HashMap<Integer, Integer> joltsDifferences = new HashMap<>();

        for (Integer jolt : jolts) {
            if (jolts.contains(jolt + 1)) {
                if (joltsDifferences.containsKey(1)) {
                    joltsDifferences.put(1, joltsDifferences.get(1) + 1);
                } else
                    joltsDifferences.put(1, 1);

            } else if (jolts.contains(jolt + 2)) {
                if (joltsDifferences.containsKey(2)) {
                    joltsDifferences.put(2, joltsDifferences.get(2) + 1);
                } else
                    joltsDifferences.put(2, 1);

            } else if (jolts.contains(jolt + 3)) {
                if (joltsDifferences.containsKey(3)) {
                    joltsDifferences.put(3, joltsDifferences.get(3) + 1);
                } else
                    joltsDifferences.put(3, 1);
            }
        }

        System.out.println(joltsDifferences);
        return joltsDifferences.get(1) * joltsDifferences.get(3);
    }

    public static long part2(ArrayList<Integer> jolts) {
        long[] comboTmp = new long[jolts.size()];
        Arrays.fill(comboTmp, -1);
        return count_combos(jolts, 0, comboTmp);
    }

    private static long count_combos(ArrayList<Integer> jolts, int index, long[] comboTmp) {
        if (index == jolts.size() - 1)
            return 1;

        if (comboTmp[index] != -1) {
            return comboTmp[index];
        } else {
            long count = 0;
            for (int i = index + 1; i <= Math.min(index + 3, jolts.size() - 1); i++)
                if (jolts.get(i) <= jolts.get(index) + 3)
                    count += count_combos(jolts, i, comboTmp);
            comboTmp[index] = count;
            return count;
        }
    }
}
