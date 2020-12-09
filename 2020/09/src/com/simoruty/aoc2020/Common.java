package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Common {

    static ArrayList<BigInteger> readFromFile(String path) {
        ArrayList<BigInteger> xmasNumbers = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                xmasNumbers.add(new BigInteger(scanner.nextLine()));
            }
            return xmasNumbers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    static ArrayList<BigInteger> createPreamble(ArrayList<BigInteger> xmasNumbers, int preambleLength, int pos) {
        return IntStream.rangeClosed(1, preambleLength).mapToObj(i -> xmasNumbers.get(pos - i)).collect(Collectors.toCollection(() -> new ArrayList<>(preambleLength)));
    }
}
