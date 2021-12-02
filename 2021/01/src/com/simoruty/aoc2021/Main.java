package com.simoruty.aoc2021;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> values = Common.readFromFile("./input");
        part1(values);
        part2(values);
    }

    private static void part1(ArrayList<Integer> values) {
        int plus =0;
        for (int i = 0; i < values.size()-1; i++)
            if (values.get(i+1) > values.get(i))
                    plus++;
        System.out.println("Part1 result: "+ plus);
    }

    private static void part2(ArrayList<Integer> values) {
        int plus = 0;
        for (int i = 0; i < values.size()-3; i++)
            if (values.get(i+1)+values.get(i+2)+values.get(i+3) > values.get(i+1)+values.get(i+2)+values.get(i))
                plus++;
        System.out.println("Part2 result: "+ plus);
    }
}