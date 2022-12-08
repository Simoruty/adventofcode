package com.simoruty.aoc2022;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> values = Common.readFromFile("./input");

        part1(values);
        part2(values);
    }

    private static void part1(ArrayList<String> values) {
        int tot = 0;
        for (String value : values) {
            int result = 0;
            int choice1 = value.toCharArray()[0] - 64;
            int choice2 = value.toCharArray()[2] - 87;
            if (choice2 - choice1 == -2)
                result = choice2 + 6;
            else if (choice2 - choice1 == 1)
                result = choice2 + 6;
            else if (choice2 - choice1 == 0)
                result = choice2 + 3;
            else if (choice2 - choice1 == 2)
                result = choice2;
            else if (choice2 - choice1 == -1)
                result = choice2;

            //System.out.println(choice1 + " " + choice2 + " = " + result);
            tot += result;
        }
        System.out.println("Part1 result: " + tot);
    }

    private static void part2(ArrayList<String> values) {
        int tot = 0;
        for (String value : values) {
            int choice1 = value.toCharArray()[0] - 64;
            int choice2 = value.toCharArray()[2] - 87;
            int result = 0;
            switch (choice2) {
                case 1 -> {
                    if (choice1 == 1)
                        choice1 = 4;
                    result = choice1 - 1;
                }
                case 2 -> result = choice1 + 3;
                case 3 -> {
                    if (choice1 == 3)
                        choice1 = 0;
                    result = choice1 + 1 + 6;
                }
            }
            tot += result;
            //System.out.println(choice1 + " " + choice2 + " = " + result);
        }
        System.out.println("Part2 result: " + tot);
    }
}