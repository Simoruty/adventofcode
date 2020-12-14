package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Common {

    static ArrayList<Bitmask> readFromFile(String path) {
        ArrayList<Bitmask> bitmasks = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            Bitmask bitmask = null;
            HashMap<Integer, Integer> memory = null;
            ArrayList<Integer> order = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains("mask")) {
                    if (memory != null) bitmask.setMemory(memory);
                    if (bitmask != null) bitmasks.add(bitmask);
                    if (order != null) bitmask.setOrder(order);

                    bitmask = new Bitmask();
                    memory = new HashMap<>();
                    order = new ArrayList<>();
                    HashMap<Integer, Integer> mask = new HashMap<>();
                    char[] maskChar = line.substring(line.indexOf("= ") + 2).toCharArray();
                    for (int i = 0; i < maskChar.length; i++) {
                        char c = maskChar[i];
                        if (c != 'X')
                            if (c == '0') mask.put(i, 0);
                            else mask.put(i, 1);
                    }
                    bitmask.setMask(mask);
                } else {
                    String[] split = line.replace("mem[", "").replace("] = ", " ").split(" ");
                    assert memory != null;
                    memory.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                    order.add(Integer.parseInt(split[0]));
                }
            }
            if (memory != null) bitmask.setMemory(memory);
            if (bitmask != null) bitmasks.add(bitmask);
            if (order != null) bitmask.setOrder(order);

            return bitmasks;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}