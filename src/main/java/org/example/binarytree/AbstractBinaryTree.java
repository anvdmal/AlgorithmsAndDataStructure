package org.example.binarytree;

import java.util.List;
import java.util.function.Consumer;

public interface AbstractBinaryTree<T> {
    T getKey();
    void setKey(T key);
    AbstractBinaryTree<T> getLeft();
    AbstractBinaryTree<T> getRight();
    String asIndentedPreOrder(int indent);
    List<AbstractBinaryTree<T>> preOrder();
    List<AbstractBinaryTree<T>> inOrder();
    List<AbstractBinaryTree<T>> postOrder();
    void forEachInOrder(Consumer<T> consumer);
    StringBuilder buildIndentedTree(StringBuilder result, int level, int indent);
    void DFS();
    void BFS();
    void printTree();
}


