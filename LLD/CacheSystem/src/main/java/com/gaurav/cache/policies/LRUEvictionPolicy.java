package com.gaurav.cache.policies;

import com.gaurav.cache.dataStructure.DoublyLinkedList;
import com.gaurav.cache.dataStructure.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

    private DoublyLinkedList<K> list;
    private Map<K, DoublyLinkedListNode<K>> mp;

    public LRUEvictionPolicy() {
        this.list = new DoublyLinkedList<>();
        this.mp = new HashMap<>();
    }

    @Override
    public void accessKey(K key) {
        if(!mp.containsKey(key)) {
            mp.put(key, list.addNewKey(key));
        } else {
            list.detach(mp.get(key));
            list.addAtLast(mp.get(key));
        }
    }

    @Override
    public K getKey() {
        DoublyLinkedListNode<K> firstNode = list.getFirst();
        if(firstNode == null)
            return null;
        list.detach(firstNode);
        return firstNode.key;
    }
}
