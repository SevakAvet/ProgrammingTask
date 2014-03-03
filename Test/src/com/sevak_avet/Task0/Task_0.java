package com.sevak_avet.Task0;

public class Task_0 {
    public static void main(String[] args) {
        AVLTree<Integer> a = new AVLTree<>();

        for (int i = 0; i < 20; i++) {
            a.insert(i);
        }

        a.printTree(false);
        // finish
    }
}
