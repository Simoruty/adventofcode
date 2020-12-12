package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {

    static ArrayList<Instruction> readFromFile(String path) {
        ArrayList<Instruction> actions = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Instruction instr = new Instruction(line.charAt(0), Integer.parseInt(line.replaceAll("[^0-9]", "")));
                actions.add(instr);
            }
            return actions;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}