package com.simoruty.aoc2020;

public class Policy {
    private int min;
    private int max;
    private char charToCheck;
    private String pwd;

    public Policy(int min, int max, char charToCheck, String pwd) {
        this.min = min;
        this.max = max;
        this.charToCheck = charToCheck;
        this.pwd = pwd;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public char getCharToCheck() {
        return charToCheck;
    }

    public void setCharToCheck(char charToCheck) {
        this.charToCheck = charToCheck;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "min=" + min +
                ", max=" + max +
                ", charToCheck=" + charToCheck +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
