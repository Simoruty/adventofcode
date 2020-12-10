package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Common {

    static ArrayList<Integer> readFromFile(String path) {
        ArrayList<Integer> jolts = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                jolts.add(Integer.parseInt(scanner.nextLine()));
            }

            jolts.add(0);
            Collections.sort(jolts);
            jolts.add(jolts.get(jolts.size() - 1) + 3);

            return jolts;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
