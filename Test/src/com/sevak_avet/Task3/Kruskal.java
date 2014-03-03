package com.sevak_avet.Task3;

import java.util.*;

public class Kruskal {
    private Map<Integer, Edge> edges;
    private List<Edge> res = new ArrayList<>();
    private List<Integer> treeId = new ArrayList<>();
    private int size;

    public Kruskal(int size, Map<Integer, Edge> edges) {
        this.size = size;
        this.edges = edges;
        init();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            treeId.add(i);
        }
    }

    public List<Edge> doIt() {
        for(Map.Entry<Integer, Edge> e : edges.entrySet()) {
            int w = e.getKey();
            int from = e.getValue().from;
            int to = e.getValue().to;

            if(treeId.get(from) != treeId.get(to)) {
                res.add(e.getValue());

                int oldId = treeId.get(to);
                int newId = treeId.get(from);

                for (int j = 0; j < size; j++) {
                    if(treeId.get(j) == oldId) {
                        treeId.set(j, newId);
                    }
                }
            }
        }

        return res;
    }

    public static class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
