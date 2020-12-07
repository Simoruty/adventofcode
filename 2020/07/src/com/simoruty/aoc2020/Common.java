package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Common {

    static ArrayList<BagColor> readFromFile(String path) {
        ArrayList<BagColor> bagColors = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                String color = line.substring(0, line.indexOf("bags") - 1);
                HashMap<String, Integer> contained = new HashMap<>();

                String containedStr = line.substring(line.indexOf("contain") + 7);
                if (containedStr.contains(",")) {
                    for (String s : containedStr.split(",")) {
                        contained.put(s.split(" ")[2] + " " + s.split(" ")[3], Integer.parseInt(s.split(" ")[1]));
                    }
                } else if (!containedStr.contains("no other bags")) {
                    contained.put(containedStr.split(" ")[2] + " " + containedStr.split(" ")[3], Integer.parseInt(containedStr.split(" ")[1]));
                }
                BagColor bagColor = new BagColor(color, contained);
                bagColors.add(bagColor);
            }
            return bagColors;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
