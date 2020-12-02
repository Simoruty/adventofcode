package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {
    static ArrayList<Policy> readFromFile(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            ArrayList<Policy> policies = new ArrayList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                int min = Integer.parseInt(line.substring(0, line.indexOf("-")));
                int max = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(" ")));
                char c = line.substring(line.indexOf(" ") + 1, line.indexOf(" ") + 2).charAt(0);
                String pwd = line.substring(line.indexOf(": ") + 2);
                Policy policy = new Policy(min, max, c, pwd);
                policies.add(policy);
            }
            return policies;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
