package org.example;

import java.util.Objects;

public class Minion implements Comparable<Minion> {
    private String name;
    private int age;
    private int eyesCount;

    public Minion(String name, int age, int eyesCount) {
        this.name = name;
        this.age = age;
        this.eyesCount = eyesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEyesCount() {
        return eyesCount;
    }

    public void setEyesCount(int eyesCount) {
        this.eyesCount = eyesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minion minion = (Minion) o;
        return age == minion.age && eyesCount == minion.eyesCount && Objects.equals(name, minion.name);
    }

    @Override
    public String toString() {
        return "Minion " + name + ", age = " + age + ", eyes: " + eyesCount;
    }

    @Override
    public int compareTo(Minion otherMinion) {
        int compareName = this.getName().compareTo(otherMinion.getName());
        if (compareName != 0) {
            return compareName;
        }
        if (this.getAge() < otherMinion.getAge()) return 1;
        else if (this.getAge() > otherMinion.getAge()) return -1;

        int ageEyesThis = this.getAge() + this.getEyesCount();
        int ageEyesOther = otherMinion.getAge() + otherMinion.getEyesCount();
        if (ageEyesThis > ageEyesOther) return 1;
        else if (ageEyesThis < ageEyesOther) return -1;

        return compareName;
    }
}

