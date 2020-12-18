package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> hws = Common.readhomeworkFromFile("./test/input");
        assert hws != null;
        System.out.println("Part1: " + doHomework(hws, true));
        System.out.println("Part2: " + doHomework(hws, false));
    }

    public static long doHomework(ArrayList<String> hws, boolean part1) {
        Stack<List<String>> stack = new Stack<>();
        List<String> workingLine = new ArrayList<>();
        long results = 0;

        for (String hw : hws) {
            String[] line = hw.split("");
            for (String token : line)
                if (token.equals("(")) {
                    stack.push(workingLine);
                    workingLine = new ArrayList<>();
                } else if (token.equals(")")) {
                    stack.peek().add("" + evalLine(workingLine, part1));
                    workingLine = stack.pop();
                } else
                    workingLine.add(token);

            if (!stack.isEmpty())
                throw new IllegalStateException("Expression wrong: " + hw);

            long result = evalLine(workingLine, part1);
            workingLine = new ArrayList<>();
            //System.out.println(hw + " = " + result);
            results += result;
        }
        return results;
    }

    private static long evalLinePart1(List<String> line) {
        long total = Long.parseLong(line.get(0));
        for (int i = 1; i < line.size(); ++i) {
            String current = line.get(i);
            if (current.equals("+") || current.equals("-") || current.equals("*")) {
                long rightOperand = Long.parseLong(line.get(i + 1));
                total = evalOp(total, rightOperand, current);
            }
        }
        return total;
    }


    private static long evalLinePart2(List<String> line) {
        ArrayList<String> exprMulti = new ArrayList<>();
        for (int i = 0; i < line.size(); i++) {
            String current = line.get(i);
            if (current.equals("+") || current.equals("-")) {
                int lastTokenIndex = exprMulti.size() - 1;
                long leftOperand = Long.parseLong(exprMulti.remove(lastTokenIndex));
                long rightOperand = Long.parseLong(line.get(i + 1));
                exprMulti.add("" + evalOp(leftOperand, rightOperand, current));
                i++;
            } else
                exprMulti.add(current);
        }
        // the new expr contain only a multiplication operator
        return evalLinePart1(exprMulti);
    }

    public static long evalLine(List<String> line, boolean part1) {
        if (part1)
            return evalLinePart1(line);
        return evalLinePart2(line);
    }

    public static long evalOp(long left, long right, String operator) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            default:
                throw new IllegalStateException("Unexpected operator: " + operator);
        }
    }
}
