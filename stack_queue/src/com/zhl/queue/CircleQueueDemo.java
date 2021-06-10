package com.zhl.queue;

public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleQueue arrayQueue = new CircleQueue(10);

        for (int i = 0; i < 5; i++) {
            arrayQueue.enqueue(i);
        }
        arrayQueue.list();
        System.out.println("=========================");
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.list();
        System.out.println("=========================");
        arrayQueue.enqueue(6);
        arrayQueue.list();
    }
}

class CircleQueue{
    private int front;
    private int rear;
    private int[] queue;
    private int maxSize;
    public CircleQueue(int maxSize){
        this.maxSize=maxSize;
        queue=new int[maxSize];
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    public void enqueue(int i){
        if(isFull()){
            System.out.println("已满");
            return;
        }
        queue[rear]=i;
        rear=(rear+1)%maxSize;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("空");
            throw new RuntimeException("空");
        }
        int i = queue[front];
        front=(front+1)%maxSize;
        return i;
    }

    public void list(){
        for (int i = front; i <front+size() ; i++) {
            System.out.printf("queue[%d]=%d\n",i%maxSize,queue[i%maxSize]);
        }
    }
    public int size(){
        return (rear-front+maxSize)%maxSize;
    }

}

