package com.simoruty;
import java.util.ArrayList;

public class Parts {

    public static void part1(ArrayList<Integer> values) {
        int i = 0;
        while (i < values.size() && values.get(i) != 99) {
            int val = values.get(i);
            if (val == 1) {
                values.set(values.get(i + 3), values.get(values.get(i + 1)) + values.get(values.get(i + 2)));
                i = i + 4;
            } else if (val == 2) {
                values.set(values.get(i + 3), values.get(values.get(i + 1)) * values.get(values.get(i + 2)));
                i = i + 4;
            } else i++;
        }

        System.out.println("---------------- PART 1 -------------------");
        System.out.println("Result is "+ values.get(0));
        System.out.println();
    }

    public static void part2() {
        for (int noun = 1; noun < 99; noun++) {
            for (int verb = 1; verb < 99; verb++) {
                ArrayList<Integer> values = Common.readFromFile("./assignment");
                values.set(1, noun);
                values.set(2, verb);
                try {
                    int i = 0;
                    while (i < values.size() && values.get(i) != 99) {
                        int val = values.get(i);
                        if (val == 1) {
                            values.set(values.get(i + 3), values.get(values.get(i + 1)) + values.get(values.get(i + 2)));
                            i = i + 4;
                        } else if (val == 2) {
                            values.set(values.get(i + 3), values.get(values.get(i + 1)) * values.get(values.get(i + 2)));
                            i = i + 4;
                        }
                    }
                    if (values.get(0) == 19690720) {
                        System.out.println("---------------- PART 2 -------------------");
                        System.out.println("Noun " + noun);
                        System.out.println("Verb " + verb);
                        int tot = 100 * noun + verb;
                        System.out.println("Result (100 * noun + verb) is " + tot);
                        System.out.println();
                        break;
                    }
                } catch (IndexOutOfBoundsException ignored) {}
            }
        }
    }
}
