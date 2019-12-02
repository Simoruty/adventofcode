package com.simoruty;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> values = Common.readFromFile("./assignment");
        Parts.part1(values);
        Parts.part2();
    }
}
