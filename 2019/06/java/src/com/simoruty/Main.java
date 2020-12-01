package com.simoruty;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> values = Common.readFromFile("../inputtest");
        Parts.part1(values);
    }
}
