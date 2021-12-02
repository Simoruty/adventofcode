package com.simoruty.aoc2021;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {
    static ArrayList<Integer> readFromFile(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            ArrayList<Integer> list = new ArrayList<>();
            while (scanner.hasNextInt()) list.add(scanner.nextInt());
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
