package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {

    static ArrayList<Tile> readTiles(String path) {
        ArrayList<Tile> tiles = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            Tile t = new Tile();
            boolean[][] matrix = new boolean[10][10];
            int x = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    t.setMatrix(matrix);
                    tiles.add(t);
                } else if (line.contains("Tile")) {
                    t = new Tile();
                    t.setId(Integer.parseInt(line.replaceAll("\\D", "")));
                    matrix = new boolean[10][10];
                    x = 0;
                } else {
                    char[] chars = line.toCharArray();
                    for (int y = 0; y < chars.length; y++) {
                        if (chars[y] == '#') {
                            matrix[x][y] = true;
                        }
                    }
                    x++;
                }
            }
            t.setMatrix(matrix);
            tiles.add(t);
            return tiles;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}