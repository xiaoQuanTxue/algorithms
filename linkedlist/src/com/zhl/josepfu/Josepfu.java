package com.zhl.josepfu;

/**
 * 约瑟夫问题
 *
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list=new CircleSingleLinkedList(5);
        list.list();
        list.countBoy(1,2,5);
    }
}
class CircleSingleLinkedList{
    private Boy first;

    public CircleSingleLinkedList(int num){
        if(num<1){
            System.out.println("数目不对");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <=num ; i++) {
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                curBoy=first;
                curBoy.setNext(first);
            }else{
                curBoy.setNext(boy);
                curBoy=curBoy.getNext();
                curBoy.setNext(first);
            }
        }
    }
    public void list(){
        if(first==null){
            System.out.println("链表为空");
        }else{
            Boy curBoy=first;
            for (;;curBoy=curBoy.getNext()){
                System.out.printf("小孩编号为%d\n",curBoy.getNo());
                if(curBoy.getNext()==first){
                    break;
                }
            }
        }
    }
    public void countBoy(int startNo,int countNumber,int nums){
        if(startNo<1||countNumber>nums||first==null){
            System.out.println("============");
            return;
        }

        Boy helper=first;
        while(helper.getNext()!=first){
            helper=helper.getNext();
        }
        while (first.getNo()!=startNo) {
            first=first.getNext();
            helper=helper.getNext();
        }
        //当只剩下一个小孩时停止
        while (helper!=first){

            for (int i = 0; i < countNumber-1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("出圈的孩子：%d\n",first.getNo());

            first=first.getNext();
            helper.setNext(first);

        }
        System.out.println("最后出圈的孩子"+first.getNo());
    }
}
class Boy{
    private int no;
    private Boy next;
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
