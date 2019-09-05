package com.simoruty;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        task2();
    }

    private static void task2() {
        ArrayList<String> inputs = Common.readFromFile("./input");
        ArrayList<Reindeer> reindeers = Common.fillReindeers(inputs);
        int time = 2503;
        HashMap<Reindeer, Integer> classification = new HashMap<>();

        for (int i = 1; i <= time; i++) {
            int distanceWinner = 0;
            ArrayList<Reindeer> winnerTmp = new ArrayList<>();
            for (Reindeer reindeer : reindeers) {
                int distance = reindeer.distanceTraveledAfterTime(i);
                if (distance > distanceWinner) {
                    distanceWinner = distance;
                    winnerTmp = new ArrayList<>();
                    winnerTmp.add(reindeer);
                } else if (distance == distanceWinner) {
                    winnerTmp.add(reindeer);
                }

            }

            for (Reindeer reindeer : winnerTmp) {
                if (classification.containsKey(reindeer))
                    classification.put(reindeer, classification.get(reindeer) + 1);
                else
                    classification.put(reindeer, 1);
            }
        }

        int winnerPoint = 0;
        Reindeer winnerReindeer = null;
        for (Reindeer reindeer : classification.keySet()) {
            System.out.println(reindeer.getName() + " point: " + classification.get(reindeer));
            if (classification.get(reindeer) > winnerPoint) {
                winnerPoint = classification.get(reindeer);
                winnerReindeer = reindeer;
            }
        }

        System.out.println("\nThe winner is: " + winnerReindeer.getName() + " with " + winnerPoint + " points");
    }

    private static void task1() {
        ArrayList<String> inputs = Common.readFromFile("./input");
        ArrayList<Reindeer> reindeers = Common.fillReindeers(inputs);
        int time = 2503;

        Reindeer winner = null;
        int distanceWinner = 0;

        for (Reindeer reindeer : reindeers) {
            int distance = reindeer.distanceTraveledAfterTime(time);
            if (distance > distanceWinner) {
                distanceWinner = distance;
                winner = reindeer;
            }
        }
        System.out.println("The winner is " + winner.getName() + " with " + distanceWinner + " Km traveled after " + time + " seconds");
    }
}
