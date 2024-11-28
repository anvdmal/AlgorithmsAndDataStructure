package org.example.maxheap;

public interface Heap<T extends Comparable<T>> {
    int size();
    void add(T element);
    T peek();
}
