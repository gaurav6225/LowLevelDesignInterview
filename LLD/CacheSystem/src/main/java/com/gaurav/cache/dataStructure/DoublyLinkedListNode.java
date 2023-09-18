package com.gaurav.cache.dataStructure;

public class DoublyLinkedListNode<K> {
    public K key;
    public DoublyLinkedListNode<K> next;
    public DoublyLinkedListNode<K> prev;

    public DoublyLinkedListNode(K key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}
