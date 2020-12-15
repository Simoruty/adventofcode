package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = Common.readFromFile("./test/input");
        assert numbers != null;
        System.out.println("Part1: " + challenge(numbers, 2020));
        System.out.println("Part2: " + challenge(numbers, 30000000));
    }

    public static Integer challenge(ArrayList<Integer> numbers, int end) {
        HashMap<Integer, Integer> seq = new HashMap<>();
        int prev = -1;
        int count = 0;
        for (Integer i : numbers) {
            seq.put(prev, count);
            count++;
            prev = i;
        }
        while (count <= end) {
            int tmp;
            if (!seq.containsKey(prev)) tmp = 0;
            else tmp = count - seq.get(prev);
            seq.put(prev, count);
            prev = tmp;
            count++;
        }
        for (HashMap.Entry<Integer, Integer> entry : seq.entrySet())
            if (entry.getValue() == end) return entry.getKey();
        return 0;
    }
}
