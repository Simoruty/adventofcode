package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {

    static ArrayList<Command> readFromFile(String path) {
        ArrayList<Command> instructions = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                instructions.add(new Command(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]), false));
            }
            return instructions;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    static int visit(ArrayList<Command> instructions) {
        int count = 0;
        int pos = 0;

        resetVisit(instructions);

        while (pos < instructions.size() && !instructions.get(pos).isVisited()) {
            instructions.get(pos).setVisited(true);
            switch (instructions.get(pos).getOp()) {
                case "acc":
                    count += instructions.get(pos).getNum();
                    pos++;
                    break;
                case "nop":
                    pos++;
                    break;
                case "jmp":
                    pos += instructions.get(pos).getNum();
            }
        }
        return count;
    }

    static boolean checkLoop(ArrayList<Command> instructions) {
        resetVisit(instructions);

        int pos = 0;
        while (pos < instructions.size()) {
            if (instructions.get(pos).isVisited())
                return true;
            instructions.get(pos).setVisited(true);
            if ("jmp".equals(instructions.get(pos).getOp())) {
                pos += instructions.get(pos).getNum();
            } else
                pos++;
        }
        return false;
    }

    static ArrayList<Command> resetVisit(ArrayList<Command> instructions) {
        for (Command instruction : instructions)
            instruction.setVisited(false);
        return instructions;
    }
}
