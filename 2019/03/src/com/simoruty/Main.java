package com.simoruty;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, ArrayList<String>> points = Common.readFromFile("./assignment");
        Parts.part1(points);
        Parts.part2(points);
    }
}
