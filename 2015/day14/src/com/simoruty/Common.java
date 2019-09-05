package com.simoruty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
    static ArrayList<String> readFromFile(String path) {
        ArrayList<String> lines = new ArrayList<>();
        try {

            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;

            while ((readLine = b.readLine()) != null) {
                lines.add(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    static ArrayList<Reindeer> fillReindeers(ArrayList<String> inputs) {

        ArrayList<Reindeer> reindeers = new ArrayList<>();
        for (String input : inputs) {
            String name = input.split(" ")[0];
            int speed = 0;
            Pattern speedPattern = Pattern.compile("(\\d*) km/s");
            Matcher m = speedPattern.matcher(input);
            while (m.find()) {
                speed = (Integer.parseInt(m.group(1)));
            }

            int timeToSpeed = 0;
            Pattern timeToSpeedPattern = Pattern.compile("(\\d*) seconds,");
            m = timeToSpeedPattern.matcher(input);
            while (m.find()) {
                timeToSpeed = (Integer.parseInt(m.group(1)));
            }

            int timeToRest = 0;
            Pattern timeToRestPattern = Pattern.compile("(\\d*) seconds.");
            m = timeToRestPattern.matcher(input);
            while (m.find()) {
                timeToRest = (Integer.parseInt(m.group(1)));
            }

            reindeers.add(new Reindeer(name, speed, timeToSpeed, timeToRest));
        }
        return reindeers;
    }
}
