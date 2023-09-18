package com.gaurav.cache.policies;

public interface EvictionPolicy <K> {
    void accessKey(K key);

    K getKey();
}
