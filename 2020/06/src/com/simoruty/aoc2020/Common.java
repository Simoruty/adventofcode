package com.simoruty.aoc2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Common {

    static ArrayList<Questions> readFromFile(String path) {
        ArrayList<Questions> map = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            Questions questions = new Questions();
            ArrayList<HashSet<Character>> answers = new ArrayList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    questions.setAnswers(answers);
                    map.add(questions);
                    questions = new Questions();
                    answers = new ArrayList<>();
                } else {
                    HashSet<Character> read = questions.getAnswersUsers();
                    HashSet<Character> a = new HashSet<>();
                    for (char c : line.toCharArray()) {
                        read.add(c);
                        a.add(c);
                    }
                    answers.add(a);
                    questions.setAnswersUsers(read);
                }
            }
            questions.setAnswers(answers);
            map.add(questions);
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
