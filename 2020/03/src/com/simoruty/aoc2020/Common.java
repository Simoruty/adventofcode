package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Common {

    public static final int colSize = 31;
    public static final int rowSize = 323;

    static boolean[][] readFromFile(String path) {
        boolean[][] map = new boolean[rowSize][colSize];
        int rowCount = 0;
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                char[] row = scanner.nextLine().toCharArray();
                for (int i = 0; i < row.length; i++) {
                    if (row[i] == '#')
                        map[rowCount][i] = true;
                }
                rowCount++;
            }
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void printMap(boolean[][] map) {
        for (boolean[] booleans : map) {
            for (boolean aBoolean : booleans) {
                if (aBoolean)
                    System.out.print(" # ");
                else
                    System.out.print(" . ");
            }
            System.out.println();
        }
    }
}
