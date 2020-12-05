package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> partitioning = Common.readFromFile("./test/input");
        assert partitioning != null;
        ArrayList<Integer> seatIds = new ArrayList<>(partitioning.size());
        for (String s : partitioning)
            seatIds.add(part1(s));
        System.out.println("The highest seat ID on a boarding pass is " + Collections.max(seatIds));
        System.out.println("The ID of my seat is " + part2(seatIds));
    }

    public static int part1(String part) {
        int row = 0;
        char[] parts = part.toCharArray();

        int rowMin = 0;
        int rowMax = 127;
        for (int i = 0; i < 7; i++) {
            if (parts[i] == 'F')
                rowMax = (rowMin + rowMax) / 2;
            if (parts[i] == 'B')
                rowMin = ((rowMin + rowMax) / 2) + 1;
        }
        if (rowMax == rowMin)
            row = rowMax;

        int colMin = 0;
        int colMax = 7;
        int col = 0;
        for (int i = 7; i < parts.length; i++) {
            if (parts[i] == 'L')
                colMax = (colMin + colMax) / 2;
            if (parts[i] == 'R')
                colMin = ((colMin + colMax) / 2) + 1;
        }
        if (colMax == colMin)
            col = colMax;
        //System.out.println(part+ ": Row "+row + " Col "+col + " : "+ (row*8+col));
        return row * 8 + col;
    }

    public static int part2(ArrayList<Integer> seatIds) {
        Collections.sort(seatIds);
        for (int i = seatIds.get(0); i < seatIds.get(seatIds.size() - 1); i++) {
            if (!seatIds.contains(i))
                return i;
        }
        return 0;
    }
}
