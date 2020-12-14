package com.simoruty.aoc2020;

import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Bitmask> bitmasks = Common.readFromFile("./test/input");
        assert bitmasks != null;
        System.out.println("Part1: " + part1(bitmasks));
        System.out.println("Part2: " + part2(bitmasks));
    }

    public static BigInteger part1(ArrayList<Bitmask> bitmasks) {

        HashMap<Integer, BigInteger> newMemory = new HashMap<>();
        for (Bitmask bitmask : bitmasks) {
            HashMap<Integer, Integer> memory = bitmask.getMemory();
            for (Integer pos : memory.keySet()) {
                StringBuilder newVal = new StringBuilder(String.format("%36s", Integer.toBinaryString(memory.get(pos))).replaceAll(" ", "0"));  // 36-bit Integer
                HashMap<Integer, Integer> mask = bitmask.getMask();
                for (Integer posMask : mask.keySet())
                    newVal.setCharAt(posMask, mask.get(posMask).toString().charAt(0));
                newMemory.put(pos, new BigInteger(String.valueOf(newVal), 2));
            }
        }

        BigInteger sum = new BigInteger("0");
        for (Integer integer : newMemory.keySet()) sum = sum.add(newMemory.get(integer));
        return sum;
    }

    public static BigInteger part2(ArrayList<Bitmask> bitmasks) {
        TreeMap<BigInteger, Integer> newMemory = new TreeMap<>();

        for (Bitmask bitmask : bitmasks) {

            HashMap<Integer, Integer> memory = bitmask.getMemory();
            ArrayList<Integer> order = bitmask.getOrder();
            for (Integer memAddress : order) {
                StringBuilder newVal = new StringBuilder(String.format("%36s", Integer.toBinaryString(memAddress)).replaceAll(" ", "0"));  // 36-bit Integer
                HashMap<Integer, Integer> mask = bitmask.getMask();
                for (int i = 0; i < newVal.length(); i++) {
                    if (mask.containsKey(i)) {
                        if (mask.get(i) == 1) newVal.setCharAt(i, '1');
                    } else newVal.setCharAt(i, 'X');
                }

                HashSet<String> result = new HashSet<>();
                result.add(newVal.toString());
                while (true) {
                    Set<String> stringToAddToResult = new HashSet<>();
                    Set<String> stringToRemove = new HashSet<>();
                    for (String stringToProcess : result) {
                        if (stringToProcess.contains("X")) {
                            stringToRemove.add(stringToProcess);
                            stringToAddToResult.add(stringToProcess.replaceFirst("X", "1"));
                            stringToAddToResult.add(stringToProcess.replaceFirst("X", "0"));
                            break;
                        }
                    }
                    result.addAll(stringToAddToResult);
                    result.removeAll(stringToRemove);
                    int numberOfResultsWithoutX = 0;
                    for (String string : result) {
                        if (!string.contains("X")) numberOfResultsWithoutX++;
                    }
                    if (numberOfResultsWithoutX == result.size()) break;
                }
                for (String s : result) {
                    newMemory.put(new BigInteger(s, 2), memory.get(memAddress));
                }
            }
        }

        BigInteger sum = new BigInteger("0");
        for (BigInteger integer : newMemory.keySet()) {
            sum = sum.add(BigInteger.valueOf(newMemory.get(integer)));
        }
        return sum;
    }
}
