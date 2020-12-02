package com.simoruty.aoc2020;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Policy> policies = Common.readFromFile("./test/input.txt");
        assert policies != null;
        System.out.println("[PART1] pwds valid is " + part1(policies));
        System.out.println("[PART2] pwds valid is " + part2(policies));
    }

    private static int part1(ArrayList<Policy> policies) {
        int valid = 0;
        for (Policy policy : policies) {
            long count = policy.getPwd().chars().filter(ch -> ch == policy.getCharToCheck()).count();
            if (count >= policy.getMin() && count <= policy.getMax())
                valid++;
        }
        return valid;
    }

    private static int part2(ArrayList<Policy> policies) {
        int valid = 0;
        for (Policy policy : policies) {
            char c = policy.getCharToCheck();
            String pwd = policy.getPwd();
            char c1 = pwd.substring(policy.getMin() - 1, policy.getMin()).charAt(0);
            char c2 = pwd.substring(policy.getMax() - 1, policy.getMax()).charAt(0);
            if (c1 != c2 && (c1 == c || c2 == c))
                valid++;
        }
        return valid;
    }
}
