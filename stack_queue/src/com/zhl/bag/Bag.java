package com.zhl.bag;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private int N = 0;

    private Node first;

    public Bag(){

    }


    private class Node {
        Node next;
        Item item;
    }

    public void add(Item item){
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

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{
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
