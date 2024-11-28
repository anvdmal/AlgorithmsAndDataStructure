package org.example.maxheap;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> implements Heap<T> {
    private final ArrayList<T> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void add(T element) {
        this.heap.add(element);
        this.heapifyUp(this.size() - 1);
    }

    @Override
    public T peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.getFirst();
    }

    public T poll() {
        if (heap.isEmpty()) {
            return null;
        }

        T element = heap.getFirst();
        swap(0, this.size() - 1);
        heap.remove(this.size() - 1);

        this.heapifyDown(0);
        return element;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int max = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(max)) > 0) {
            max = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(max)) > 0) {
            max = rightChildIndex;
        }

        if (max != index) {
            swap(index, max);
            heapifyDown(max);
        }
    }

    private void swap(int currentIndex, int parentIndex) {
        T currentElement = heap.get(currentIndex);
        heap.set(currentIndex, heap.get(parentIndex));
        heap.set(parentIndex, currentElement);
    }

    @Override
    public String toString() {
        return String.valueOf(heap);
    }
}
