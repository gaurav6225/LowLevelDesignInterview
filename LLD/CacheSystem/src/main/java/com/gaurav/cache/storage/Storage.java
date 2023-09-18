package com.gaurav.cache.storage;

import com.gaurav.cache.exceptions.NotFoundException;
import com.gaurav.cache.exceptions.StorageFullException;

public interface Storage <K, V>{
    void add(K key, V value) throws StorageFullException;
    void remove(K key) throws NotFoundException;
    V get(K key) throws NotFoundException;
    boolean isStorageAvailable();
}
