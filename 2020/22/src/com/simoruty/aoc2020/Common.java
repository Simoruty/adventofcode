package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Common {

    static Game readGame(String path) {
        final Deque<Integer> player1 = new ArrayDeque<>();
        final Deque<Integer> player2 = new ArrayDeque<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            scanner.nextLine();
            String line = scanner.nextLine();
            while (!line.contains("Player 2:") && !line.isEmpty()) {
                player1.add(Integer.parseInt(line));
                line = scanner.nextLine();
            }

            scanner.nextLine();

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                player2.add(Integer.parseInt(line));
            }

            return new Game(player1, player2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}