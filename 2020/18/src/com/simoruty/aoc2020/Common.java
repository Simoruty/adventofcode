package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {

    static ArrayList<String> readhomeworkFromFile(String path) {
        ArrayList<String> espr = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                espr.add(scanner.nextLine().replaceAll(" ", ""));
            }
            return espr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}