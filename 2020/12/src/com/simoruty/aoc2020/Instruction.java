package com.simoruty.aoc2020;

public class Instruction {
    private final char direction;
    private final int value;

    public Instruction(char direction, int value) {
        this.direction = direction;
        this.value = value;
    }

    public char getDirection() {
        return direction;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "direction='" + direction + '\'' +
                ", value=" + value +
                '}';
    }
}
