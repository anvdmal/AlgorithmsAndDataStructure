package org.example.priorityqueue;

import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue<T extends Comparable<T>> implements AbstractQueue<T> {
    private final LinkedList<T> priorityQueue;

    public PriorityQueue() {
        this.priorityQueue = new LinkedList<>();
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }

    @Override
    public void add(T element) {
        ListIterator<T> iterator = priorityQueue.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().compareTo(element) <= 0) { //идем по всем элементам списка, пока не найдется элемент меньше добавляемого
                iterator.previous();
                break; //пример [2, 0] вставляем 1. 1 > 2, нет, идем дальше; 1 > 0, да, вставляем ПЕРЕД 0 [2, 1, 0]
            }
        }
        iterator.add(element);
    }

    @Override
    public T peek() {
        if (priorityQueue.isEmpty()) {
            return null;
        }
        return priorityQueue.getFirst();
    }

    @Override
    public T poll() {
        if (priorityQueue.isEmpty()) {
            return null;
        }
        return priorityQueue.removeFirst();
    }

    @Override
    public String toString() {
        return String.valueOf(priorityQueue);
    }
}
