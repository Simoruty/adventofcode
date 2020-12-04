package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Common {

    static ArrayList<Passport> readFromFile(String path) {
        ArrayList<Passport> map = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            Passport passport = new Passport();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.split(" ");

                for (String field : lineSplit) {
                    if (field.contains("ecl:")) {
                        passport.setEcl(field.substring(field.indexOf("ecl:") + 4));
                    }
                    if (field.contains("byr:")) {
                        passport.setByr(Integer.parseInt(field.substring(field.indexOf("byr:") + 4)));
                    }
                    if (field.contains("iyr:")) {
                        passport.setIyr(Integer.parseInt(field.substring(field.indexOf("iyr:") + 4)));
                    }
                    if (field.contains("eyr:")) {
                        passport.setEyr(Integer.parseInt(field.substring(field.indexOf("eyr:") + 4)));
                    }
                    if (field.contains("hgt:")) {
                        passport.setHgt(field.substring(field.indexOf("hgt:") + 4));
                    }
                    if (field.contains("hcl:")) {
                        passport.setHcl(field.substring(field.indexOf("hcl:") + 4));
                    }
                    if (field.contains("pid:")) {
                        passport.setPid(field.substring(field.indexOf("pid:") + 4));
                    }
                    if (field.contains("cid:")) {
                        passport.setCid(field.substring(field.indexOf("cid:") + 4));
                    }
                }
                if (line.isEmpty()) {
                    map.add(passport);
                    passport = new Passport();
                }
            }
            map.add(passport);
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
