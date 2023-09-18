package com.gaurav.cache.dataStructure;

public class DoublyLinkedList<K> {
    private DoublyLinkedListNode<K> head;
    private DoublyLinkedListNode<K> tail;

    public DoublyLinkedList() {
        this.head = new DoublyLinkedListNode<>(null);
        this.tail = new DoublyLinkedListNode<>(null);
        head.next = tail;
        tail.prev = head;
    }

    public void detach(DoublyLinkedListNode<K> node) {
        if(node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addAtLast(DoublyLinkedListNode<K> node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }

    public DoublyLinkedListNode<K> addNewKey(K key) {
        DoublyLinkedListNode<K> node = new DoublyLinkedListNode<>(key);
        addAtLast(node);
        return node;
    }

    public DoublyLinkedListNode<K> getFirst() {
        if(head.next == tail) {
            return null;
        }
        return head.next;
    }

    public DoublyLinkedListNode<K> getLast() {
        if(head.next == tail) {
            return null;
        }
        return tail.prev;
    }
}
