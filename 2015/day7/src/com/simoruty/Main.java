package com.simoruty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
       public static List<String> queue = new ArrayList<>();
       public static Map<String, Integer> wire = new HashMap<>();

    public static void main(String[] args) {

        byte[] val = {123};
        System.out.println(~val[0]);



        ArrayList<String> input = Common.readFromFile("./input");

        for (String test : input) {

            if (test.contains("AND")) {
                Common.logicOperation(test,"AND");

            } else if (test.contains("OR")) {
                Common.logicOperation(test,"OR");

            } else if (test.contains("LSHIFT")) {
                Common.logicOperation(test,"LSHIFT");

            } else if (test.contains("RSHIFT")) {
                Common.logicOperation(test,"RSHIFT");

            } else if (test.contains("NOT")) {
                Common.logicOperation(test,"NOT");

            } else {
                Common.logicOperation(test,"NONE");
            }

        }

        for (String s : wire.keySet()) {
            System.out.println("chiave: " + s + " value: " + wire.get(s));
        }
    }
}
