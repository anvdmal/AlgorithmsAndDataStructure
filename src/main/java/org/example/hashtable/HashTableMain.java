package org.example.hashtable;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        hashTable.add("pear", 1);
        hashTable.add("orange", 4);
        hashTable.add("lemon", 5);
        hashTable.add("peach", 7);
        hashTable.add("plum", 9);
        hashTable.add("grape", 16);
        hashTable.add("melon", 17);
        System.out.println("Создание таблицы\n" + hashTable);

        String replaceKey = "orange";
        System.out.println("\n" + hashTable.find(replaceKey));
        hashTable.add(replaceKey, 44);
        System.out.println("Замена значения по ключу " + replaceKey + ":\n" + hashTable.find(replaceKey));

        String getKey = "melon";
        System.out.println("\nПолучение значения по ключу " + getKey + ":\n" + hashTable.get(getKey));

        System.out.println("\nВсе ключи: " + hashTable.keys());
        System.out.println("Все значения: " + hashTable.values());

        String removeKey = "pear";
        System.out.println("\nУдаление по ключу " + removeKey + ": " + hashTable.remove(removeKey));
        System.out.println("Наличие ключа " + removeKey + ": " + hashTable.containsKey(removeKey));
        System.out.println(hashTable);

        hashTable.clear();
        System.out.println("\nУдаление всех элементов\n" + hashTable);
    }
}
