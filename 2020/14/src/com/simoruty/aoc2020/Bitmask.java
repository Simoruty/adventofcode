package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Bitmask {
    private HashMap<Integer, Integer> memory;
    private HashMap<Integer, Integer> mask;
    private ArrayList<Integer> order;

    public Bitmask() {
    }

    public ArrayList<Integer> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Integer> order) {
        this.order = order;
    }

    public HashMap<Integer, Integer> getMemory() {
        return memory;
    }

    public void setMemory(HashMap<Integer, Integer> memory) {
        this.memory = memory;
    }

    public HashMap<Integer, Integer> getMask() {
        return mask;
    }

    public void setMask(HashMap<Integer, Integer> mask) {
        this.mask = mask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bitmask bitmask = (Bitmask) o;
        return mask.equals(bitmask.mask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mask);
    }

    @Override
    public String toString() {
        return "Bitmask{" +
                "memory=" + memory +
                ", order=" + order +
                ", mask=" + mask +
                '}';
    }
}
