package com.sevak_avet.Task2;

import com.sevak_avet.Task1.Graph;
import com.sevak_avet.Task2.BFS;

public class Task_2 {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.add(0, 1);
        g.add(0, 3);
        g.add(1, 3);
        g.add(3, 2);
        g.add(4, 2);

        BFS bfs = new BFS(g);
        for (int i = 0; i <= 4; i++) {
            int length = bfs.bfs(0, i);
            String res;

            if(length == BFS.INF) {
                res = "пути нет!";
            } else{
                res = String.valueOf(length);
            }

            System.out.println(String.format("%d --> %d: %s", 0, i, res));
        }
    }
}

