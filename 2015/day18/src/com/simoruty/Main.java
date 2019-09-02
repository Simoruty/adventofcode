package com.simoruty;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = Common.readFromFile("./input");
        for (String s : input) {
            System.out.println(s);
        }

    }
}
