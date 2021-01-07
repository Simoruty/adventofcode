package com.simoruty.aoc2020;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String path = "./test/input";
        Game game = Common.readGame(path);
        assert game != null;
        System.out.println(game);

        System.out.println("Part1: " + getPart1Sol(game));
        System.out.println("Part2: " + getPart2Sol(game));
    }

    public static long getPart2Sol(Game game) {
        final Deque<Integer> player1 = game.getPlayer1();
        final Deque<Integer> player2 = game.getPlayer2();
        final Deque<Integer> winner = new ArrayDeque<>();
        getWinner(player1, player2, winner, player1.size(), player2.size());

        //printRound(0,player1,player2);
        return getScore(winner);
    }

    public static long getPart1Sol(Game game) {
        final Deque<Integer> player1 = game.getPlayer1();
        final Deque<Integer> player2 = game.getPlayer2();
        int round = 1;
        while (!player1.isEmpty() && !player2.isEmpty()) {
            //printRound(round, player1, player2);

            int val1 = player1.pop();
            int val2 = player2.pop();

            if (val1 > val2) {
                player1.addLast(val1);
                player1.addLast(val2);

            } else {
                player2.addLast(val2);
                player2.addLast(val1);
            }
            round++;
        }

        printRound(round, player1, player2);
        return getScore(player1) + getScore(player2);
    }

    private static long getScore(Deque<Integer> player) {
        long score = 0;
        while (!player.isEmpty())
            score += (long) player.size() * player.pop();
        return score;
    }

    private static Deque<Integer> getWinner(Deque<Integer> player1, Deque<Integer> player2, Deque<Integer> winner, int l1, int l2) {
        final Deque<Integer> d1 = new ArrayDeque<>(player1);
        final Deque<Integer> d2 = new ArrayDeque<>(player2);

        for (int i = player1.size() - l1; i > 0; i--) d1.removeLast();
        for (int i = player2.size() - l2; i > 0; i--) d2.removeLast();

        final Set<String> history = new HashSet<>();
        while (!d1.isEmpty() && !d2.isEmpty()) {
            final String hash = d1.toString() + d2.toString();
            if (!history.add(hash)) return player1;

            final int c1 = d1.removeFirst();
            final int c2 = d2.removeFirst();
            if (d1.size() >= c1 && d2.size() >= c2)
                if (getWinner(d1, d2, null, c1, c2) == d1) {
                    d1.addLast(c1);
                    d1.addLast(c2);
                } else {
                    d2.addLast(c2);
                    d2.addLast(c1);
                }
            else if (c1 > c2) {
                d1.addLast(c1);
                d1.addLast(c2);
            } else {
                d2.addLast(c2);
                d2.addLast(c1);
            }
        }

        if (winner != null)
            winner.addAll(d2.isEmpty() ? d1 : d2);

        return d2.isEmpty() ? player1 : player2;
    }


    private static void printRound(int round, Deque<Integer> p1, Deque<Integer> p2) {

        if (!p1.isEmpty() && !p2.isEmpty()) {

        /*
            -- Round 1 --
            Player 1's deck: 9, 2, 6, 3, 1
            Player 2's deck: 5, 8, 4, 7, 10
            Player 1 plays: 9
            Player 2 plays: 5
            Player 1 wins the round!
         */

            int val1 = p1.peek();
            int val2 = p2.peek();

            System.out.println("-- Round " + round + " -- ");
            System.out.println("Player 1's deck:" + p1);
            System.out.println("Player 2's deck:" + p2);
            System.out.println("Player 1 plays:" + val1);
            System.out.println("Player 2 plays:" + val2);

            if (val1 > val2)
                System.out.println("Player 1 wins the round!");
            else
                System.out.println("Player 2 wins the round!");

        /*
        == Post-game results ==
                Player 1's deck:
                Player 2's deck: 3, 2, 10, 6, 8, 5, 9, 4, 7, 1

         */
        } else {
            System.out.println("== Post-game results after " + round + " rounds ==");
            System.out.println("Player 1's deck:" + p1);
            System.out.println("Player 2's deck:" + p2);
        }
    }
}
