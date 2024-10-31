package org.example.binarytree;

import java.util.List;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = getIntegerBinaryTree();

        System.out.println("\nPreOrder:");
        List<AbstractBinaryTree<Integer>> preOrderList = binaryTree.preOrder();
        for (AbstractBinaryTree<Integer> i : preOrderList) {
            System.out.print(i.getKey() + " ");
        }

        System.out.println("\n\nInOrder:");
        List<AbstractBinaryTree<Integer>> inOrderList = binaryTree.inOrder();
        for (AbstractBinaryTree<Integer> i : inOrderList) {
            System.out.print(i.getKey() + " ");
        }

        System.out.println("\n\nPostOrder:");
        List<AbstractBinaryTree<Integer>> postOrderList = binaryTree.postOrder();
        for (AbstractBinaryTree<Integer> i : postOrderList) {
            System.out.print(i.getKey() + " ");
        }

        System.out.println("\n\nInOrder (Consumer)");
        binaryTree.forEachInOrder(System.out::println);

        System.out.println("\nDFS (стек)");
        binaryTree.DFS();

        System.out.println("\n\nBFS (очередь)");
        binaryTree.BFS();
//
//        System.out.println("\n\nМинимальное значение: " + binaryTree.findMin());
//        System.out.println("Максимальное значение: " + binaryTree.findMax());
    }

    private static BinaryTree<Integer> getIntegerBinaryTree() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(4);
        BinaryTree<Integer> childLeft = new BinaryTree<>(2);
        BinaryTree<Integer> childRight = new BinaryTree<>(6);
        BinaryTree<Integer> childLeft1 = new BinaryTree<>(14);
        BinaryTree<Integer> childRight1 = new BinaryTree<>(1);
        BinaryTree<Integer> childLeft2 = new BinaryTree<>(5);
        BinaryTree<Integer> childRight2 = new BinaryTree<>(7);
        BinaryTree<Integer> childLeft3 = new BinaryTree<>(11);
        BinaryTree<Integer> childRight3 = new BinaryTree<>(9);

        binaryTree.setLeft(childLeft);
        binaryTree.setRight(childRight);

        childLeft.setLeft(childLeft1);
        childLeft.setRight(childRight1);

        childRight.setLeft(childLeft2);
        childRight.setRight(childRight2);

        childLeft1.setLeft(childLeft3);
        childLeft2.setRight(childRight3);

        System.out.println("Бинарное дерево:");
        binaryTree.printTree();
        return binaryTree;
    }
}