package com.simoruty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Common {
    static Map<String, ArrayList<String>> readFromFile(String path) {
        Map<String, ArrayList<String>> points = new HashMap<>(2);
        try {

            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;
            int i = 1;
            while ((readLine = b.readLine()) != null) {
                ArrayList<String> lines = new ArrayList<>();
                String[] point = readLine.split(",");
                Collections.addAll(lines, point);
                points.put("Point" + i, lines);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return points;
    }
}
