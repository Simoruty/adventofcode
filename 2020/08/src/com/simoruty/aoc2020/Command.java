package com.simoruty.aoc2020;

public class Command {
    private final int num;
    private String op;
    private boolean visited;

    public Command(String op, int num, boolean visited) {
        this.op = op;
        this.num = num;
        this.visited = visited;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public int getNum() {
        return num;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Command{" +
                "op='" + op + '\'' +
                ", num=" + num +
                ", visited=" + visited +
                '}';
    }
}
