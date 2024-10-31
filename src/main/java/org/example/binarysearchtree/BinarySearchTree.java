package org.example.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements AbstractBinarySearchTree<T> {
    private Node<T> root;

    @Override
    public Node<T> getLeft() {
        return root.leftChild;
    }

    @Override
    public Node<T> getRight() {
        return root.rightChild;
    }

    @Override
    public T getValue() {
        return root.value;
    }

    @Override
    public void insert(T element) {
        root = insertNode(root, element);
    }

    private Node<T> insertNode(Node<T> root, T element) {
        if (root == null) {
            root = new Node<>(element);
            return root;
        }
        if (element.compareTo(root.value) < 0) {
            root.leftChild = insertNode(root.leftChild, element);
        }
        if (element.compareTo(root.value) > 0) {
            root.rightChild = insertNode(root.rightChild, element);
        }
        return root;
    }

    @Override
    public boolean contains(T element) {
        return containsNode(root, element);
    }

    private boolean containsNode(Node<T> root, T element) {
        if (root == null) {
            return false;
        }
        if (element.compareTo(root.value) == 0) {
            return true;
        }

        if (element.compareTo(root.value) < 0) {
            return containsNode(root.leftChild, element);
        } else {
            return containsNode(root.rightChild, element);
        }
    }

    @Override
    public AbstractBinarySearchTree<T> search(T element) {
        Node<T> currentNode = searchNode(root, element);
        BinarySearchTree<T> newTree = new BinarySearchTree<>();

        if (currentNode == null) {
            return newTree;
        }

        newTree.root = currentNode;
        return newTree;
    }

    private Node<T> searchNode(Node<T> root, T element) {
        if (root == null || element.equals(root.value)) {
            return root;
        }
        if (element.compareTo(root.value) < 0) {
            return searchNode(root.leftChild, element);
        } else {
            return searchNode(root.rightChild, element);
        }
    }

    @Override
    public Node<T> getRoot() {
        return this.root;
    }

    public Node<T> findMinimum(Node<T> node) {
        if (node.leftChild != null) {
            return findMinimum(node.leftChild);
        }
        return node;
    }

    public Node<T> findMaximum(Node<T> node) {
        if (node.rightChild != null) {
            return findMaximum(node.rightChild);
        }
        return node;
    }

    public void printSearchTree() {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.leftChild);
                newNodes.add(node.rightChild);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (Node<T> node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (node.leftChild != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (node.rightChild != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }
            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private int maxLevel(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.leftChild), maxLevel(node.rightChild)) + 1;
    }

    private boolean isAllElementsNull(List<?> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }
        return true;
    }
}