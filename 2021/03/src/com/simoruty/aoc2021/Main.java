package com.simoruty.aoc2021;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<Boolean>> matrix = Common.readFromFile("./input");
        part1(matrix);
        part2(matrix);
    }

    private static void part1(ArrayList<ArrayList<Boolean>> matrix) {
        StringBuilder gammaCommon = new StringBuilder();
        StringBuilder epsilonLeastCommon = new StringBuilder();
        for (int i = 0; i < matrix.get(0).size(); i++) {
            if (mostCommonValBool(matrix, i)) {
                gammaCommon.append("1");
                epsilonLeastCommon.append("0");
            } else {
                gammaCommon.append("0");
                epsilonLeastCommon.append("1");
            }
        }
        int gammaCommonDec = Integer.parseInt(String.valueOf(gammaCommon), 2);
        System.out.println(gammaCommon + ": " + gammaCommonDec);
        int epsilonLeastCommonDec = Integer.parseInt(String.valueOf(epsilonLeastCommon), 2);
        System.out.println(epsilonLeastCommon + ": " + epsilonLeastCommonDec);
        System.out.println("Part 1: " + epsilonLeastCommonDec * gammaCommonDec);
    }

    private static void part2(ArrayList<ArrayList<Boolean>> matrix) {
        int i = 0;
        int oxygenDec = 0, co2Dec = 0;
        ArrayList<ArrayList<Boolean>> oxygenMatrix = new ArrayList<>(matrix);
        ArrayList<ArrayList<Boolean>> co2Matrix = new ArrayList<>(matrix);

        while (i < matrix.get(0).size()) {
            boolean most = mostCommonValBool(oxygenMatrix, i);
            boolean least = !mostCommonValBool(co2Matrix, i);

            oxygenMatrix = removeMatrixVal(oxygenMatrix, most, i);
            co2Matrix = removeMatrixVal(co2Matrix, least, i);

            if (oxygenMatrix.size() == 1 && oxygenDec == 0) {
                String oxygen = convertArrayBoolString(oxygenMatrix.get(0));
                oxygenDec = Integer.parseInt(oxygen, 2);
                System.out.println(oxygen + ": " + oxygenDec);
            }

            if (co2Matrix.size() == 1 && co2Dec == 0) {
                String co2 = convertArrayBoolString(co2Matrix.get(0));
                co2Dec = Integer.parseInt(co2, 2);
                System.out.println(co2 + ": " + co2Dec);
            }

            i++;
        }
        System.out.println("Part2: " + co2Dec * oxygenDec);
    }

    private static ArrayList<ArrayList<Boolean>> removeMatrixVal(ArrayList<ArrayList<Boolean>> matrix, boolean val, int index) {
        ArrayList<ArrayList<Boolean>> newMatrix = new ArrayList<>();
        for (ArrayList<Boolean> booleans : matrix)
            if (val == booleans.get(index))
                newMatrix.add(booleans);
        return newMatrix;
    }

    private static boolean mostCommonValBool(ArrayList<ArrayList<Boolean>> matrix, int index) {
        int countTrue = 0;
        int countFalse = 0;
        for (ArrayList<Boolean> booleans : matrix)
            if (booleans.get(index))
                countTrue++;
            else
                countFalse++;
        if (countTrue >= countFalse)
            return true;
        return false;
    }


    private static String convertArrayBoolString(ArrayList<Boolean> booleans) {
        StringBuilder boolInt = new StringBuilder();
        for (Boolean aBoolean : booleans) {
            if (aBoolean)
                boolInt.append("1");
            else
                boolInt.append("0");
        }
        return boolInt.toString();
    }
}