package com.simoruty;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> values = Common.readFromFile("../input");
        Parts.part1(values);
    }
}
