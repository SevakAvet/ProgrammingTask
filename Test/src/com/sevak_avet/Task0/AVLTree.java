package com.sevak_avet.Task0;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {
    Node<T> root;

    public AVLTree() {
        root = null;
    }

    private int depth(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return node.getDepth();
    }

    public Node<T> insert(T data) {
        root = insert(root, data);

        switch (balanceNumber(root)) {
            case 1:
                root = rotateLeft(root);
                break;
            case -1:
                root = rotateRight(root);
                break;
            default:
                break;
        }
        return root;
    }

    public Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (node.getData().compareTo(data) > 0) {
            node = new Node<>(node.getData(), insert(node.getLeft(), data), node.getRight());
        } else if (node.getData().compareTo(data) < 0) {
            node = new Node<>(node.getData(), node.getLeft(), insert( node.getRight(), data));
        }

        switch (balanceNumber(node)) {
            case 1:
                node = rotateLeft(node);
                break;
            case -1:
                node = rotateRight(node);
                break;
            default:
                return node;
        }
        return node;
    }

    private int balanceNumber(Node<T> node) {
        int L = depth(node.getLeft());
        int R = depth(node.getRight());

        if (L - R >= 2)
            return -1;
        else if (L - R <= -2)
            return 1;
        return 0;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> q = node;
        Node<T> p = q.getRight();
        Node<T> c = q.getLeft();
        Node<T> a = p.getLeft();
        Node<T> b = p.getRight();

        q = new Node<>(q.getData(), c, a);
        p = new Node<>(p.getData(), q, b);

        return p;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> q = node;
        Node<T> p = q.getLeft();
        Node<T> c = q.getRight();
        Node<T> a = p.getLeft();
        Node<T> b = p.getRight();

        q = new Node<>(q.getData(), b, c);
        p = new Node<>(p.getData(), a, q);

        return p;
    }

    public String toString() {
        return root.toString();
    }

    public void printTree(boolean onlyFoliages) {
        root.setLevel(0);

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();

            // Если листья
            if(onlyFoliages) {
                if (node.getLeft() == null && node.getRight() == null) {
                    System.out.println(node);
                }
            } else {
                System.out.println(node);
            }

            int level = node.getLevel();
            Node<T> left = node.getLeft();
            Node<T> right = node.getRight();

            if (left != null) {
                left.setLevel(level + 1);
                queue.add(left);
            }
            if (right != null) {
                right.setLevel(level + 1);
                queue.add(right);
            }
        }
    }
}
