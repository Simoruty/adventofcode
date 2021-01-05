package com.simoruty.aoc2020;

import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        String path = "./test/input";
        Game game = Common.readGame(path);
        assert game != null;
        System.out.println(game);

        System.out.println(getPart1Sol(game));
    }

    public static long getPart1Sol(Game game) {

        Deque<Integer> player1 = game.getPlayer1();
        Deque<Integer> player2 = game.getPlayer2();
        int round = 1;
        while (!player1.isEmpty() && !player2.isEmpty()) {
            printRound(round, player1, player2);

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
        return score(player1) + score(player2);
    }

    private static long score(Deque<Integer> player) {
        long score = 0;
        while (!player.isEmpty()) {
            score += (long) player.size() * player.pop();
        }
        return score;
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
