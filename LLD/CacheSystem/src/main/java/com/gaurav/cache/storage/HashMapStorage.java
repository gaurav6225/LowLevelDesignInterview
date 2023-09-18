package com.gaurav.cache.storage;

import com.gaurav.cache.exceptions.NotFoundException;
import com.gaurav.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<K,V> implements Storage<K,V> {
    private Map<K,V> storage;
    private final Integer capacity;

    public HashMapStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    public void add(K key, V value) throws StorageFullException {
        if(!isStorageAvailable()) {
            throw new StorageFullException("Capacity Full..");
        }
        storage.put(key, value);
    }

    public void remove(K key) throws NotFoundException {
        if(!storage.containsKey(key)) {
            throw new NotFoundException("Key not found..");
        }
        storage.remove(key);
    }

    public V get(K key) throws NotFoundException {
        if(!storage.containsKey(key)) {
            throw new NotFoundException("Key not found..");
        }
        return storage.get(key);
    }

    public boolean isStorageAvailable() {
        return storage.size() < capacity;
    }
}
