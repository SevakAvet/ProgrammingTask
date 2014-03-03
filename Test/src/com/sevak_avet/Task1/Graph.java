package com.sevak_avet.Task1;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<ArrayList<Integer>> g = new ArrayList<>();
    private int size;

    public Graph(int size) {
        this.size = size;
        init();
    }

    public int size() {
        return size;
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            g.add(new ArrayList<Integer>());
        }
    }

    public void add(int from, int to) {
        g.get(from).add(to);
    }

    public ArrayList<Integer> get(int from) {
        return g.get(from);
    }

    public void delete(int deleteVertex) {
        g.get(deleteVertex).clear();

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < g.get(i).size(); ++j) {
                if (g.get(i).get(j) == deleteVertex) {
                    g.get(i).remove(j);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; ++i) {
            sb.append(i).append(": ");
            for (int j = 0; j < g.get(i).size(); ++j) {
                sb.append(g.get(i).get(j));
                if (j == g.get(i).size() - 1) {
                    sb.append("; ");
                } else {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
