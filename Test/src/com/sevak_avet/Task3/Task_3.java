package com.sevak_avet.Task3;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task_3 {
    public static void main(String[] args) {
        Map<Integer, Kruskal.Edge> edgeMap = new TreeMap<>();
        edgeMap.put(1, new Kruskal.Edge(0, 2));
        edgeMap.put(2, new Kruskal.Edge(3, 4));
        edgeMap.put(3, new Kruskal.Edge(0, 1));
        edgeMap.put(4, new Kruskal.Edge(1, 2));
        edgeMap.put(5, new Kruskal.Edge(1, 3));
        edgeMap.put(6, new Kruskal.Edge(2, 3));
        edgeMap.put(7, new Kruskal.Edge(2, 4));

        Kruskal kruskal = new Kruskal(5, edgeMap); // 5 - кол-во вершин
        List<Kruskal.Edge> res = kruskal.doIt();

        System.out.println("START 1");
        for (Kruskal.Edge e : res) {
            System.out.println(e.from + " --> " + e.to);
        }
        System.out.println("END 1");
    }
}
