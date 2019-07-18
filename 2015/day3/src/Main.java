import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static class House implements Comparable<House> {
        int coordX;
        int coordY;

        public House() {
            coordX = 0;
            coordY = 0;
        }

        public int getCoordX() {
            return coordX;
        }

        public int getCoordY() {
            return coordY;
        }

        public House(int x, int y) {
            coordX = x;
            coordY = y;
        }

        @Override
        public String toString() {
            return "CoordX: " + getCoordX() + " CoordY: " + getCoordY();
        }

        @Override
        public int compareTo(House o) {
            if (getCoordY() == o.getCoordY() &&
                getCoordX() == o.getCoordX())
                return 0;
            return -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return getCoordY() == ((House)o).getCoordY() &&
                    getCoordX() == ((House)o).getCoordX();
        }
    }
    static Map<String , Integer> housesVisited = new HashMap<>();

    private static House visit(int x, int y) {
        House currentHouse = new House(x, y);
        if (housesVisited.containsKey(currentHouse.toString()))
            housesVisited.put(currentHouse.toString(), housesVisited.get(currentHouse.toString()) + 1);
        else
            housesVisited.put(currentHouse.toString(), 1);
        return currentHouse;
    }

    public static void main(String[] args) throws IOException {
        part2();
    }

    public static void part1() throws IOException{
        String filename = "./input";

        Charset encoding = Charset.defaultCharset();
        File file = new File(filename);
        House currentHouse = new House();
        housesVisited.put(currentHouse.toString(), 1);

        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in, encoding);
             Reader buffer = new BufferedReader(reader)) {
            int r;
            while ((r = reader.read()) != -1) {
                char ch = (char) r;

                switch (ch) {
                    case '^':
                        currentHouse = visit(currentHouse.getCoordX(), currentHouse.getCoordY() + 1);
                        break;
                    case '<':
                        currentHouse = visit(currentHouse.getCoordX() - 1, currentHouse.getCoordY());
                        break;
                    case '>':
                        currentHouse = visit(currentHouse.getCoordX() + 1, currentHouse.getCoordY());
                        break;
                    case 'v':
                        currentHouse = visit(currentHouse.getCoordX(), currentHouse.getCoordY() - 1);
                        break;
                }
            }
        }

        System.out.println("The house visited from Santa is : " + housesVisited.size());
    }


    public static void part2() throws IOException{
        String filename = "./input";

        Charset encoding = Charset.defaultCharset();
        File file = new File(filename);
        House currentHouseSanta = new House();
        House currentHouseRobo = new House();
        housesVisited.put(currentHouseSanta.toString(), 1);

        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in, encoding);
             // buffer for efficiency
             Reader buffer = new BufferedReader(reader)) {
            int r;
            int pos =1;
            while ((r = reader.read()) != -1) {
                char ch = (char) r;
                switch (ch) {
                    case '^':
                        if (pos%2!=0)
                            currentHouseSanta = visit(currentHouseSanta.getCoordX(), currentHouseSanta.getCoordY() + 1);
                        else
                            currentHouseRobo = visit(currentHouseRobo.getCoordX(), currentHouseRobo.getCoordY() + 1);
                        break;
                    case '<':
                        if (pos%2!=0)
                            currentHouseSanta = visit(currentHouseSanta.getCoordX() - 1, currentHouseSanta.getCoordY());
                        else
                            currentHouseRobo = visit(currentHouseRobo.getCoordX() - 1, currentHouseRobo.getCoordY());
                        break;
                    case '>':
                        if (pos%2!=0)
                            currentHouseSanta = visit(currentHouseSanta.getCoordX() + 1, currentHouseSanta.getCoordY());
                        else
                            currentHouseRobo = visit(currentHouseRobo.getCoordX() + 1, currentHouseRobo.getCoordY());
                        break;
                    case 'v':
                        if (pos%2!=0)
                            currentHouseSanta = visit(currentHouseSanta.getCoordX(), currentHouseSanta.getCoordY() - 1);
                        else
                            currentHouseRobo = visit(currentHouseRobo.getCoordX(), currentHouseRobo.getCoordY() - 1);
                        break;
                }
                pos++;
            }
        }

        System.out.println("The house visited from Santa and Robo is : " + housesVisited.size());
    }
}