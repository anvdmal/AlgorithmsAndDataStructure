package org.example.priorityqueue;

import org.example.maxheap.MaxHeap;

public class PriorityQueueTask<T extends Comparable<T>> {
    private final MaxHeap<T> heap;

    public PriorityQueueTask() {
        this.heap = new MaxHeap<>();
    }

    public int size() {
        return heap.size();
    }

    public void add(T element) {
        heap.add(element);
    }

    public T poll() {
        return heap.poll();
    }

    public T peek() {
        return heap.peek();
    }

    @Override
    public String toString() {
        return "PriorityQueue based on heap = " + heap;
    }
}

class PriorityQueueTaskMain {
    public static void main(String[] args) {
        PriorityQueueTask<Integer> priorityQueue = new PriorityQueueTask<>();

        priorityQueue.add(5);
        priorityQueue.add(17);
        priorityQueue.add(10);
        priorityQueue.add(31);
        priorityQueue.add(24);
        priorityQueue.add(2);

        System.out.println(priorityQueue + ", размер: " + priorityQueue.size());
        System.out.println("peek: " + priorityQueue.peek()); //31
        System.out.println("poll: " + priorityQueue.poll()); //31
        System.out.println(priorityQueue + ", размер: " + priorityQueue.size());

        priorityQueue.add(30);
        System.out.println("\nДобавление новых элементов\n" + priorityQueue + ", размер: " + priorityQueue.size());

        System.out.println("poll: " + priorityQueue.poll());
        System.out.println(priorityQueue + ", размер: " + priorityQueue.size());
    }
}

