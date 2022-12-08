package com.simoruty.aoc2022;

import java.util.ArrayList;
import java.util.HashSet;

import static com.simoruty.aoc2022.Common.removeDuplicate;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> values = Common.readFromFile("./input");

        part1(values);
        part2(values);
    }

    private static void part1(ArrayList<String> values) {
        int tot =0;
        for (String value : values) {
            char first[] = value.substring(0,value.length()/2).toCharArray();
            char second[] = value.substring(value.length()/2).toCharArray();
            HashSet<Character> firstChars = removeDuplicate(first, first.length);
            HashSet<Character> secondChars = removeDuplicate(second, second.length);

            Character common = null;
            for (Character firstChar : firstChars) {
                if (secondChars.contains(firstChar)) {
                    common = firstChar;
                    break;
                }
            }
            int valCommon = (int)(common);
            if (valCommon>97 && valCommon<=122)
                valCommon-=96;
            else if (valCommon>65 && valCommon<=90)
                valCommon-=38;
            //System.out.println("Common: " + common + " " + valCommon);
            tot+=valCommon;
        }
        System.out.println("Part1 result: " + tot);
    }

    private static void part2(ArrayList<String> values) {
        int tot = 0;

        for (int i=0;i<values.size();i=i+3) {
            char first[] = values.get(i).toCharArray();
            char second[] = values.get(i+1).toCharArray();
            char third[] = values.get(i+2).toCharArray();
            HashSet<Character> firstChars = removeDuplicate(first, first.length);
            HashSet<Character> secondChars = removeDuplicate(second, second.length);
            HashSet<Character> thirdChars = removeDuplicate(third, third.length);

            Character common = null;
            for (Character firstChar : firstChars) {
                if (secondChars.contains(firstChar) && thirdChars.contains(firstChar)) {
                    common = firstChar;
                    break;
                }
            }
            int valCommon = (int) (common);
            if (valCommon > 97 && valCommon <= 122)
                valCommon -= 96;
            else if (valCommon > 65 && valCommon <= 90)
                valCommon -= 38;
            //System.out.println("Common: " + common + " " + valCommon);
            tot += valCommon;
        }
        System.out.println("Part2 result: " + tot);
    }
}