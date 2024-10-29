package org.example.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackRealization<T> implements Iterable<T> {
    private T[] stackArray;
    private int top;
    private int size;

    public StackRealization(int size) {
        this.size = size;
        this.stackArray = (T[]) new Object[size];
        this.top = -1;
    }

    public void push(T data) {
        if (top == stackArray.length - 1) {
            resize();
        }
        stackArray[++top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stackArray[top--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stackArray[top];
    }

    public void resize() {
        stackArray = Arrays.copyOf(stackArray, stackArray.length * 2);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public String print() {
        return "Stack: " + Arrays.toString(stackArray) + ", current top: " + top;
    }

    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int currentIndex = top;

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }

            return stackArray[currentIndex--];
        }
    }
}

