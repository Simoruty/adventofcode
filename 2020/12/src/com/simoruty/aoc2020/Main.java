package com.simoruty.aoc2020;

import java.util.ArrayList;

public class Main {

    static int north = 0;
    static int east = 0;
    static int west = 0;
    static int south = 0;

    static int[] wayPoint = new int[]{1, 10, 0, 0}; // N,E,S,W

    public static void main(String[] args) {
        ArrayList<Instruction> actions = Common.readFromFile("./test/input");
        assert actions != null;
        System.out.println("Part1: " + part1(actions));
        System.out.println("Part2: " + part2(actions));
    }

    public static int part1(ArrayList<Instruction> actions) {

        char[] direction = {'N', 'E', 'S', 'W'};
        int i = 1;
        char currentDir = direction[i];
        for (Instruction action : actions) {
            int value = action.getValue();

            switch (action.getDirection()) {
                case 'L':
                    i = Math.floorMod((i - value / 90), direction.length);
                    currentDir = direction[i];
                    break;
                case 'R':
                    i = Math.floorMod((i + value / 90), direction.length);
                    currentDir = direction[i];
                    break;
                case 'F':
                    inc(currentDir, value);
                    break;
                default:
                    inc(action.getDirection(), value);
            }
        }
        return manhattanDistance();
    }

    public static void inc(char dir, int value) {
        switch (dir) {
            case 'N':
                while (value > 0)
                    if (south > 0) {
                        south--;
                        value--;
                    } else {
                        north += value;
                        value = 0;
                    }
            case 'S':
                while (value > 0)
                    if (north > 0) {
                        north--;
                        value--;
                    } else {
                        south += value;
                        value = 0;
                    }
            case 'E':
                while (value > 0)
                    if (west > 0) {
                        west--;
                        value--;
                    } else {
                        east += value;
                        value = 0;
                    }
            case 'W':
                while (value > 0)
                    if (east > 0) {
                        east--;
                        value--;
                    } else {
                        west += value;
                        value = 0;
                    }
        }
    }


    public static int part2(ArrayList<Instruction> actions) {
        for (Instruction action : actions)
            if (action.getDirection() == 'F')
                for (int i = 0; i < action.getValue(); i++) {
                    inc('N', wayPoint[0]);
                    inc('E', wayPoint[1]);
                    inc('S', wayPoint[2]);
                    inc('W', wayPoint[3]);
                }
            else incWayPoint(action.getDirection(), action.getValue());

        return manhattanDistance();
    }

    //sum of the absolute values of its east/west position and its north/south position
    private static int manhattanDistance() {
        if (east > 0)
            if (north > 0)
                return Math.abs(east) + Math.abs(north);
            else
                return Math.abs(east) + Math.abs(south);
        if (north > 0)
            return Math.abs(west) + Math.abs(north);
        else
            return Math.abs(west) + Math.abs(south);
    }

    public static void switchLeft(int[] wayPoint) {
        int tmp = wayPoint[0];
        System.arraycopy(wayPoint, 1, wayPoint, 0, 3);
        wayPoint[3] = tmp;
    }

    public static void switchRight(int[] wayPoint) {
        int tmp = wayPoint[3];
        System.arraycopy(wayPoint, 0, wayPoint, 1, 3);
        wayPoint[0] = tmp;
    }

    public static void incWayPoint(char dir, int value) {
        switch (dir) {
            case 'L':
                for (int i = 0; i < value / 90; i++)
                    switchLeft(wayPoint);
                break;
            case 'R':
                for (int i = 0; i < value / 90; i++)
                    switchRight(wayPoint);
                break;
            case 'N':
                while (value > 0)
                    if (wayPoint[2] > 0) {
                        wayPoint[2]--;
                        value--;
                    } else {
                        wayPoint[0] += value;
                        value = 0;
                    }
                break;
            case 'S':
                while (value > 0)
                    if (wayPoint[0] > 0) {
                        wayPoint[0]--;
                        value--;
                    } else {
                        wayPoint[2] += value;
                        value = 0;
                    }
                break;

            case 'E':
                while (value > 0)
                    if (wayPoint[3] > 0) {
                        wayPoint[3]--;
                        value--;
                    } else {
                        wayPoint[1] += value;
                        value = 0;
                    }
                break;
            case 'W':
                while (value > 0)
                    if (wayPoint[1] > 0) {
                        wayPoint[1]--;
                        value--;
                    } else {
                        wayPoint[3] += value;
                        value = 0;
                    }
                break;
        }
    }

}
