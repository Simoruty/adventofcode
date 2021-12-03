package com.simoruty.aoc2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Common {
    static ArrayList<ArrayList<Boolean>> readFromFile(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            ArrayList<ArrayList<Boolean>> matrix = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<Boolean> row = Arrays.stream(line.split("")).map(Common::convertToBoolean).collect(Collectors.toCollection(ArrayList::new));
                matrix.add(row);
            }
            return matrix;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean convertToBoolean(String value) {
        boolean returnValue = false;
        if ("1".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value) ||
                "true".equalsIgnoreCase(value) || "on".equalsIgnoreCase(value))
            returnValue = true;
        return returnValue;
    }
}
