package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        ArrayList<Questions> questions = Common.readFromFile("./test/input");
        part1(questions);
        part2(questions);

    }

    public static void part2(ArrayList<Questions> questions) {
        int sum = 0;
        for (Questions question : questions) {
            HashSet<Character> common = question.getAnswersUsers();
            for (HashSet<Character> answer : question.getAnswers())
                common.removeIf(character -> !answer.contains(character));
            sum += common.size();
        }
        System.out.println("Part2: " + sum);
    }

    public static void part1(ArrayList<Questions> questions) {
        int sum = 0;
        for (Questions question : questions)
            sum += question.getAnswersUsers().size();
        System.out.println("Part1: " + sum);
    }
}
