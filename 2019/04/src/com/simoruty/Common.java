package com.simoruty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Common {
    static ArrayList<Integer[]> readFromFile(String path) {
        ArrayList<Integer[]> rangePwdList = new ArrayList<>();
        try {
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;
            while ((readLine = b.readLine()) != null) {
                Integer[] rangePwd = new Integer[2];
                rangePwd[0] = Integer.parseInt(readLine.split("-")[0]);
                rangePwd[1] = Integer.parseInt(readLine.split("-")[1]);
                rangePwdList.add(rangePwd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rangePwdList;
    }
}
