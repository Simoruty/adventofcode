package com.simoruty.aoc2020;

import java.util.ArrayList;

public class Main {

    public static boolean modified = true;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> seats = Common.readFromFile("./test/input");
        assert seats != null;
        part1(seats);
        part2(seats);
    }

    public static void part2(ArrayList<ArrayList<Integer>> seats) {
        modified = true;
        while (modified)
            seats = mutatePart2(seats);

        printBoard(seats);
        System.out.println("Part2: " + countSeatOccupated(seats));

    }

    public static void part1(ArrayList<ArrayList<Integer>> seats) {
        modified = true;
        while (modified)
            seats = mutatePart1(seats);
        printBoard(seats);
        System.out.println("Part1: " + countSeatOccupated(seats));

    }

    private static int countSeatOccupated(ArrayList<ArrayList<Integer>> seats) {
        int count = 0;
        for (ArrayList<Integer> seat : seats)
            for (Integer pos : seat)
                if (pos == 1)
                    count++;
        return count;
    }

    private static ArrayList<ArrayList<Integer>> mutatePart1(ArrayList<ArrayList<Integer>> seats) {
        ArrayList<ArrayList<Integer>> newSeats = new ArrayList<>(seats.size());

        for (ArrayList<Integer> seat : seats) {
            ArrayList<Integer> newSeatRow = new ArrayList<>(seat);
            newSeats.add(newSeatRow);
        }

        modified = false;
        for (int i = 0; i < seats.size(); i++) {
            for (int j = 0; j < seats.get(0).size(); j++) {
                if (seats.get(i).get(j) == 0 & countNeigh(seats, i, j) == 0) {
                    modified = true;
                    newSeats.get(i).set(j, 1);
                } else if (seats.get(i).get(j) == 1 & countNeigh(seats, i, j) >= 4) {
                    modified = true;
                    newSeats.get(i).set(j, 0);
                }
            }
        }
        return newSeats;
    }

    private static ArrayList<ArrayList<Integer>> mutatePart2(ArrayList<ArrayList<Integer>> seats) {
        ArrayList<ArrayList<Integer>> newSeats = new ArrayList<>(seats.size());

        for (ArrayList<Integer> seat : seats) {
            ArrayList<Integer> newSeatRow = new ArrayList<>(seat);
            newSeats.add(newSeatRow);
        }

        modified = false;
        for (int i = 0; i < seats.size(); i++) {
            for (int j = 0; j < seats.get(0).size(); j++) {
                if (seats.get(i).get(j) == 0 & countNeighPart2(seats, i, j) == 0) {
                    modified = true;
                    newSeats.get(i).set(j, 1);
                } else if (seats.get(i).get(j) == 1 & countNeighPart2(seats, i, j) >= 5) {
                    modified = true;
                    newSeats.get(i).set(j, 0);
                }
            }
        }
        return newSeats;
    }

    private static boolean checkLimits(ArrayList<ArrayList<Integer>> seats, int x, int y, int[] ints) {
        return x + ints[0] >= 0 && y + ints[1] >= 0 && x + ints[0] < seats.size() && y + ints[1] < seats.get(x).size();
    }

    private static int countNeighPart2(ArrayList<ArrayList<Integer>> seats, int x, int y) {
        int count = 0;
        int[][] dir = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        for (int[] ints : dir) {
            while (checkLimits(seats, x, y, ints) &&
                    seats.get(x + ints[0]).get(y + ints[1]) == -1) {
                if (ints[0] > 0)
                    ints[0]++;
                else if (ints[0] < 0)
                    ints[0]--;

                if (ints[1] > 0)
                    ints[1]++;
                else if (ints[1] < 0)
                    ints[1]--;

            }
            if (checkLimits(seats, x, y, ints) && seats.get(x + ints[0]).get(y + ints[1]) == 1)
                count++;
        }
        return count;
    }

    private static int countNeigh(ArrayList<ArrayList<Integer>> seats, int x, int y) {
        int count = 0;
        int[][] dir = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        for (int[] ints : dir) {
            if (checkLimits(seats, x, y, ints) && seats.get(x + ints[0]).get(y + ints[1]) == 1)
                count++;
        }
        return count;
    }

    private static void printBoard(ArrayList<ArrayList<Integer>> seats) {
        for (ArrayList<Integer> seat : seats) {
            for (Integer pos : seat) {
                switch (pos) {
                    case 0:
                        System.out.print("L");
                        break;
                    case 1:
                        System.out.print("#");
                        break;
                    case -1:
                        System.out.print(" ");
                        break;
                }
            }
            System.out.println();
        }
    }
}
