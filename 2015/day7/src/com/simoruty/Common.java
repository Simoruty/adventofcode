package com.simoruty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static com.simoruty.Main.queue;
import static com.simoruty.Main.wire;

public class Common {

    public static int operator(int x, int y, String op) {
        switch (op) {
            case "AND":
                return andOperator(x, y);
            case "OR":
                return orOperator(x, y);
            case "LSHIFT":
                return lSHIFTOperator(x, y);
            case "RSHIFT":
                return rSHIFTOperator(x, y);
        }
        return 0;
    }


    public static ArrayList<String> readFromFile(String path) {
        ArrayList<String> lines = new ArrayList<>();
        try {

            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;

            while ((readLine = b.readLine()) != null) {
                lines.add(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static int andOperator(int x, int y) {
        return x & y;
    }

    private static int orOperator(int x, int y) {
        return x | y;
    }

    private static int lSHIFTOperator(int x, int y) {
        return x << y;
    }

    private static int rSHIFTOperator(int x, int y) {
        return x >> y;
    }

    private static int notOperator(int x) {
        return ~x;
    }

    public static boolean isInteger(String s) {
        return isInteger(s, 10);
    }

    private static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }


    public static void logicOperation(String input, String op) {
        input = input.replaceAll(" ", "");
        String leftOp = input.split("->")[0];
        String rightOp = input.split("->")[1];

        if (op.equals("NONE")){
            wire.put(rightOp, Integer.parseInt(leftOp));
            return;
        }

        if (op.equals("NOT")) {

            String op1 = leftOp.split(op)[1];

            if (wire.containsKey(op1)) {
                int op1Val = wire.get(op1);
                wire.put(rightOp, Common.notOperator(op1Val));
            } else if (isInteger(op1)) {
                wire.put(rightOp, Common.notOperator(Integer.parseInt(op1)));
            } else {
                wire.put(op1, 0);
                queue.add(input);
            }
            return;
        }

        String op1 = leftOp.split(op)[0];
        String op2 = leftOp.split(op)[1];

        if (wire.containsKey(op1) && wire.containsKey(op2)) {
            int op1Val = wire.get(op1);
            int op2Val = wire.get(op2);
            wire.put(rightOp, operator(op1Val, op2Val, op));

        } else if (Common.isInteger(op1) && wire.containsKey(op2)) {
            int op2Val = wire.get(op2);
            wire.put(rightOp, operator(Integer.parseInt(op1), op2Val, op));

        } else if (Common.isInteger(op2) && wire.containsKey(op1)) {
            int op1Val = wire.get(op1);
            wire.put(rightOp, operator(op1Val, Integer.parseInt(op2), op));

        } else if (Common.isInteger(op1) && Common.isInteger(op2)) {
            wire.put(rightOp, operator(Integer.parseInt(op1), Integer.parseInt(op2), op));

        } else {
            wire.put(op1, 0);
            wire.put(op2, 0);
            queue.add(input);
        }
    }
}