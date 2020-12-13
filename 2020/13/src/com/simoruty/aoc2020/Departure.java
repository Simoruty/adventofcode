package com.simoruty.aoc2020;

import java.util.ArrayList;

public class Departure {

    private final int timestampDep;
    private final ArrayList<Integer> busIds;

    public Departure(int timestampDep, ArrayList<Integer> busIds) {
        this.timestampDep = timestampDep;
        this.busIds = busIds;
    }

    public int getTimestampDep() {
        return timestampDep;
    }

    public ArrayList<Integer> getBusIds() {
        return busIds;
    }

    @Override
    public String toString() {
        return "Departure{" +
                "timestampDep=" + timestampDep +
                ", busIds=" + busIds +
                '}';
    }
}
