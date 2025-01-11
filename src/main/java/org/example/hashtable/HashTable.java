package org.example.hashtable;

import java.util.*;

public class HashTable<K, V> implements Iterable<KeyValue<K, V>> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.8d;

    private LinkedList<KeyValue<K, V>>[] slots;
    private int count;
    private int capacity;

    public HashTable() {
        this.capacity = INITIAL_CAPACITY;
        this.slots = new LinkedList[INITIAL_CAPACITY];
    }

    public HashTable(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.slots = new LinkedList[capacity];
    }

    public void add(K key, V value) {
        addOrReplace(key, value);
    }

    private int findSlotNumber(K key) {
        return Math.abs(key.hashCode()) % this.slots.length;
    }

    private void growIfNeeded() {
        if ((double) (this.size() + 1) / this.capacity() > LOAD_FACTOR) {
            this.grow();
        }
    }

    private void grow() {
        HashTable<K, V> resizedHashTable = new HashTable<>(INITIAL_CAPACITY * 2);
        for (LinkedList<KeyValue<K, V>> slot : slots) {
            if (slot != null) {
                for (KeyValue<K, V> keyValue : slot) {
                    resizedHashTable.add(keyValue.getKey(), keyValue.getValue());
                }
            }
        }

        capacity = resizedHashTable.capacity;
        slots = resizedHashTable.slots;
    }

    public int size() {
        return count;
    }

    public int capacity() {
        return slots.length;
    }

    public boolean addOrReplace(K key, V value) {
        growIfNeeded();

        int slotNumber = findSlotNumber(key);
        if (slots[slotNumber] == null) {
            slots[slotNumber] = new LinkedList<>();
        }

        for (KeyValue<K, V> keyValue : slots[slotNumber]) {
            if (keyValue.getKey().equals(key)) {
                keyValue.setValue(value);
                return false;
            }
        }

        slots[slotNumber].add(new KeyValue<>(key, value));
        count++;
        return true;
    }

    public V get(K key) {
        KeyValue<K, V> keyValue = find(key);
        if (keyValue == null) {
            System.out.println("Значений по ключу нет");
        }
        return keyValue.getValue();
    }

    public KeyValue<K, V> find(K key) {
        int slotNumber = findSlotNumber(key);
        if (slots[slotNumber] != null) {
            for (KeyValue<K, V> keyValue : slots[slotNumber]) {
                if (keyValue.getKey().equals(key)) {
                    return keyValue;
                }
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return find(key) != null;
    }

    public boolean remove(K key) {
        int slotNumber = findSlotNumber(key);
        if (slots[slotNumber] != null) {
            Iterator<KeyValue<K, V>> iterator = slots[slotNumber].iterator();
            while (iterator.hasNext()) {
                KeyValue<K, V> keyValue = iterator.next();
                if (keyValue.getKey().equals(key)) {
                    iterator.remove();
                    count--;
                    return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        count = 0;
        Arrays.fill(slots, null);
    }

    public Iterable<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> slot : slots) {
            if (slot != null) {
                for (KeyValue<K, V> keyValue : slot) {
                    keys.add(keyValue.getKey());
                }
            }
        }
        return keys;
    }

    public Iterable<V> values() {
        LinkedList<V> values = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> slot : slots) {
            if (slot != null) {
                for (KeyValue<K, V> keyValue : slot) {
                    values.add(keyValue.getValue());
                }
            }
        }
        return values;
    }

    @Override
    public Iterator<KeyValue<K, V>> iterator() {
        List<KeyValue<K, V>> allElements = new LinkedList<>();
        for (LinkedList<KeyValue<K, V>> slot : slots) {
            if (slot != null) {
                allElements.addAll(slot);
            }
        }
        return allElements.iterator();
    }

    @Override
    public String toString() {
        return "HashTable: count = " + count + ", capacity = " + capacity +
               "\nslots = " + Arrays.toString(slots);
    }
}



