package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> values = Common.readFromFile("./test/input.txt");
        Collections.sort(values);
        part1(values);
        part2(values);
    }

    private static void part1(ArrayList<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            for (int j = values.size()-1; j > i; j--) {
                if (values.get(i)+values.get(j)==2020)
                    System.out.println(values.get(i) + " * "+values.get(j)+" = " + values.get(i)*values.get(j));
            }
        }
    }

    private static void part2(ArrayList<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            for (int j = values.size() - 1; j > i; j--) {
                for (int k = i+1; k<values.size(); k++) {
                    if (values.get(i) + values.get(j) + values.get(k) == 2020) {
                        System.out.println(values.get(i) + " * " + values.get(j) + " * " + values.get(k) + " = " + values.get(i) * values.get(j) * values.get(k));
                        return;
                    }
                }
            }
        }
    }
}
