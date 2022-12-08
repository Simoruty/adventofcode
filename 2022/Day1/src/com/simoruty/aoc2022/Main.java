package com.simoruty.aoc2022;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> values = Common.readFromFile("./input");

        part1(values);
        part2(values);
    }

    private static void part1(ArrayList<Integer> values) {
        System.out.println("Part1 result: "+ Collections.max(values));
    }

    private static void part2(ArrayList<Integer> values) {
        Collections.sort(values,Collections.reverseOrder());
        int top3 = values.get(0)+values.get(1)+values.get(2);
        System.out.println("Part2 result: "+ top3);
    }
}