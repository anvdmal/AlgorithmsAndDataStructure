package org.example;

import java.util.ArrayList;
import java.util.List;

//имена в алф, возр по убыв, возр + глаз по возр
public class MinionComparator {
    public static void main(String[] args) {
        List<Minion> minionList = new ArrayList<>();
        minionList.add(new Minion("Геннадий", 20, 2));
        minionList.add(new Minion("Павел", 2, 1));
        minionList.add(new Minion("Алёша", 20, 2));
        minionList.add(new Minion("Владимир", 52, 2));
        minionList.add(new Minion("Геннадий", 20, 1));
        minionList.add(new Minion("Павел", 34, 2));
        minionList.add(new Minion("Геннадий", 34, 1));
        minionList.sort(Minion::compareTo);

        System.out.println("Отсортированный список:");
        for (Minion minion : minionList) {
            System.out.println(minion);
        }
    }
}

