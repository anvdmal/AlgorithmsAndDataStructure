package org.example.linkedlist;

import org.example.Minion;

public class LinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList<Minion> minionList = new DoublyLinkedList<>();

        System.out.println("СПИСОК МИНЬОНОВ");
        minionList.addHead(new Minion("Геннадий", 20, 2));
        minionList.addHead(new Minion("Алёша", 20, 2));
        minionList.addHead(new Minion("Владимир", 52, 2));
        minionList.addHead(new Minion("Геннадий", 20, 1));
        minionList.addHead(new Minion("Семён", 2, 1));
        minionList.addHead(new Minion("Павел", 34, 2));
        for (Minion minion : minionList) {
            System.out.println(minion);
        }
        System.out.println("\nДОБАВЛЕНИЕ МИНЬОНА В НАЧАЛО СПИСКА");
        minionList.addHead(new Minion("Григорий", 21, 1));
        minionList.print();

        System.out.println("\nДОБАВЛЕНИЕ МИНЬОНА В КОНЕЦ СПИСКА");
        minionList.addTail(new Minion("Семён", 2, 1));
        minionList.print();

        System.out.println("\nРАЗМЕР СПИСКА: " + minionList.size());

        System.out.println("\nИЗМЕНЕНИЕ МИНЬОНА");
        Minion oldMinion = new Minion("Алёша", 15, 2);
        Minion newMinion = new Minion("Пётр", 20, 1);
        minionList.replaceNode(oldMinion, newMinion);
        minionList.print();

        System.out.println("\nУДАЛЕНИЕ МИНЬОНА С НАЧАЛА СПИСКА");
        minionList.removeHead();
        minionList.print();

        System.out.println("\nУДАЛЕНИЕ МИНЬОНА С КОНЦА СПИСКА");
        minionList.removeTail();
        minionList.print();

        System.out.println("\nПРИМЕР ИСПОЛЬЗОВАНИЯ ИТЕРАТОРА");
        for (Minion minion : minionList) {
            System.out.println(minion);
        }
        System.out.println("\nРАЗМЕР СПИСКА: " + minionList.size());

        System.out.println("\nПОЛУЧЕНИЕ ЭЛЕМЕНТА ПО ИНДЕКСУ");
        int index = 4;
        System.out.println("Элемент по индексу " + index + ": " + minionList.get(index));

        System.out.println("\nУДАЛЕНИЕ ЭЛЕМЕНТА ПО ИНДЕКСУ " + index);
        minionList.remove(index);
        for (Minion minion : minionList) {
            System.out.println(minion);
        }
    }
}


