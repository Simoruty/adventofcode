package com.simoruty;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> values = Common.readFromFile("../input");

        ArrayList<Integer> pattern = new ArrayList<>();
        pattern.add(0);
        pattern.add(1);
        pattern.add(0);
        pattern.add(-1);


        //Parts.part1(values,pattern);
        Parts.part2(values,pattern);
    }
}
