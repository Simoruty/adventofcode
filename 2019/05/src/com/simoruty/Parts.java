package com.simoruty;

import java.util.ArrayList;

public class Parts {
    public static void part1(ArrayList<Integer> values) {

        System.out.println("---------------- PART 1 -------------------");

        System.out.println(values);

        int i = 0;
        while (i < values.size() && values.get(i) != 99) {
            int val = values.get(i);
            switch (val) {
                case 1:
                    values.set(values.get(i + 3), values.get(values.get(i + 1)) + values.get(values.get(i + 2)));
                    i = i + 4;
                    break;
                case 2:
                    values.set(values.get(i + 3), values.get(values.get(i + 1)) * values.get(values.get(i + 2)));
                    i = i + 4;
                    break;

                case 3:
                    values.set(values.get(i + 1), values.get(i + 1));
                    i = i + 2;
                    break;

                case 4:
                    System.out.println("Result is " + values.get(i+1));
                    System.exit(2);
                    break;

                case 99:
                    System.exit(2);
                    break;
            }
        }

        System.out.println();
    }

    public static void part2() {

        System.out.println("---------------- PART 2 -------------------");
        System.out.println();
    }


}
