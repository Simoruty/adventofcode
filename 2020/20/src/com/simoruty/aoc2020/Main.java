package com.simoruty.aoc2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ArrayList<Tile> tiles = Common.readTiles("./test/input");
        assert tiles != null;
        //System.out.println("Part1: " + part1(tiles));
        System.out.println("Part2: " + part2(tiles));
    }

    private static long part2(ArrayList<Tile> tiles) {
        firstTile(tiles);
        return 0;
    }

    private static Tile retrieveByID(int id, ArrayList<Tile> tiles) {
        for (Tile tile : tiles)
            if (tile.getId() == id)
                return tile;
        return null;
    }

    private static Tile firstTile(ArrayList<Tile> tiles) {
        ArrayList<Tile> corners = new ArrayList<>(4);
        corners.add(retrieveByID(1951, tiles));
        corners.add(retrieveByID(1171, tiles));
        corners.add(retrieveByID(2971, tiles));
        corners.add(retrieveByID(3079, tiles));

        for (Tile corner : corners) {
            corner.rotate(2);
            System.out.println("Corner " + corner.getId());
            ArrayList<Integer> corner1 = corner.getEdgeVals();
            int count = 0;

            HashMap<Tile,String> t = new HashMap<>();
            ArrayList<Integer> cornerIndex;
            ArrayList<Integer> tileIndex;

            for (Tile tile : tiles) {
                tileIndex = new ArrayList<>();
                cornerIndex = new ArrayList<>();
                ArrayList<Integer> ed = tile.getEdgeVals();
                for (Integer integer : ed) {
                    if (corner1.contains(integer)){
                        cornerIndex.add(corner1.indexOf(integer));
                        tileIndex.add(ed.indexOf(integer));
                        count++;
                    }
                }
                if (count > 1 && tile.getId() != corner.getId()) {
                    String pos = "";
                    for (int cornerIndexVal:tileIndex) {
                        switch (cornerIndexVal) {
                            case 0:
                                pos += "U";
                                break;
                            case 1:
                                pos += "UR";
                                break;
                            case 2:
                                pos += "L";
                                break;
                            case 3:
                                pos += "LR";
                                break;
                            case 4:
                                pos += "R";
                                break;
                            case 5:
                                pos += "RR";
                                break;
                            case 6:
                                pos += "B";
                                break;
                            case 7:
                                pos += "BR";
                                break;
                        }
                        pos+= "-";
                    }
                    t.put(tile,pos.substring(0,pos.length()-1));

                    String posCorner = "";
                    for (int cornerIndexVal:cornerIndex) {
                        switch (cornerIndexVal) {
                            case 0:
                                posCorner += "U";
                                break;
                            case 1:
                                posCorner += "UR";
                                break;
                            case 2:
                                posCorner += "L";
                                break;
                            case 3:
                                posCorner += "LR";
                                break;
                            case 4:
                                posCorner += "R";
                                break;
                            case 5:
                                posCorner += "RR";
                                break;
                            case 6:
                                posCorner += "B";
                                break;
                            case 7:
                                posCorner += "BR";
                                break;
                        }
                        posCorner+= "-";
                    }

                    t.put(corner,posCorner.substring(0,posCorner.length()-1));
                }
                count = 0;
            }
            for (Tile tile : t.keySet()) {
                System.out.println(tile.getId() + " " + tile.getEdgeVals() + " " + t.get(tile));
            }
            System.out.println();
        }


        // 1951    2311    3079
        // 2729    1427    2473
        // 2971    1489    1171

        System.exit(1);

        return null;
    }

    public static long part1(ArrayList<Tile> tiles) {
        Map<Integer, Integer> countBorderVals = new HashMap<>();
        assert tiles != null;
        for (Tile t : tiles)
            //System.out.println(t.getId() + " " + t.getEdgeVals());
            for (Integer i : t.getEdgeVals())
                countBorderVals.merge(i, 1, Integer::sum);

        //System.out.println(countBorderVals);
        long res = 1;
        for (Tile t : tiles) {
            int count = 0;
            for (Integer i : t.getEdgeVals())
                if (countBorderVals.get(i).equals(1)) count++;
            if (count == 4) {
                System.out.println("T " + t.getId() + " " + count);
                res *= t.getId();
            }
        }
        return res;
    }

}
