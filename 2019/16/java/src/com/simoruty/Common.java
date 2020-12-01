package com.simoruty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Common {
    static ArrayList<Integer> readFromFile(String path) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = b.readLine();
            for (int i = 0; i < readLine.length(); i++) {
                list.add(Character.getNumericValue(readLine.charAt(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
