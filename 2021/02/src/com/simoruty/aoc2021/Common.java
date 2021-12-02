package com.simoruty.aoc2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {
    static ArrayList<String> readFromFile(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            ArrayList<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) list.add(scanner.nextLine());
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
