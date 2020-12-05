package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {

    static ArrayList<String> readFromFile(String path) {
        ArrayList<String> map = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNext())
                map.add(scanner.nextLine());
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
