package com.gaurav.cache.factories;

import com.gaurav.cache.Cache;
import com.gaurav.cache.policies.EvictionPolicy;
import com.gaurav.cache.policies.LRUEvictionPolicy;
import com.gaurav.cache.storage.HashMapStorage;

public class CacheFactory<K, V> {
    public Cache<K, V> defaultCache(int capacity) {
        return new Cache<>(new LRUEvictionPolicy<K>(), new HashMapStorage<K,V>(capacity));
    }
}
