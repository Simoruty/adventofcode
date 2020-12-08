package com.simoruty.aoc2020;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Command> instructions = Common.readFromFile("./test/input");
        assert instructions != null;
        System.out.println(" Part 1: " + part1(instructions));
        System.out.println(" Part 2: " + part2(instructions));
    }

    static int part1(ArrayList<Command> instructions) {
        return Common.visit(instructions);
    }

    static int part2(ArrayList<Command> instructions) {

        Common.resetVisit(instructions);

        for (int i = 0; i < instructions.size(); i++) {

            ArrayList<Command> newInstr = new ArrayList<>();
            for (Command instruction : instructions) {
                newInstr.add(new Command(instruction.getOp(), instruction.getNum(), false));
            }

            if (instructions.get(i).getOp().equals("nop")) {
                newInstr.get(i).setOp("jmp");
                boolean check = Common.checkLoop(newInstr);
                if (!check) return Common.visit(newInstr);
            }

            if (instructions.get(i).getOp().equals("jmp")) {
                newInstr.get(i).setOp("nop");
                boolean check = Common.checkLoop(newInstr);
                if (!check) return Common.visit(newInstr);
            }
        }
        return 0;
    }
}
