package org.example.priorityqueue;

public class PriorityQueueMain {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(0);
        priorityQueue.add(7);
        priorityQueue.add(0);
        priorityQueue.add(4);

        System.out.println("PriorityQueue = " + priorityQueue + ", размер: " + priorityQueue.size());
        System.out.println("peek: " + priorityQueue.peek()); //7
        System.out.println("poll: " + priorityQueue.poll()); //7
        System.out.println("peek: " + priorityQueue.peek()); //4
        System.out.println("PriorityQueue = " + priorityQueue + ", размер: " + priorityQueue.size());

        priorityQueue.add(3);
        priorityQueue.add(24);
        System.out.println("\nДобавление новых элементов\n" + priorityQueue + ", размер: " + priorityQueue.size());

        System.out.println("poll: " + priorityQueue.poll()); //24
        System.out.println("poll: " + priorityQueue.poll()); //4
        System.out.println("PriorityQueue = " + priorityQueue + ", размер: " + priorityQueue.size());
    }
}
