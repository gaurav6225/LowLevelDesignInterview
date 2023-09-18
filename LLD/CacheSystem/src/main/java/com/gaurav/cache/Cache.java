package com.gaurav.cache;

import com.gaurav.cache.exceptions.NotFoundException;
import com.gaurav.cache.exceptions.StorageFullException;
import com.gaurav.cache.policies.EvictionPolicy;
import com.gaurav.cache.storage.Storage;

public class Cache <K, V> {
    private EvictionPolicy<K> evictionPolicy;
    private Storage<K,V> storage;

    public Cache (EvictionPolicy<K> evictionPolicy, Storage<K, V> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(K key, V value) {
        try {
            storage.add(key, value);
            evictionPolicy.accessKey(key);
        } catch (StorageFullException storageFullException) {
            System.out.println("Storage is full");
            K evictKey = evictionPolicy.getKey();
            if(evictKey == null) {
                System.out.println("Unexpected state no key to remove at full storage");
            }
            storage.remove(evictKey);
            storage.add(key, value);
        }
    }

    public V get(K key ) {
        try {
            V value = storage.get(key);
            evictionPolicy.accessKey(key);
            return value;
        } catch (NotFoundException notFoundException) {
            System.out.println("the key not found..");
            return null;
        }
    }

}
