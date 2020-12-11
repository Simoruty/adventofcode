package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {

    static ArrayList<ArrayList<Integer>> readFromFile(String path) {
        ArrayList<ArrayList<Integer>> seats = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                ArrayList<Integer> seatsRow = new ArrayList<>();
                char[] seat = scanner.nextLine().toCharArray();
                for (char c : seat) {
                    if (c == 'L')
                        seatsRow.add(0);
                    else
                        seatsRow.add(-1);
                }
                seats.add(seatsRow);
            }
            return seats;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}