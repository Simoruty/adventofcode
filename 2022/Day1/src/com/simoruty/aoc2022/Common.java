package com.simoruty.aoc2022;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {
    static ArrayList<Integer> readFromFile(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            String line;
            int tmp=0;
            ArrayList<Integer> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.isEmpty()) {
                    list.add(tmp);
                    tmp=0;
                }
                else
                    tmp+=Integer.parseInt(line);
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
