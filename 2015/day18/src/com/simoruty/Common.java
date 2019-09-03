package com.simoruty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Common {

    private static ArrayList<String> readFromFile(String path) {
        ArrayList<String> lines = new ArrayList<>();
        try {

            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;

            while ((readLine = b.readLine()) != null) {
                lines.add(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    static boolean[][] createMatrix(String path) {
        ArrayList<String> input = Common.readFromFile(path);
        int maxRow = input.get(0).length();
        int maxCol = input.size();

        boolean[][] matrix = new boolean[maxRow][maxCol];

        int curRow = 0;
        for (String s : input) {
            for (int i = 0; i < s.length(); i++) matrix[curRow][i] = s.charAt(i) == '#';
            curRow++;
        }
        return matrix;
    }

    static void printMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) System.out.print("# ");
                else System.out.print(". ");
            }
            System.out.println();
        }
    }

    static int lights(boolean[][] matrix) {
        int lights = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) lights++;
            }
        }
        return lights;
    }

    static boolean[][] fixCornerMatrix(boolean[][] matrix) {
        matrix[0][0] = true;
        matrix[0][matrix.length - 1] = true;
        matrix[matrix[0].length - 1][0] = true;
        matrix[matrix[0].length - 1][matrix.length - 1] = true;
        return matrix;
    }

    static boolean neighbors(boolean[][] matrix, int indexRow, int indexCol, boolean corner) {

        if (corner &&
                (indexCol == 0 && indexRow == 0) ||
                (indexCol == 0 && indexRow == matrix[0].length - 1) ||
                (indexCol == matrix.length - 1 && indexRow == 0) ||
                (indexCol == matrix.length - 1 && indexRow == matrix[0].length - 1))
            return true;

        int countOn = 0;
        for (int i = indexRow - 1; i <= indexRow + 1; i++) {
            for (int j = indexCol - 1; j <= indexCol + 1; j++) {
                if ((i >= 0 && i < matrix.length) && (j >= 0 && j < matrix[0].length)) {
                    if (matrix[i][j] && !(i == indexRow && j == indexCol)) countOn++;
                }
            }
        }

        //System.out.println(" La cella è " + indexRow + " col: " + indexCol + " è " + matrix[indexRow][indexCol] + " count: "+countOn);
        if (matrix[indexRow][indexCol]) {
            return countOn == 2 || countOn == 3;
        } else return countOn == 3;
    }
}
