package com.simoruty;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static ArrayList<ArrayList<Integer>> combos = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] numbers = Common.readFromFile("./input");
        int target = 150;
        sum_up(new ArrayList<>(Arrays.asList(numbers)), target);

        System.out.println("Different combinations of containers can exactly fit is " + combos.size());
        System.out.println("The minimum number of containers that can exactly fit is " + count_minimum_comb());
    }

    private static int count_minimum_comb() {
        int min = Integer.MAX_VALUE;
        int tot = 0;
        for (ArrayList<Integer> combo : combos) {
            if (combo.size() == min)
                tot++;

            if (combo.size() < min) {
                min = combo.size();
                tot = 1;
            }
        }
        return tot;
    }

    private static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;
        for (int x : partial) s += x;
        if (s == target) {
            //System.out.println("sum(" + Arrays.toString(partial.toArray()) + ")=" + target);
            combos.add(partial);
        }
        if (s >= target)
            return;
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList<>();
            int n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining, target, partial_rec);
        }
    }

    private static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers, target, new ArrayList<Integer>());
    }
}
