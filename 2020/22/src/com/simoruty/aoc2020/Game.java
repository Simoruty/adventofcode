package com.simoruty.aoc2020;

import java.util.Deque;

public class Game {

    private final Deque<Integer> player1;
    private final Deque<Integer> player2;

    public Game(Deque<Integer> p1, Deque<Integer> p2) {
        player1 = p1;
        player2 = p2;
    }

    public Deque<Integer> getPlayer1() {
        return player1;
    }

    public Deque<Integer> getPlayer2() {
        return player2;
    }


    @Override
    public String toString() {
        return "Game{\n" +
                "player1=" + player1 +
                "\nplayer2=" + player2 +
                '}';
    }
}
