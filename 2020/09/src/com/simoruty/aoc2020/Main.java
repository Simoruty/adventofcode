package com.simoruty.aoc2020;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        ArrayList<BigInteger> xmasNumbers = Common.readFromFile("./test/input");
        assert xmasNumbers != null;
        int preambleLength = 25;

        System.out.println("Part1: " + part1(xmasNumbers, preambleLength));
        System.out.println("Part2: " + part2(part1(xmasNumbers, preambleLength), xmasNumbers));
    }

    static BigInteger part1(ArrayList<BigInteger> xmasNumbers, int preambleLength) {

        for (int i = preambleLength; i < xmasNumbers.size(); i++) {
            BigInteger value = xmasNumbers.get(i);
            ArrayList<BigInteger> preamble = Common.createPreamble(xmasNumbers, preambleLength, i);
            if (!check(value, preamble))
                return value;
        }
        return BigInteger.valueOf(0);
    }

    static boolean check(BigInteger numtoCheck, ArrayList<BigInteger> preamble) {
        for (int i = 0; i < preamble.size(); i++) {
            for (int j = i + 1; j < preamble.size(); j++) {
                if (numtoCheck.equals(preamble.get(i).add(preamble.get(j)))) {
                    //System.out.println(numtoCheck + " = " + preamble.get(i)+ " + "+preamble.get(j));
                    return true;
                }
            }
        }
        return false;
    }

    static BigInteger part2(BigInteger toCheck, ArrayList<BigInteger> xmasNumbers) {
        int posMin = 0;
        int posMax = 0;
        int pos = 0;
        BigInteger temp = BigInteger.valueOf(0);

        while (!temp.equals(toCheck) && pos < xmasNumbers.size()) {
            temp = temp.add(xmasNumbers.get(pos));
            posMax = pos;
            if (temp.compareTo(toCheck) > 0) {
                posMin = posMin + 1;
                temp = xmasNumbers.get(posMin);
                pos = posMin;
            } else if (temp.equals(toCheck)) {
                break;
            }
            pos++;
        }
        BigInteger max = xmasNumbers.subList(posMin, posMax).stream().max(BigInteger::compareTo).orElseThrow(NoSuchElementException::new);
        BigInteger min = xmasNumbers.subList(posMin, posMax).stream().min(BigInteger::compareTo).orElseThrow(NoSuchElementException::new);
        //System.out.println("Min: " + min + " + Max: "+ max+ " = "+ max.add(min));
        return max.add(min);
    }
}
