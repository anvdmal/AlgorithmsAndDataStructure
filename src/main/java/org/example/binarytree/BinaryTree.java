package org.example.binarytree;

import java.util.*;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> implements AbstractBinaryTree<T> {
    private T key;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T key) {
        this.key = key;
    }

    @Override
    public T getKey() {
        return this.key;
    }

    @Override
    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public BinaryTree<T> getLeft() {
        return this.left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    @Override
    public BinaryTree<T> getRight() {
        return this.right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        return buildIndentedTree(new StringBuilder(), 0, indent).toString();
    }

    @Override
    public StringBuilder buildIndentedTree(StringBuilder result, int level, int indent) {
        result.append("  ".repeat(level * indent))
                .append(key).append("\n");

        if (this.left != null) {
            this.left.buildIndentedTree(result, level + 1, indent);
        }
        if (this.right != null) {
            this.right.buildIndentedTree(result, level + 1, indent);
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<T>> preOrder() {
        List<AbstractBinaryTree<T>> preOrderList = new ArrayList<>();
        preOrderList.add(this);
        if (this.left != null) {
            preOrderList.addAll(this.left.preOrder());
        }
        if (this.right != null) {
            preOrderList.addAll(this.right.preOrder());
        }
        return preOrderList;
    }

    @Override
    public List<AbstractBinaryTree<T>> inOrder() {
        List<AbstractBinaryTree<T>> inOrderList = new ArrayList<>();
        if (this.left != null) {
            inOrderList.addAll(this.left.inOrder());
        }
        inOrderList.add(this);
        if (this.right != null) {
            inOrderList.addAll(this.right.inOrder());
        }
        return inOrderList;
    }

    @Override
    public List<AbstractBinaryTree<T>> postOrder() {
        List<AbstractBinaryTree<T>> postOrderList = new ArrayList<>();
        if (this.left != null) {
            postOrderList.addAll(this.left.postOrder());
        }
        if (this.right != null) {
            postOrderList.addAll(this.right.postOrder());
        }
        postOrderList.add(this);
        return postOrderList;
    }

    @Override
    public void forEachInOrder(Consumer<T> consumer) {
        if (left != null) {
            left.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }

    @Override
    public void DFS() {
        Stack<AbstractBinaryTree<T>> stackDFS = new Stack<>();
        stackDFS.push(this);
        while (!stackDFS.isEmpty()) {
            AbstractBinaryTree<T> currentTree = stackDFS.pop();
            System.out.print(currentTree.getKey() + " ");
            if (currentTree.getRight() != null) {
                stackDFS.push(currentTree.getRight());
            }
            if (currentTree.getLeft() != null) {
                stackDFS.push(currentTree.getLeft());
            }
        }
    }

    @Override
    public void BFS() {
        Queue<AbstractBinaryTree<T>> queueBFS = new LinkedList<>();
        queueBFS.add(this);
        while (!queueBFS.isEmpty()) {
            AbstractBinaryTree<T> currentTree = queueBFS.poll();
            System.out.print(currentTree.getKey() + " ");
            if (currentTree.getLeft() != null) {
                queueBFS.add(currentTree.getLeft());
            }
            if (currentTree.getRight() != null) {
                queueBFS.add(currentTree.getRight());
            }
        }
    }

    @Override
    public void printTree() {
        int maxLevel = maxLevel(this);  // Изменено на использование текущего экземпляра
        printNodeInternal(Collections.singletonList(this), 1, maxLevel);
    }

    private void printNodeInternal(List<BinaryTree<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<BinaryTree<T>> newNodes = new ArrayList<>();
        for (BinaryTree<T> node : nodes) {
            if (node != null) {
                System.out.print(node.key);
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (BinaryTree<T> node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (node.left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (node.right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
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

    private int maxLevel(AbstractBinaryTree<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    private boolean isAllElementsNull(List<?> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }
        return true;
    }

    public T findMin() {
        if (key == null) {
            throw new IllegalStateException("Дерево пустое");
        }

        T min = key;
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            BinaryTree<T> current = queue.poll();

            if (current.key.compareTo(min) < 0) {
                min = current.key;
            }

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return min;
    }

    public T findMax() {
        if (key == null) {
            throw new IllegalStateException("Дерево пустое");
        }

        T max = key;
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            BinaryTree<T> current = queue.poll();

            if (current.key.compareTo(max) > 0) {
                max = current.key;
            }

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return max;
    }
}