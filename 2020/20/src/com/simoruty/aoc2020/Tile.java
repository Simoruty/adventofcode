package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Tile {
    private int id;
    private boolean[][] matrix = new boolean[10][10];
    private ArrayList<Integer> edgeVals = new ArrayList<>();

    public Tile(int id, boolean[][] matrix) {
        this.id = id;
        this.matrix = matrix;
    }

    public ArrayList<Integer> getEdgeVals() {
        return edgeVals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
        edgeVals = new ArrayList<>();
        edgeVals.addAll(getVals(side('U')));
        edgeVals.addAll(getVals(side('L')));
        edgeVals.addAll(getVals(side('R')));
        edgeVals.addAll(getVals(side('B')));
    }

    public Tile(){}

    @Override
    public String toString() {
        return "Tile "+ id + "\n" + printMatrix();
    }

    public String printMatrix(){
        StringBuilder result = new StringBuilder();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++)
                if (matrix[x][y])
                    result.append("#");
                else
                    result.append(".");
            result.append("\n");
        }
        return result.toString();
    }

    public boolean[] side (char sideName){
        boolean[] side = new boolean[matrix.length];
        switch (sideName){
            case 'U': //Up
                System.arraycopy(matrix[0], 0, side, 0, matrix.length);
                return side;
            case 'L': //Left
                for (int x = 0; x < matrix.length; x++)
                    side[x] = matrix[x][0];
                return side;
            case 'R': //Right
                for (int x = 0; x < matrix.length; x++)
                    side[x] = matrix[x][matrix.length-1];
                return side;
            case 'B': //Bottom
                System.arraycopy(matrix[matrix.length - 1], 0, side, 0, matrix.length);
                return side;
        }
        return null;
    }

    public void printSide(boolean[] sideBool){
        for (boolean b : sideBool)
            System.out.print(b ? '#' : '.');
        System.out.println();
    }

    public void flip(){
        boolean[] tmp;
        int x = 0;
        while (x<matrix.length/2){
            tmp = matrix[x];
            matrix[x] = matrix[matrix.length-x-1];
            matrix[matrix.length-x-1] = tmp;
            x++;
        }
    }

    public void rotate(int i){
        for (int j = 1; j <= i; j++) {
            boolean[][] copy = new boolean[matrix.length][matrix[0].length];
            for (int r = 0; r < copy.length; r++) {
                for (int c = 0; c < copy[0].length; c++) {
                    copy[r][c] = matrix[matrix.length - 1 - c][r];
                }
            }
            matrix = copy;
            edgeVals = new ArrayList<>();
            edgeVals.addAll(getVals(side('U')));
            edgeVals.addAll(getVals(side('L')));
            edgeVals.addAll(getVals(side('R')));
            edgeVals.addAll(getVals(side('B')));
        }
    }

    private static ArrayList<Integer> getVals(boolean[] d) {
        StringBuilder str = new StringBuilder();
        for (boolean b : d)
            if (b) str.append("1");
            else str.append("0");

        ArrayList<Integer> rv = new ArrayList<>();
        rv.add(Integer.valueOf(str.toString(), 2));
        rv.add(Integer.valueOf(str.reverse().toString(), 2));

        return rv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return id == tile.id && Arrays.equals(matrix, tile.matrix) && Objects.equals(edgeVals, tile.edgeVals);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, edgeVals);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }
}
