package com.simoruty;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = Common.readFromFile("./input");
        Sue toFind = new Sue(3, 7, 2, 3, 0, 0, 5, 3, 2, 1);

        System.out.println(toFind);
        System.out.println();
        ArrayList<Sue> aunts = fillAunt(input);
        for (Sue aunt : aunts) {
            if (aunt.contains(toFind)) {
                System.out.println(aunt);
            }
        }
    }

    private static ArrayList<Sue> fillAunt(ArrayList<String> inputFile) {

        ArrayList<Sue> aunts = new ArrayList<>();

        for (String input : inputFile) {
            Sue aunt = new Sue();

            Pattern id = Pattern.compile("Sue (\\d*)");
            Matcher m = id.matcher(input);
            while (m.find()) {
                aunt.setId(Integer.parseInt(m.group(1)));
            }

            Pattern children = Pattern.compile("children: (\\d*)");

            m = children.matcher(input);
            while (m.find())
                aunt.setChildren(Integer.parseInt(m.group(1)));

            Pattern cats = Pattern.compile("cats: (\\d*)");
            m = cats.matcher(input);
            while (m.find())
                aunt.setCats(Integer.parseInt(m.group(1)));

            Pattern samoyeds = Pattern.compile("samoyeds: (\\d*)");
            m = samoyeds.matcher(input);
            while (m.find())
                aunt.setSamoyeds(Integer.parseInt(m.group(1)));

            Pattern pomeranians = Pattern.compile("pomeranians: (\\d*)");
            m = pomeranians.matcher(input);
            while (m.find())
                aunt.setPomeranians(Integer.parseInt(m.group(1)));

            Pattern akitas = Pattern.compile("akitas: (\\d*)");
            m = akitas.matcher(input);
            while (m.find())
                aunt.setAkitas(Integer.parseInt(m.group(1)));

            Pattern vizslas = Pattern.compile("vizslas: (\\d*)");
            m = vizslas.matcher(input);
            while (m.find())
                aunt.setVizslas(Integer.parseInt(m.group(1)));

            Pattern goldfish = Pattern.compile("goldfish: (\\d*)");
            m = goldfish.matcher(input);
            while (m.find())
                aunt.setGoldfish(Integer.parseInt(m.group(1)));

            Pattern trees = Pattern.compile("trees: (\\d*)");
            m = trees.matcher(input);
            while (m.find())
                aunt.setTrees(Integer.parseInt(m.group(1)));

            Pattern cars = Pattern.compile("cars: (\\d*)");
            m = cars.matcher(input);
            while (m.find())
                aunt.setCars(Integer.parseInt(m.group(1)));

            Pattern perfumes = Pattern.compile("perfumes: (\\d*)");
            m = perfumes.matcher(input);
            while (m.find())
                aunt.setPerfumes(Integer.parseInt(m.group(1)));

            aunts.add(aunt);
        }
        return aunts;
    }
}
