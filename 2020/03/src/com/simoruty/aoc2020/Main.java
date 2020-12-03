package com.simoruty.aoc2020;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        boolean[][] map = Common.readFromFile("./test/input");
        assert map != null;
        Common.printMap(map);
        System.out.println("[PART1] Tree visited is : " + part1(map));
        System.out.println("[PART2] Tree visited is : " + part2(map));
    }

    public static int part1(boolean[][] map) {
        int count = 0;
        int coordCol = 0;
        int coordRow = 0;

        while (coordRow + 1 < Common.rowSize) {
            coordRow++;
            coordCol = (coordCol + 3) % Common.colSize;
            if (map[coordRow][coordCol])
                count++;
        }
        return count;
    }

    public static BigInteger part2(boolean[][] map) {
        int coordCol = 0;
        int coordRow = 0;
        ArrayList<BigInteger> counts = new ArrayList<>(5);

        ArrayList<Integer> moveRight = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 1));
        ArrayList<Integer> moveDown = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2));

        int i = 0;
        int count = 0;
        while (i < moveDown.size()) {
            coordRow = coordRow + moveDown.get(i);
            coordCol = (coordCol + moveRight.get(i)) % Common.colSize;

            if (coordRow >= Common.rowSize) {
                coordRow = 0;
                coordCol = 0;
                i++;
                counts.add(BigInteger.valueOf(count));
                count = 0;
            }
            if (map[coordRow][coordCol])
                count++;
        }

        return counts.stream().reduce(BigInteger.ONE, BigInteger::multiply);
    }
}