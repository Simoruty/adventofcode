package com.simoruty;

import java.util.HashMap;
import java.util.Map;

public class Part2 {

    private static Map<Integer,Integer> elfVisit = new HashMap<Integer, Integer>();

    public static void part2(int input) {
        int present = 0;
        int i = 0;
        while (present < input) {
            i++;
            present = presentHouse(i);
        }
        System.out.println("House " + i + " got " + presentHouse(i) + " presents.");
    }

    private static int elfVisitVal(int elf){
        if (!elfVisit.containsKey(elf)) {
            elfVisit.put(elf, 1);
            return 1;
        }
        return elfVisit.get(elf);
    }

    private static int presentHouse(int house) {
        int present = 0;
        for (int i = 1; i <= house; i++)
            if (house % i == 0 && elfVisitVal(i)<50){
                present += i * 11;
                elfVisit.put(i,elfVisit.get(i)+1);
            }
        return present;
    }
}
