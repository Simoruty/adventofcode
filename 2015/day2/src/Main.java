import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String fileName = "./input";

        double tot = 0;
        double ribbonTot = 0;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            for (String present : stream.collect(Collectors.toList())) {
                String[] s = present.split("x");

                int l = Integer.parseInt(s[0]);
                int w = Integer.parseInt(s[1]);
                int h = Integer.parseInt(s[2]);

                tot += surface(l, w, h) + smallestSize(l, w, h);

                double ribbon = ribbonPresent(l, w, h) + ribbonBow(l, w, h);
                System.out.println(l + " x " + w + " x " + h + " = " + ribbon);

                ribbonTot += ribbonPresent(l, w, h) + ribbonBow(l, w, h);

            }

            System.out.println(tot);
            System.out.println(ribbonTot);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    // The ribbon required to wrap a present is the shortest distance around its sides,
    // or the smallest perimeter of any one face.
    // A present with dimensions 2x3x4 requires 2+2+3+3 = 10
    // A present with dimensions 1x1x10 requires 1+1+1+1 = 4

    private static double ribbonPresent(int l, int w, int h) {
        int[] sides = {l, w, h};
        Arrays.sort(sides);
        return sides[0] + sides[0] + sides[1] + sides[1];
    }

    private static double ribbonBow(int l, int w, int h) {
        return l * w * h;
    }

    private static double surface(int l, int w, int h) {
        return 2 * l * w + 2 * w * h + 2 * h * l;
    }

    private static double smallestSize(int l, int w, int h) {
        double size1 = l * w;
        double size2 = h * w;
        double size3 = l * h;

        if (size1 <= size2) {
            if (size3 <= size1)
                return size3;
            return size1;
        } else if (size3 <= size2)
            return size3;
        return size2;
    }
}
