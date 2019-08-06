package com.simoruty;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String input = "To continue, please consult the code grid in the manual.  Enter the code at row 3010, column 3019.";

        int row = Integer.parseInt(input.split("\\D+")[1]);
        int col = Integer.parseInt(input.split("\\D+")[2]);
        System.out.println(codeMatrix(row, col));
    }

    private static ArrayList<Long> val = new ArrayList<Long>();

    /*

           | 1   2   3   4   5   6
        ---+---+---+---+---+---+---+
         1 |  1   3   6  10  15  21
         2 |  2   5   9  14  20
         3 |  4   8  13  19
         4 |  7  12  18
         5 | 11  17
         6 | 16

         */
    private static long codeMatrix(int row, int col) {
        int count = 0;
        int maxRow = row * 2;
        if (row < col)
            maxRow = col * 2;
        for (int i = 0; i < maxRow; i++) {
            int j = 0;
            int z = i;
            while (j != i) {
                z--;
                if (count == 0)
                    val.add(20151125L);
                else
                    val.add((val.get(count - 1) * 252533) % 33554393);
                if (z == row - 1 && j == col - 1)
                    return val.get(count);
                count++;
                j++;
            }
        }
        return 0;
    }
}