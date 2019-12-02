package com.simoruty;

import java.util.ArrayList;

public class Parts {

    private static int fuelReq(int mass) {
        return Math.round(mass / 3) - 2;
    }

    public static void part1(ArrayList<Integer> assignment) {
        int tot = 0;
        for (int val : assignment) {
            //System.out.println(val + " " + Part1.fuelReq(val));
            tot += Parts.fuelReq(val);
        }
        System.out.println("---------------- PART 1 -------------------");
        System.out.println("The sum of the fuel requirements is " + tot);
        System.out.println();
    }

    public static void part2(ArrayList<Integer> assignment) {
        int tot =0;
        for (int val : assignment) {
            ArrayList<Integer> rest = new ArrayList<>();
            int temp = fuelReq(val);
            while (temp > 0) {
                rest.add(temp);
                temp = fuelReq(temp);
            }

            int totVal = 0;
            for (int res : rest) {
                totVal += res;
            }

            tot += totVal;
        }
        System.out.println("---------------- PART 2 -------------------");
        System.out.println("The sum of the fuel requirements is " + tot);
    }
}
