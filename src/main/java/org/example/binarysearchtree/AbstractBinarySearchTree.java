package org.example.binarysearchtree;

public interface AbstractBinarySearchTree<T extends Comparable<T>> {
    void insert(T element);
    boolean contains(T element);
    AbstractBinarySearchTree<T> search(T element);
    Node<T> getRoot();
    Node<T> getLeft();
    Node<T> getRight();
    T getValue();
    class Node<T> {
        public T value;
        public Node<T> leftChild;
        public Node<T> rightChild;

        Node(T value) {
            this.value = value;
        }

        Node(T value, Node<T> leftChild, Node<T> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}