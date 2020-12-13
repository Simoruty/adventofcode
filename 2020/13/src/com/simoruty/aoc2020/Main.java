package com.simoruty.aoc2020;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Departure departure = Common.readFromFile("./test/input");

        System.out.println(departure);
        assert departure != null;
        System.out.println("Part1 : " + part1(departure));

        System.out.println(part2(departure));

    }

    public static long part1(Departure departure) {

        int busIdChoice = 0;
        int delay = Integer.MAX_VALUE;

        for (Integer busId : departure.getBusIds()) {
            if (busId != -1) {
                int nextTimestamp = (int) Math.ceil((double) departure.getTimestampDep() / busId) * busId;
                int delaytmp = nextTimestamp - departure.getTimestampDep();
                if (delaytmp < delay) {
                    busIdChoice = busId;
                    delay = delaytmp;
                }
            }
        }
        System.out.println("Bus Id is " + busIdChoice + " and need to wait " + delay + " minutes.");

        return (long) busIdChoice * delay;
    }

    public static BigInteger part2(Departure departure) {
        boolean found = false;
        HashMap<Integer, Integer> busIdsMap = new HashMap<>();
        IntStream.range(0, departure.getBusIds().size()).forEach(i -> {
            if (departure.getBusIds().get(i) != -1) busIdsMap.put(i, departure.getBusIds().get(i));
        });

        BigInteger timestamp = new BigInteger("100000000000000");
        while (!found) {
            timestamp = timestamp.add(new BigInteger("1"));
            for (Integer busId : busIdsMap.keySet()) {
                if (timestamp.add(new BigInteger(String.valueOf(busId))).mod(new BigInteger(String.valueOf(busIdsMap.get(busId)))).compareTo(new BigInteger("0")) == 0)
                    found = true;
                else {
                    found = false;
                    break;
                }
            }
        }
        return timestamp;
    }
}