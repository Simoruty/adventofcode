package com.simoruty.aoc2022;

import java.io.*;
import java.util.*;

public class Common {
    static ArrayList<String> readFromFile(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
            ArrayList<String> list = new ArrayList<>();
            while (scanner.hasNextLine())
                list.add(scanner.nextLine());
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static HashSet<Character> removeDuplicate(char[] str, int n)
    {
        HashSet<Character> s = new LinkedHashSet<>(n - 1);
        for (char x : str)
            s.add(x);

       return s;
    }
}
