package com.simoruty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static ArrayList<String> readFromFile(String path) {
        ArrayList<String> lines = new ArrayList<String>();
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


    private static void part1() {
        ArrayList<String> linesInput = readFromFile("./input");

        int nice = 0;
        int naughty = 0;

        for (String str : linesInput) {
            if (niceStringRule1(str))
                nice++;
            else
                naughty++;
        }

        System.out.println("Strings nice is : " + nice);
        System.out.println("Strings naughty is : " + naughty);

        System.out.println("Tot strings is : " + linesInput.size());
    }

    private static boolean niceStringRule1(String str) {

        if (str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy"))
            return false;

        if (!str.matches(".*([a-zA-Z])\\1+.*"))
            return false;

        if (countVowelString(str) < 3)
            return false;

        return true;
    }

    private static int countVowelString(String str) {
        int count = 0;

        if (str.length() > 0) {
            Pattern vowelPattern = Pattern.compile("[aeiou]");
            Matcher vowelMatcher = vowelPattern.matcher(str);

            while (vowelMatcher.find())
                count++;
        }

        return count;
    }


    // PART 2

    private static void part2() {
        ArrayList<String> linesInput = readFromFile("./input2");

        int nice = 0;
        int naughty = 0;

        for (String str : linesInput) {
            if (niceStringRule2(str))
                nice++;
            else
                naughty++;
        }

        System.out.println("Strings nice is : " + nice);
        System.out.println("Strings naughty is : " + naughty);

        System.out.println("Tot strings is : " + linesInput.size());
    }


    private static boolean niceStringRule2(String str) {

        return prop1(str) && prop2(str);

    }

    /*

    It contains at least one letter which repeats with exactly one letter between them,
    like xyx, abcdefeghi (efe), or even aaa.

     */
    private static boolean prop2(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length-2; i++) {
            if (chars[i] == chars[i+2])
                return true;
        }
        return false;
    }

    // It contains a pair of any two letters that appears at least twice in the string without overlapping,
    // like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).

    private static boolean prop1(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length - 1 - 2; i++) {
            for (int j = i + 2; j < chars.length - 1; j++) {
                String str1 = chars[i] + String.valueOf(chars[i + 1]);
                String str2 = chars[j] + String.valueOf(chars[j + 1]);
                if (str1.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
