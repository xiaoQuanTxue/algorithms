package com.zhl.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);

        for (int i = 0; i < 5; i++) {
            arrayQueue.enQueue(i);
        }
        arrayQueue.list();
        arrayQueue.deQueue();
        arrayQueue.deQueue();
        arrayQueue.list();
        arrayQueue.enQueue(6);
        arrayQueue.list();
    }
}
class ArrayQueue{
    private int front;
    private int rear;
    private int maxSize;
    private int[] queue;

    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        queue=new int[this.maxSize];
        this.rear=-1;
        this.front=-1;
    }

    public boolean isEmpty(){
        return rear==front;
    }
    public boolean isFull(){
        return this.maxSize-1==rear;
    }

    public void enQueue(int i){
        if(isFull()){
            throw new RuntimeException("已满");
        }
        this.rear++;
        queue[rear]=i;
    }

    public int deQueue(){
        if(isEmpty()){
            throw new RuntimeException("已空");
        }
        this.front++;
        return queue[front];
    }

    public int head(){
        if(isEmpty()){
            throw new RuntimeException("空");
        }
        return queue[front+1];
    }
    public void list(){

        for (int i = front+1; i <= rear; i++) {
            System.out.printf("%d\t",queue[i]);
        }
        System.out.println();
    }
}
