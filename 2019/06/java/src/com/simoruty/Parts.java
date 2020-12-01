package com.simoruty;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Parts {

    public static final String ROOT = "COM";
    public int count = 0;
    public void part1(List<String> values){
        System.out.println("---------------- PART 1 -------------------");
        System.out.println(values);


        System.out.println("Result is ");
        System.out.println();

        HashMap<String,String> graph = new HashMap<>();
        for(String line : values) graph.put(line.split("\\)")[1], line.split("\\)")[0]);

        for (String s : graph.keySet()) {
            System.out.println(graph.get(s) + " "+(s));
            count += orbitCount(graph,s);
        }
            System.out.println(count);
    }

    public static int orbitCountRecur(Map<String,String> graph, @NotNull String currNode, int oCount){
        if(currNode.equals(ROOT)) return oCount;
        return orbitCountRecur(graph, graph.get(currNode), oCount++);
    }

    public static int orbitCount(Map<String,String> graph, String node){
        return orbitCountRecur(graph, node, 0);
    }

    public static void part2(){
        System.out.println("---------------- PART 2 -------------------");
        System.out.println("Result is ");
        System.out.println();
    }
}
