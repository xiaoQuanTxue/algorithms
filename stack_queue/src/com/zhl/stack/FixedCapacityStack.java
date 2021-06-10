package com.zhl.stack;

import java.util.Iterator;

public class FixedCapacityStack <Item> implements Iterable<Item>{

    private Item[] stack;

    private int N;

    public FixedCapacityStack(int capacity){
        stack=(Item[]) new Object[capacity];
    }
    public Item pop(){
        if(isEmpty())return null;
        Item item=stack[--N];
        stack[N]=null;
        if(N>0&&N==stack.length/4){
            resize(stack.length/2);
        }
        return item;
    }

    public void push(Item newVal){

        if(N== stack.length){
            resize(2*stack.length);
        }
        stack[N++]=newVal;
    }

    public boolean isEmpty(){
        return N==0;
    }

    private void resize(int max){
        Item[] tmp=(Item[])  new Object[max];
        for (int i = 0; i < stack.length; i++) {
            tmp[i]=stack[i];
        }
        stack=tmp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return stack[--i];
        }
    }
}
