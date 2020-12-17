package com.simoruty.aoc2020;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> values = Common.readFromFile("./test/input");
        assert values != null;
        System.out.println("Part1: " + part1(values));
        System.out.println("Part2: " + part2(values));
    }

    public static int part1(ArrayList<String> values) {
        int max = values.size() + 26;
        char[][][] grid;
        grid = new char[max][max][max]; //z y x

        // init all cubes to inactive (.)
        for (int z = 0; z < grid.length; z++) {
            for (int y = 0; y < grid[0].length; y++) {
                for (int x = 0; x < grid[0][0].length; x++) {
                    grid[z][y][x] = '.';
                }
            }
        }

        int midGrid = grid.length / 2;
        int midInputSize = values.size() / 2;
        // initialize z-layer middle
        for (int y = 0; y < values.size(); y++) {
            for (int x = 0; x < values.get(0).length(); x++) {
                char c = values.get(y).charAt(x);
                grid[midGrid - midInputSize][midGrid - midInputSize + y][midGrid + x] = c;
            }
        }

        for (int cycle = 0; cycle < 6; cycle++) {
            char[][][] tmp = new char[grid.length][grid.length][grid.length];
            for (int z = 0; z < grid.length; z++) {
                for (int y = 0; y < grid.length; y++) {
                    for (int x = 0; x < grid.length; x++) {
                        int activeNeighbors = countNeighPart1(grid, z, y, x);
                        if (grid[z][y][x] == '#') {
                            if (activeNeighbors == 2 || activeNeighbors == 3)
                                tmp[z][y][x] = '#';
                            else
                                tmp[z][y][x] = '.';

                        } else if (grid[z][y][x] == '.') {
                            if (activeNeighbors == 3)
                                tmp[z][y][x] = '#';
                            else
                                tmp[z][y][x] = '.';
                        }
                    }
                }
            }
            grid = tmp;
        }

        int active = 0;
        for (int z = 0; z < grid.length; z++) {
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid.length; x++) {
                    if (grid[z][y][x] == '#') {
                        active++;
                    }
                }
            }
        }
        return active;
    }

    public static int part2(ArrayList<String> values) {
        int max = values.size() + 26;
        char[][][][] grid;
        grid = new char[max][max][max][max]; // w z y x
        for (int w = 0; w < grid.length; w++)
            for (int z = 0; z < grid.length; z++)
                for (int y = 0; y < grid.length; y++)
                    for (int x = 0; x < grid.length; x++)
                        grid[w][z][y][x] = '.';

        int midGrid = grid.length / 2;
        int midInputSize = values.size() / 2;

        for (int z = 0; z < grid.length; z++)
            for (int y = 0; y < values.size(); y++)
                for (int x = 0; x < values.get(0).length(); x++) {
                    char c = values.get(y).charAt(x);
                    grid[midGrid - midInputSize][midGrid - midInputSize][midGrid - midInputSize + y][midGrid + x] = c;
                }

        for (int cycle = 0; cycle < 6; cycle++) {
            char[][][][] tmp = new char[grid.length][grid.length][grid.length][grid.length];
            for (int w = 0; w < grid.length; w++)
                for (int z = 0; z < grid.length; z++)
                    for (int y = 0; y < grid.length; y++)
                        for (int x = 0; x < grid.length; x++) {
                            int activeNeighbors = countNeighPart2(grid, w, z, y, x);
                            if (grid[w][z][y][x] == '#') {
                                if (activeNeighbors == 2 || activeNeighbors == 3)
                                    tmp[w][z][y][x] = '#';
                                else
                                    tmp[w][z][y][x] = '.';

                            } else if (grid[w][z][y][x] == '.')
                                if (activeNeighbors == 3)
                                    tmp[w][z][y][x] = '#';
                                else
                                    tmp[w][z][y][x] = '.';
                        }
            grid = tmp;
        }

        int active = 0;
        for (int w = 0; w < grid.length; w++)
            for (int z = 0; z < grid.length; z++)
                for (int y = 0; y < grid.length; y++)
                    for (int x = 0; x < grid.length; x++)
                        if (grid[w][z][y][x] == '#')
                            active++;

        return active;
    }

    private static int countNeighPart1(char[][][] grid, int z, int y, int x) {
        int count = 0;

        for (int zi = -1; zi <= 1; zi++)
            for (int yi = -1; yi <= 1; yi++)
                for (int xi = -1; xi <= 1; xi++)
                    // Limits
                    if (z + zi >= 0 && y + yi >= 0 && x + xi >= 0)
                        if (z + zi < grid.length && y + yi < grid.length && x + xi < grid.length)
                            // Current position
                            if (!(zi == 0 && yi == 0 && xi == 0))
                                if (grid[z + zi][y + yi][x + xi] == '#')
                                    count++;
        return count;
    }

    private static int countNeighPart2(char[][][][] grid, int w, int z, int y, int x) {
        int count = 0;

        for (int wi = -1; wi <= 1; wi++)
            for (int zi = -1; zi <= 1; zi++)
                for (int yi = -1; yi <= 1; yi++)
                    for (int xi = -1; xi <= 1; xi++)
                        // Limits
                        if (w + wi >= 0 && z + zi >= 0 && y + yi >= 0 && x + xi >= 0)
                            if (w + wi < grid.length && z + zi < grid.length && y + yi < grid.length && x + xi < grid.length)
                                // Current position
                                if (!(wi == 0 && zi == 0 && yi == 0 && xi == 0))
                                    if (grid[w + wi][z + zi][y + yi][x + xi] == '#')
                                        count++;
        return count;
    }

}
