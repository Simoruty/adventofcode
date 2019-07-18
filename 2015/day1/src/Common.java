import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Common {

    public static String readFromFile(String path) {
        try {

            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            return b.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
}}
