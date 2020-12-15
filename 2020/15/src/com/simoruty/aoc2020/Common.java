package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Common {

    static ArrayList<Integer> readFromFile(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            return Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}