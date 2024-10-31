package org.example.binarysearchtree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insert(6);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        binarySearchTree.insert(11);
        binarySearchTree.insert(8);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(15);

        System.out.println("Бинарное дерево поиска:");
        binarySearchTree.printSearchTree();

        int searchElement = 17;
        if (binarySearchTree.contains(searchElement)) {
            System.out.printf("\nПоиск элемента:\nДерево содержит элемент %s!\n", searchElement);
        } else {
            System.out.printf("\nПоиск элемента:\nДерево не содержит элемент %s!\n", searchElement);
        }

        int newRoot = 9;
        BinarySearchTree<Integer> newTree = (BinarySearchTree<Integer>) binarySearchTree.search(newRoot);
        System.out.printf("\nВывод дерева с корнем %s:\n", newRoot);
        newTree.printSearchTree();

        int minValue = binarySearchTree.findMinimum(binarySearchTree.getRoot()).value;
        int maxValue = binarySearchTree.findMaximum(binarySearchTree.getRoot()).value;
        System.out.println("\nМинимальное значение: " + minValue);
        System.out.println("Максимальное значение: " + maxValue);
    }
}



