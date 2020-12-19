package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Common {

    static HashMap<Integer, String> readRules(String path) {
        HashMap<Integer, String> rules = new HashMap<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            String line = scanner.nextLine();
            while (!line.isEmpty()) {
                rules.put(Integer.parseInt(line.split(": ")[0]),line.split(": ")[1]);
                line = scanner.nextLine();
            }
            return rules;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<String> readSolutions(String path) {
        ArrayList<String> solutions = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (!scanner.nextLine().isEmpty()){}
            while (scanner.hasNextLine())
                solutions.add(scanner.nextLine());
            return solutions;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}