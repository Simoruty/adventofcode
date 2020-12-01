package com.simoruty;

import java.util.ArrayList;

public class Parts {

    public static void part2(ArrayList<Integer> values, ArrayList<Integer> pattern) {
        System.out.println("---------------- PART 2 -------------------");
        System.out.println("Input signal " + values.size());

        ArrayList<Integer> newInput = new ArrayList<>(values.size() * 10000);
        for (int i = 0; i < 10000; i++) {
            newInput.addAll(values);
        }

        int cycle = 100;
        ArrayList<Integer> calc = fft(newInput, pattern, cycle);
        System.out.println("After " + cycle + " the result is " + newInput.size() + " : " + convertArrayToStringFirstChars(calc, 8));
    }

    private static ArrayList<Integer> fft(ArrayList<Integer> values, ArrayList<Integer> pattern, int cycle) {

        for (int j = 1; j <= cycle; j++) {
            System.out.println("Init - " + j + " cycle");
            long startTime = System.nanoTime();
            ArrayList<Integer> newValue = new ArrayList<>();

            for (int i = 1; i <= values.size(); i++) {
                ArrayList<Integer> patternTmp = createPattern(pattern, i);
                int val = val(values, patternTmp);
                newValue.add(val);
            }
            values = newValue;
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("End - " + j + " cycle in " + duration);
        }
        return values;
    }

    public static void part1(ArrayList<Integer> values, ArrayList<Integer> pattern) {
        System.out.println("---------------- PART 1 -------------------");
        System.out.println("Input signal " + values.size() + ": " + convertArrayToString(values));

        int cycle = 100;
        ArrayList<Integer> calc = fft(values, pattern, cycle);
        System.out.println("After " + cycle + " the result is " + values.size() + " : " + convertArrayToStringFirstChars(calc, 8));
    }

    private static String convertArrayToString(ArrayList<Integer> val) {
        StringBuilder valConverted = new StringBuilder();
        for (Integer integer : val) {
            valConverted.append(integer);
        }
        return valConverted.toString();
    }

    private static String convertArrayToStringFirstChars(ArrayList<Integer> val, int limit) {
        StringBuilder valConverted = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            Integer integer = val.get(i);
            valConverted.append(integer);
        }
        return valConverted.toString();
    }

    private static ArrayList<Integer> createPattern(ArrayList<Integer> pattern, int pos) {
        ArrayList<Integer> newPattern = new ArrayList<>();

        for (Integer integer : pattern) {
            for (int i = 1; i <= pos; i++) {
                newPattern.add(integer);
            }
        }
        return newPattern;
    }

    private static int val(ArrayList<Integer> values, ArrayList<Integer> pattern) {
        int val = 0;
        for (int j = 0; j < values.size(); j++) {
            val += values.get(j) * pattern.get((j + 1) % pattern.size());
        }
        return (Math.abs(val))%10;
    }


}
