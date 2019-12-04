package com.simoruty;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer[]> rangePwdList = Common.readFromFile("./assignment");

        for (Integer[] rangePwd : rangePwdList) {
           //Parts.part1(rangePwd);
            Parts.part2(rangePwd);
        }
    }
}
