package com.simoruty.aoc2020;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int moves = 100;
    private static final int movesPart2 = 1000000;

    public static void main(String[] args) {
        String input = "326519478";
        System.out.println("Part1: " + getPart1Sol(input));
        System.out.println("Part2: " + getPart2Sol(input));
    }

    private static String getPart1Sol(String input) {
        final Deque<Integer> queue = new ArrayDeque<>();
        for (String c : input.split("")) queue.add(Integer.parseInt(c));
        final int max = Collections.max(queue);
        for (int i = 0; i < moves; i++) {
            final int current = queue.removeFirst();
            final Deque<Integer> selected = new ArrayDeque<>();
            for (int j = 0; j < 3; j++)
                selected.addLast(queue.removeFirst());
            int dest = current - 1;
            dest = dest < 1 ? max : dest;
            while (selected.contains(dest)) {
                dest--;
                dest = dest < 1 ? max : dest;
            }
            final Deque<Integer> temp = new ArrayDeque<>();
            temp.addLast(current);
            while (dest != temp.peekLast())
                temp.addLast(queue.removeFirst());
            while (!selected.isEmpty())
                queue.addFirst(selected.removeLast());
            while (temp.size() > 1)
                queue.addFirst(temp.removeLast());
            queue.addLast(temp.removeLast());
        }

        while (queue.peekFirst() != 1)
            queue.addLast(queue.removeFirst());

        queue.removeFirst();
        return queue.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    private static long getPart2Sol(String input) {
        final List<Integer> cups = new ArrayList<>();
        for (String c : input.split("")) cups.add(Integer.parseInt(c));

        final Cup[] cupMap = new Cup[movesPart2 + 1];

        Cup head = new Cup(cups.get(0));
        cupMap[head.value] = head;
        Cup tail = head;

        for (int i = 1; i < cups.size(); i++) {
            final Cup c = new Cup(cups.get(i));
            cupMap[c.value] = c;
            c.next = head;
            tail.next = c;
            tail = c;
        }

        for (int i = Collections.max(cups) + 1; i <= movesPart2; i++) {
            final Cup c = new Cup(i);
            cupMap[c.value] = c;
            c.next = head;
            tail.next = c;
            tail = c;
        }

        for (int i = 0; i < 10000000; i++) {
            final Cup current = head;
            final Cup c1 = current.next;
            final Cup c3 = c1.next.next;

            head.next = c3.next;

            int targetIndex = current.value == 1 ? movesPart2 : current.value - 1;
            while (targetIndex == c1.value || targetIndex == c1.next.value || targetIndex == c3.value) {
                targetIndex--;
                targetIndex = targetIndex < 1 ? movesPart2 : targetIndex;
            }

            final Cup target = cupMap[targetIndex];

            c3.next = target.next;
            target.next = c1;
            head = current.next;
        }

        final Cup one = cupMap[1];
        return (long) one.next.value * one.next.next.value;
    }
}
