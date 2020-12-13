package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class Common {

    static Departure readFromFile(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            Integer timestamp = Integer.parseInt(scanner.nextLine());
            ArrayList<Integer> busIds = new ArrayList<>();

            String busidsString = scanner.nextLine();

            stream(busidsString.split(",")).forEach(s -> {
                if (!s.equals("x"))
                    busIds.add(Integer.parseInt(s));
                else
                    busIds.add(-1);
            });

            return new Departure(timestamp, busIds);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}