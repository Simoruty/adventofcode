package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String filepath = "./test/input";

        ArrayList<Constraint> constraint = Common.readConstraintFromFile(filepath);
        ArrayList<Integer> ticket = Common.readTicket(filepath);
        ArrayList<ArrayList<Integer>> nearbyTickets = Common.readNearbyTicket(filepath);

        assert nearbyTickets != null;
        System.out.println("Part1: " + part1(constraint, nearbyTickets));
        System.out.println("Part2: " + part2(constraint, nearbyTickets, ticket, "departure"));
    }

    public static int part1(ArrayList<Constraint> constraints, ArrayList<ArrayList<Integer>> nearbyTickets) {
        int scanningErrorRate = 0;
        for (ArrayList<Integer> nearbyTicket : nearbyTickets) {
            for (Integer valTicket : nearbyTicket) {
                boolean valid = isValid(constraints, valTicket);
                if (!valid) {
                    //System.out.println(nearbyTicket + " is not valid " + valTicket);
                    scanningErrorRate += valTicket;
                }
            }
        }
        return scanningErrorRate;
    }

    private static boolean isValid(ArrayList<Constraint> constraints, Integer valTicket) {
        boolean valid = false;
        for (Constraint constraint : constraints) {
            Range ranges = constraint.getRange();
            if (valTicket >= ranges.getMin1() && valTicket <= ranges.getMax1() || valTicket >= ranges.getMin2() && valTicket <= ranges.getMax2())
                valid = true;
        }
        return valid;
    }

    public static long part2(ArrayList<Constraint> constraints, ArrayList<ArrayList<Integer>> nearbyTickets, ArrayList<Integer> ticket, String filter) {
        ArrayList<ArrayList<Integer>> nearbyTicketsCleared = clear(constraints, nearbyTickets);
        HashMap<String, Integer> constrColNumber = new HashMap<>();
        while (!constraints.isEmpty()) {
            for (int col = 0; col < nearbyTicketsCleared.get(0).size(); col++) {
                int count = 0;
                Constraint c = null;
                for (Constraint constraint : constraints) {
                    boolean found = true;
                    for (ArrayList<Integer> nearbyTicketCleared : nearbyTicketsCleared) {
                        int valToCheck = nearbyTicketCleared.get(col);
                        Range ranges = constraint.getRange();
                        if (valToCheck >= ranges.getMin1() && valToCheck <= ranges.getMax1() || valToCheck >= ranges.getMin2() && valToCheck <= ranges.getMax2())
                            found = true;
                        else {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        count++;
                        c = constraint;
                    }
                }
                if (count == 1) {
                    constrColNumber.put(c.getName(), col);
                    constraints.remove(c);
                }
            }
        }

        long val = 1L;
        for (String s : constrColNumber.keySet()) {
            if (s.contains(filter)) {
                int index = constrColNumber.get(s);
                //System.out.println(index + " " + s + " " + ticket.get(index));
                val *= ticket.get(index);
            }
        }
        return val;
    }


    private static ArrayList<ArrayList<Integer>> clear(ArrayList<Constraint> constraints, ArrayList<ArrayList<Integer>> nearbyTickets) {
        ArrayList<ArrayList<Integer>> nearbyTicketsCleared = new ArrayList<>(nearbyTickets);
        for (ArrayList<Integer> nearbyTicket : nearbyTickets) {
            for (Integer valTicket : nearbyTicket) {
                boolean valid = isValid(constraints, valTicket);
                if (!valid) nearbyTicketsCleared.remove(nearbyTicket);
            }
        }
        return nearbyTicketsCleared;
    }
}
