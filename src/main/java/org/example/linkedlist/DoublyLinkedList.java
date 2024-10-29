package org.example.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
    private Node<T> listHead;
    private Node<T> listTail;

    public DoublyLinkedList() {
        this.listHead = null;
        this.listTail = null;
    }

    public void addHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (listHead == null) {
            listHead = newNode;
            listTail = newNode;
        } else {
            newNode.next = listHead;
            listHead.prev = newNode;
            listHead = newNode;
        }
    }

    public void addTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (listHead == null) {
            listHead = newNode;
            listTail = newNode;
        } else {
            listTail.next = newNode;
            newNode.prev = listTail;
            listTail = newNode;
        }
    }

    public void replaceNode(T oldData, T newData) {
        Node<T> current = listHead;
        while (current.next != null) {
            if (current.data.equals(oldData)) {
                current.data = newData;
                return;
            }
            current = current.next;
        }
    }

    public void removeHead() {
        if (listHead == null) return;
        if (listHead == listTail) {
            listHead = null;
            listTail = null;
            return;
        }

        Node<T> delNode = listHead;
        listHead = listHead.next;
        listHead.prev = null;
        delNode.next = null;
    }

    public void removeTail() {
        if (listTail == null) return;
        if (listHead == listTail) {
            listHead = null;
            listTail = null;
            return;
        }

        Node<T> delNode = listTail;
        listTail = listTail.prev;
        listTail.next = null;
        delNode.prev = null;
    }

    public int size() {
        int size = 0;
        Node<T> current = listHead;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void print() {
        Node<T> current = listHead;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private Node<T> getCurrentNode(int index, int size) {
        Node<T> current;
        if (index < size / 2) {
            current = listHead;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = listTail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    public T get(int index) {
        int size = size();

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы размера списка!");
        }

        Node<T> current = getCurrentNode(index, size);
        return current.data;
    }

    public void remove(int index) {
        int size = size();
        Node<T> current;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы размера списка!");
        }

        if (index == 0) {
            removeHead();
            return;
        }

        if (index == size - 1) {
            removeTail();
            return;
        }

        current = getCurrentNode(index, size);

        current.prev.next = current.next;
        current.next.prev = current.prev;

        current.prev = null;
        current.next = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<T> {
        Node<T> current = listHead;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            Node<T> lastReturnedNode = current;
            current = current.next;
            return lastReturnedNode.data;
        }
    }
}


class Node<T> {
    protected T data;
    protected Node<T> next;
    protected Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
