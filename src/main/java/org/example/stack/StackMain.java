package org.example.stack;

public class StackMain {
    public static void main(String[] args) {
        StackRealization<Integer> stack = new StackRealization<>(10);

        System.out.println("Метод push()");
        stack.push(1);
        stack.push(4);
        stack.push(2);
        System.out.println(stack.print());

        System.out.println("\nМетод push() + resize()");
        stack.push(7);
        System.out.println(stack.print());

        System.out.println("\nМетод pop()");
        System.out.println(stack.pop());
        System.out.println(stack.print());

        System.out.println("\nМетод peek()");
        System.out.println(stack.peek());
        System.out.println(stack.print());

        System.out.println("\nМетод push()");
        stack.push(9);
        System.out.println(stack.print());

        System.out.println("\nПример использование итератора");
        for (Integer element : stack) {
            System.out.println(element);
        }
    }
}
