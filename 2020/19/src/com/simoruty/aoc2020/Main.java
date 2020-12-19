package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Integer, String> memo = new HashMap<>();

    public static void main(String[] args) {
        String path = "./test/input";
        HashMap<Integer, String> rules = Common.readRules(path);
        ArrayList<String> solutions = Common.readSolutions(path);

        assert solutions != null;
        System.out.println("Part1: " + countSolution(rules, solutions, true));
        System.out.println("Part2: " + countSolution(rules, solutions, false));
    }

    public static int countSolution(HashMap<Integer, String> rules, ArrayList<String> solutions, boolean part1) {
        memo = new HashMap<>();
        String regex;
        if (part1)
            regex = "^" + getRegexPart1(0, rules) + "$";
        else
            regex = "^" + getRegexPart2(0, rules) + "$";

        //System.out.println(regex);
        int count = 0;
        for (String solution : solutions) {
            if (solution.matches(regex))
                count++;
        }
        return count;
    }

    public static String getRegexPart1(int rule, HashMap<Integer, String> rules) {
        if (memo.containsKey(rule)) return memo.get(rule);

        String ruleS = rules.get(rule);
        if (ruleS.contains("\"")) return ruleS.replaceAll("\"", "");

        StringBuilder sb = new StringBuilder("(");
        String[] parts = ruleS.split(" ");
        for (String part : parts)
            if (Character.isDigit(part.charAt(0))) {
                sb.append(getRegexPart1(Integer.parseInt(part), rules));
            } else if (part.equals("|"))
                sb.append('|');
        sb.append(')');
        memo.put(rule, sb.toString());

        return sb.toString();
    }

    public static String getRegexPart2(int rule, HashMap<Integer, String> rules) {
        if (memo.containsKey(rule)) return memo.get(rule);

        /*
            Substitute rules 8 and 11 with:

            8: 42 | 42 8
            11: 42 31 | 42 11 31
         */

        if (rule == 8) {
            String rv = "(" + getRegexPart2(42, rules) + "+)";
            memo.put(8, rv);
            return rv;
        }

        if (rule == 11) {
            String r42 = getRegexPart2(42, rules);
            String r31 = getRegexPart2(31, rules);
            StringBuilder sb = new StringBuilder("(");
            for (int i = 1; i < 10; i++) {
                // if necessary to exclude the regex (|(((b(a(bb|ab)... instead of ((((b(a(bb|ab)...
                if (i > 1) sb.append('|');
                sb.append('(');
                for (int k = 0; k < i; k++) sb.append(r42);
                for (int k = 0; k < i; k++) sb.append(r31);
                sb.append(')');
            }
            sb.append(')');

            memo.put(11, sb.toString());
            return sb.toString();
        }

        String ruleS = rules.get(rule);

        if (ruleS.contains("\"")) return ruleS.replaceAll("\"", "");

        StringBuilder sb = new StringBuilder("(");
        String[] parts = ruleS.split(" ");
        for (String part : parts)
            if (Character.isDigit(part.charAt(0)))
                sb.append(getRegexPart2(Integer.parseInt(part), rules));
            else if (part.equals("|"))
                sb.append('|');
        sb.append(")");

        memo.put(rule, sb.toString());
        return sb.toString();
    }
}