package com.simoruty;

import java.util.ArrayList;
import java.util.Map;

public class Parts {

    public static void part1(Map<String, ArrayList<String>> points) {

        int xOrig = 0;
        int yOrig = 0;

        ArrayList<Point> point1path = calcPoint(points.get("Point1"), new Point(xOrig, yOrig));
        ArrayList<Point> point2path = calcPoint(points.get("Point2"), new Point(xOrig, yOrig));

        System.out.println("---------------- PART 1 -------------------");
        System.out.println("The min manhattan value is " + intersectPoint(point1path, point2path, new Point(xOrig, yOrig)));
        System.out.println();
    }

    private static ArrayList<Point> calcPoint(ArrayList<String> pointValues, Point orig) {
        ArrayList<Point> pointList = new ArrayList<>(10);

        int steps = 0;
        for (String value : pointValues) {
            if (value.contains("U")) {
                for (int y = 1; y <= Integer.parseInt(value.substring(1)); y++) {
                    steps++;
                    orig.incY();
                    pointList.add(new Point(orig.getX(), orig.getY(), steps));
                }
            } else if (value.contains("R")) {
                for (int x = 1; x <= Integer.parseInt(value.substring(1)); x++) {
                    steps++;
                    orig.incX();
                    pointList.add(new Point(orig.getX(), orig.getY(), steps));
                }
            } else if (value.contains("L")) {
                for (int x = 1; x <= Integer.parseInt(value.substring(1)); x++) {
                    steps++;
                    orig.decX();
                    pointList.add(new Point(orig.getX(), orig.getY(), steps));
                }
            } else if (value.contains("D")) {
                for (int y = 1; y <= Integer.parseInt(value.substring(1)); y++) {
                    steps++;
                    orig.decY();
                    pointList.add(new Point(orig.getX(), orig.getY(), steps));
                }
            }
        }
        return pointList;
    }

    private static double intersectPoint(ArrayList<Point> p1, ArrayList<Point> p2, Point orig) {
        double minManhattan = Double.MAX_VALUE;
        //Point minp = new Point(0,0);
        for (Point point1 : p1) {
            for (Point point2 : p2) {
                if (point1.equals(point2)) {
                    double manhattan = Math.abs(orig.getX() - point1.getX()) + Math.abs(orig.getY() - point1.getY());
                    if (manhattan < minManhattan) {
                        //minp = new Point(point1.getX(), point1.getY());
                        minManhattan = manhattan;
                    }
                }
            }
        }
        return minManhattan;
    }


    private static int intersectPointSteps(ArrayList<Point> p1, ArrayList<Point> p2) {
        int minStep = Integer.MAX_VALUE;
        for (Point point1 : p1) {
            for (Point point2 : p2) {
                if (point1.equals(point2)) {
                    int steps = point1.getSteps() + point2.getSteps();
                    if (steps < minStep) {
                        minStep = steps;
                    }
                }
            }
        }
        return minStep;
    }

    public static void part2(Map<String, ArrayList<String>> points) {

        int xOrig = 0;
        int yOrig = 0;

        ArrayList<Point> point1path = calcPoint(points.get("Point1"), new Point(xOrig, yOrig));
        ArrayList<Point> point2path = calcPoint(points.get("Point2"), new Point(xOrig, yOrig));

        System.out.println("---------------- PART 2 -------------------");
        System.out.println("The fewest combined steps the wires must take to reach an intersection is " + intersectPointSteps(point1path, point2path) + " steps");
        System.out.println();
    }
}