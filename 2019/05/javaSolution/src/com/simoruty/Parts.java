package com.simoruty;

import java.util.ArrayList;

public class Parts {
    public static void part1(ArrayList<Integer> values) {

        int input = 1;

        System.out.println("---------------- PART 1 -------------------");

        System.out.println(values);

        int i = 0;

        while (i < values.size() && values.get(i) != 99) {
            int opCod = findOpCode(values.get(i));
            int param1;
            int param2;
            int address;

            switch (opCod) {
                case 1:

                    // add
                    param1 = getParam(values, i + 1, immediate(opCod, 1));
                    param2 = getParam(values, i + 2, immediate(opCod, 2));
                    address = getParam(values, i + 3, true);

                    values.set(address, param1 + param2);
                    i = i + 4;
                    break;

                case 2:

                    // multiply
                    param1 = getParam(values, i + 1, immediate(opCod, 1));
                    param2 = getParam(values, i + 2, immediate(opCod, 2));
                    address = getParam(values, i + 3, true);

                    values.set(address, param1 * param2);
                    i =i + 4;
                    break;

                case 3:

                    // read
                    address = getParam(values, i + 1, true);
                    values.set(address, input);

                    i = i + 2;
                    break;

                case 4:
                    //write
                    param1 = getParam(values, i + 1, immediate(opCod, 1));
                    System.out.println("Result is " + param1);

                    i = i + 2;
                    break;

                case 99:
                    System.exit(2);
                    break;
                default:
                    System.err.println("not an opcode "+ opCod);
            }
        }

        System.out.println();
    }

    /*

    ABCDE
     1002

    DE - two-digit opcode,      02 == opcode 2
     C - mode of 1st parameter,  0 == position mode
     B - mode of 2nd parameter,  1 == immediate mode
     A - mode of 3rd parameter,  0 == position mode,
                                      omitted due to being a leading zero
     */

    public static int findOpCode(int val) {
        return val % 100;
    }

    private static int getParam(ArrayList<Integer> values, int address, boolean immediate) {
        int param = values.get(address);
        if (immediate)
            return param;
        return values.get(param);
    }

    private static boolean immediate(int c, int paramNum) {
        // 10^2 =   100  for 1
        // 10^3 =  1000  for 2
        // 10^4 = 10000  for 3

        int digit = (int) (Math.pow(10, paramNum + 1));
        return (c / digit % 10) == 1;
    }

    public static void part2() {

        System.out.println("---------------- PART 2 -------------------");
        System.out.println();
    }


}
