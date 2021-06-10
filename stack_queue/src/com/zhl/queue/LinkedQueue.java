package com.zhl.queue;

import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N = 0;

    private class Node {
        Node next;
        Item item;
    }

    public void enqueue(Item item) {


        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        Node flag = first;

        @Override
        public boolean hasNext() {
            return flag != null;
        }

        @Override
        public Item next() {
            Item item = flag.item;
            flag = flag.next;
            return item;
        }
    }
}
