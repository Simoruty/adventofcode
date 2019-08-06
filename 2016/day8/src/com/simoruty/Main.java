package com.simoruty;

import java.util.ArrayList;

public class Main {

    //50 pixels wide and 6 pixels tall
    private static int MAXROW = 6;
    private static int MAXCOL = 50;
    private static boolean[][] matrix = new boolean[MAXROW][MAXCOL];

    private static int countTrue() {
        int tot = 0;
        for (int i = 0; i < MAXROW; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                if (matrix[i][j])
                    tot++;
            }
        }
        return tot;
    }

    private static void printMatrix() {
        for (int i = 0; i < MAXROW; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                if (matrix[i][j])
                    System.out.print("# ");
                else System.out.print(". ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        ArrayList<String> sequences = Common.readFromFile("./input");

        for (String seq : sequences) {
            if (seq.contains("rect")) {
                int width = Integer.parseInt(seq.split("\\D+")[1]);
                int height = Integer.parseInt(seq.split("\\D+")[2]);
                rect(width, height);
            }
            if (seq.contains("rotate column")) {
                int xstart = Integer.parseInt(seq.split("\\D+")[1]);
                int inc = Integer.parseInt(seq.split("\\D+")[2]);
                rotateColumn(xstart, inc);
            }
            if (seq.contains("rotate row")) {
                int ystart = Integer.parseInt(seq.split("\\D+")[1]);
                int inc = Integer.parseInt(seq.split("\\D+")[2]);
                rotateRow(ystart, inc);
            }
        }
        printMatrix();
        System.out.println("pixels lit are " + countTrue());
    }

    //rotate row y=0 by 3
    private static void rotateRow(int ystart, int inc) {
        matrix[ystart] = rotate(matrix[ystart], inc);
/*
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        System.out.println(a);
        Collections.rotate(a,2);
        System.out.println(a);
        */

    }

    private static boolean[] rotate(boolean[] row, int inc) {
        boolean[] newArray = new boolean[row.length];
        // copy
        for (int x = 0; x < row.length; x++) {
            newArray[(x + inc) % row.length] = row[x];
        }
        return newArray;
    }

    //rotate column x=5 by 1
    private static void rotateColumn(int xstart, int inc) {
        boolean[] col = getColumn(matrix, xstart);
        setColumn(rotate(col, inc), xstart);
    }

    public static boolean[] getColumn(boolean[][] array, int index) {
        boolean[] column = new boolean[MAXROW];
        for (int i = 0; i < column.length; i++) {
            column[i] = array[i][index];
        }
        return column;
    }

    public static void setColumn(boolean[] column, int index) {
        for (int i = 0; i < column.length; i++) {
            matrix[i][index] = column[i];
        }
    }

    //rect 1x1
    private static void rect(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = true;
            }
        }
    }


}
