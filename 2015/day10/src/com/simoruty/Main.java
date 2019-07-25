package com.simoruty;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        String input = "1321131112";

        for (int i = 0; i < 50; i++) {
            long diff = System.currentTimeMillis();
            input = part1(input);
            diff = (System.currentTimeMillis() - diff)/1000;
            System.out.println(diff + "s iteration number " + (i+1) + " length: " + input.length());
        }
        Common.writeToFile(input,"./output");

        System.out.println(input.length());
    }


    private static String part1(String input){
        ArrayList<Character> chars = new ArrayList<>();
        for (char c : input.toCharArray()) {
            chars.add(c);
        }
        StringBuilder output= new StringBuilder();

        char current = chars.get(0);
        chars.remove(0);
        int tot = 1;

        while (!chars.isEmpty()) {
            char c = chars.get(0);
            if (c == current) {
                tot++;
            } else {
                output.append(tot);
                output.append(current);
                current = c;
                tot = 1;
            }
            chars.remove(0);
        }
        output.append(tot);
        output.append(current);

        return output.toString();
    }
}
