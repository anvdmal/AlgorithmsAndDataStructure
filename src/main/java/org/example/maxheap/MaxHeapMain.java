package org.example.maxheap;

public class MaxHeapMain {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(0);
        maxHeap.add(7);
        maxHeap.add(0);
        maxHeap.add(4);

        System.out.println("MaxHeap = " + maxHeap + ", размер: " + maxHeap.size());
        System.out.println("peek: " + maxHeap.peek()); //7

        maxHeap.add(24);
        maxHeap.add(4);
        System.out.println("\nДобавление новых элементов\n" + maxHeap + ", размер: " + maxHeap.size());

        System.out.println("peek: " + maxHeap.peek()); //24
    }
}
