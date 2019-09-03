package com.simoruty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Common {
    static Integer[] readFromFile(String path) {
        ArrayList<Integer> lines = new ArrayList<>();
        try {

            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;

            while ((readLine = b.readLine()) != null) {
                lines.add(Integer.parseInt(readLine));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines.toArray(new Integer[0]);
    }

}
