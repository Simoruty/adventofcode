package com.simoruty;

public class Main {

    public static void main(String[] args) {
        boolean[][] matrix = Common.createMatrix("./input");
        //System.out.println("INIT STATE");
        //Common.printMatrix(matrix);

        Common.fixCornerMatrix(matrix);

        for (int z = 1; z <= 100; z++) {
            boolean[][] newMatrix = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    newMatrix[i][j] = Common.neighbors(matrix, i, j, true);
                }
            }
            matrix = newMatrix;
            //System.out.println("STEP " + z);
            //Common.printMatrix(matrix);
        }

        System.out.println("Lights is " + Common.lights(matrix));
    }

}
