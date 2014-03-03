package com.sevak_avet.Task1;

import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        int n = 5;
        Graph g = new Graph(n);

        Random r = new Random();
        for (int i = 0; i < n; ++i) {
            int to = r.nextInt(n);

            System.out.println(i + " --> " + to);
            g.add(i, to);
        }

        System.out.println(g);

        Scanner s = new Scanner(System.in);
        int deleteVertex = s.nextInt();
        g.delete(deleteVertex);

        System.out.println(g);
    }
}

