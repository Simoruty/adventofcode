package com.simoruty.aoc2020;

import java.util.Objects;

public class Constraint {
    private final String name;
    private final Range range;

    public Constraint(String name, Range range) {
        this.name = name;
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public Range getRange() {
        return range;
    }

    @Override
    public String toString() {
        return "Constraint{" +
                "name='" + name + '\'' +
                ", range=" + range +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constraint that = (Constraint) o;
        return Objects.equals(name, that.name) && Objects.equals(range, that.range);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, range);
    }
}
