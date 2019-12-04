package com.simoruty;

import java.util.Arrays;

public class Parts {

    public static void part1(Integer[] rangePwd) {
        System.out.println("---------------- PART 1 -------------------");

        int countPwdApproved = 0;

        for (int pwd = rangePwd[0]; pwd <= rangePwd[1]; pwd++) {
            if (check(pwd))
                countPwdApproved++;
        }

        System.out.println("["+rangePwd[0]+" - "+rangePwd[1]+"] The Result is " + countPwdApproved);
        System.out.println();
    }

    private static boolean check(int pwd) {
        char[] chars = ("" + pwd).toCharArray();

        //It is a six-digit number
        if (chars.length != 6) return false;

        //Two adjacent digits are the same
        int i=0;
        while ( i < chars.length-1 && chars[i]!=chars[i+1]) i++;
        if (i>=chars.length-1) return false;

        //Going from left to right, the digits never decrease; they only ever increase or stay the same
        for (int j=0; j<chars.length-1; j++) {
            if (chars[j]>chars[j+1])
                return false;
        }
        //System.out.println("True: " + String.copyValueOf(chars));
        return true;
    }


    private static boolean check2(int pwd) {
        char[] chars = ("" + pwd).toCharArray();

        //System.out.println("Checking: " + String.copyValueOf(chars));
        //It is a six-digit number
        if (chars.length != 6) return false;

        //Two adjacent digits are the same
        char top = chars[0];
        char tocheck = Character.MAX_VALUE;
        boolean checkDouble = false;
        boolean checkTriple = false;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if(checkTriple && c != tocheck)
                return false;
            else if (checkTriple)
                checkTriple = false;
            else if (c == tocheck)
                checkTriple = true;
            else if (top == c) {
                tocheck = top;
                checkDouble = true;
            }

            top = chars[i];
        }

        if (!checkDouble || checkTriple) return false;

        //Going from left to right, the digits never decrease; they only ever increase or stay the same
        for (int j=0; j<chars.length-1; j++) {
            if (chars[j]>chars[j+1])
                return false;
        }
        //System.out.println("True: " + String.copyValueOf(chars));
        return true;
    }

    public static void part2(Integer[] rangePwd) {

        System.out.println("---------------- PART 2 -------------------");
        int countPwdApproved = 0;

        for (int pwd = rangePwd[0]; pwd <= rangePwd[1]; pwd++) {
            if (check2(pwd))
                countPwdApproved++;
        }

        System.out.println("["+rangePwd[0]+" - "+rangePwd[1]+"] The Result is " + countPwdApproved);
        System.out.println();
    }

}
