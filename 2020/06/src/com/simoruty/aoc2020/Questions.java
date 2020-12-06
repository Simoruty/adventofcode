package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.HashSet;

public class Questions {
    private HashSet<Character> answersUsers = new HashSet<>();
    private ArrayList<HashSet<Character>> answers;

    public Questions() {
    }

    public HashSet<Character> getAnswersUsers() {
        return answersUsers;
    }

    public void setAnswersUsers(HashSet<Character> answersUsers) {
        this.answersUsers = answersUsers;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "answersUsers=" + answersUsers +
                ", answers=" + answers +
                '}';
    }

    public ArrayList<HashSet<Character>> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<HashSet<Character>> answers) {
        this.answers = answers;
    }
}
