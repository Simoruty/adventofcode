package com.simoruty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Common {
    static List<String> readFromFile(String path) {
        List<String> list = new ArrayList<>();
        try {

            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;
            while ((readLine = b.readLine()) != null) {
                list.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
