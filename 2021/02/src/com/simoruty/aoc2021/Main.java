package com.simoruty.aoc2021;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> values = Common.readFromFile("./input");
        //part1(values);
        part2(values);
    }

    private static void part1(ArrayList<String> values) {
        int horizValue=0;
        int depthValue=0;

        for (String value : values) {
            int val = Integer.parseInt(value.split("\\s+")[1]);
            switch (value.split("\\s+")[0]){
                case "forward":  horizValue+= val;
                break;
                case "up": depthValue -= val;
                break;
                case "down": depthValue += val;
            }
        }
        System.out.println("Horiz: " + horizValue);
        System.out.println("Dept: " + depthValue);

        System.out.println("Part1 result: "+ horizValue*depthValue);
    }

    private static void part2(ArrayList<String> values) {
        int horizValue=0;
        int depthValue=0;
        int aim=0;

        for (String value : values) {
            int val = Integer.parseInt(value.split("\\s+")[1]);
            switch (value.split("\\s+")[0]){
                case "forward":  horizValue+= val;
                    depthValue += aim*val;
                    break;
                case "up": aim -= val;
                    break;
                case "down": aim += val;
            }
        }
        System.out.println("Horiz: " + horizValue);
        System.out.println("Dept: " + depthValue);

        System.out.println("Part2 result: "+ horizValue*depthValue);
    }
}