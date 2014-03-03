package com.sevak_avet.Task2;

import com.sevak_avet.Task1.Graph;

import java.util.*;

public class BFS {
    public static final int INF = 1_000_000_000;
    private Graph g;

    private BFS(){}

    public BFS(Graph g) {
        this.g = g;
    }

    public int bfs(int start, int finish) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] used = new boolean[g.size()];
        int[] d = new int[g.size()];
        Arrays.fill(d, INF);

        q.add(start);
        used[start] = true;
        d[start] = 0;

        while(!q.isEmpty()) {
            int from = q.poll();

            ArrayList<Integer> fromList = g.get(from);
            boolean finished = false;
            for (int i = 0; i < fromList.size(); i++) {
                int to = fromList.get(i);

                if(!used[to]) {
                    used[to] = true;
                    d[to] = d[from] + 1;
                    q.add(to);

                    if(to == finish) {
                        finished = true;
                        break;
                    }
                }
            }

            if(finished) {
                break;
            }
        }

        return d[finish];
    }
}
