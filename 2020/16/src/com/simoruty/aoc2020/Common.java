package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Common {

    static ArrayList<Constraint> readConstraintFromFile(String path) {
        ArrayList<Constraint> constr = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            String line = scanner.nextLine();
            while (scanner.hasNextLine() && !line.isEmpty()) {
                String constName = line.split(":")[0];
                line = line.substring(line.indexOf(":") + 2);
                int min1 = Integer.parseInt(line.split(" ")[0].split("-")[0]);
                int max1 = Integer.parseInt(line.split(" ")[0].split("-")[1]);
                int min2 = Integer.parseInt(line.split(" ")[2].split("-")[0]);
                int max2 = Integer.parseInt(line.split(" ")[2].split("-")[1]);
                Range range = new Range(min1, max1, min2, max2);
                Constraint constraint = new Constraint(constName, range);
                constr.add(constraint);
                line = scanner.nextLine();
            }
            return constr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<Integer> readTicket(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            String line = scanner.nextLine();
            while (scanner.hasNextLine() && !line.contains("your ticket:")) {
                line = scanner.nextLine();
            }
            return Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<ArrayList<Integer>> readNearbyTicket(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            String line = scanner.nextLine();
            while (scanner.hasNextLine() && !line.contains("nearby tickets:")) {
                line = scanner.nextLine();
            }

            ArrayList<ArrayList<Integer>> nearbyTickets = new ArrayList<>();
            while (scanner.hasNextLine()) {
                ArrayList<Integer> nearbyTicket = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
                nearbyTickets.add(nearbyTicket);
            }
            return nearbyTickets;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}