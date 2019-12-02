package com.simoruty;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> assignment = Common.readFromFile("./assignment");
        Parts.part1(assignment);

        Parts.part2(assignment);

    }
}
