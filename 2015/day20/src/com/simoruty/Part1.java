package com.simoruty;

public class Part1 {

    public static void part1(int input) {
        int present = 0;
        int i = 0;
        while (present < input) {
            i = i + 20;
            present = presentHouse(i);
        }

        while (i > 0) {
            if (presentHouse(i) > input)
                i--;
            else {
                i++;
                System.out.println("House " + i + " got " + presentHouse(i) + " presents.");
                break;
            }
        }
    }

    private static int presentHouse(int house) {
        int present = 0;
        for (int i = 1; i <= house; i++)
            if (house % i == 0)
                present += i * 10;
        return present;
    }

}
