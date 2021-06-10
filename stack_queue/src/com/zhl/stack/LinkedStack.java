package com.zhl.stack;

import java.util.Iterator;

public class LinkedStack<Item> implements Iterable<Item> {
    private int N = 0;

    private Node first;

//    public LinkedStack()


    private class Node {
        Node next;
        Item item;
    }

    public void push(Item item){
        Node oldFirst=first;
        first=new Node();
        first.item=item;
        first.next=oldFirst;
        this.N++;
    }

    public Item pop(){
        Item item = first.item;
        first=first.next;
        this.N--;
        return item;
    }

    public boolean isEmpty(){
        return first==null;
    }
    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        Node flag=first;
        @Override
        public boolean hasNext() {
            return flag!=null;
        }

        @Override
        public Item next() {
            Item item = flag.item;
            flag=flag.next;
            return item;
        }
    }
}
