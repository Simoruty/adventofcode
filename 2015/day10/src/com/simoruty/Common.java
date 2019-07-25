package com.simoruty;

import java.io.*;

public class Common {

    static void writeToFile(String text, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(text);
        writer.close();
    }
}
