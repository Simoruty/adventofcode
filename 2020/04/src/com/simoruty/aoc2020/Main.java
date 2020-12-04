package com.simoruty.aoc2020;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Passport> passports = Common.readFromFile("./test/input");
        System.out.println("Passports retrieved are " + passports.size());
        int count = 0;
        for (Passport passport : passports) {
            if (passport.isValid() && passport.isValidPart2())
                count++;
        }
        System.out.println("Passports valid are " + count);
    }
}
