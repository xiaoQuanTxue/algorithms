package com.zhl.linkedlist;

import java.util.LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HerNode sj = new HerNode(1, "宋江", "及时雨");
        HerNode ljy = new HerNode(2, "卢俊义", "玉麒麟");
        HerNode wy = new HerNode(3, "吴用", "智多星");
        HerNode lc = new HerNode(4, "林冲", "豹子头");

        SingleLinkedlist singleLinkedlist = new SingleLinkedlist();
        singleLinkedlist.add(sj);
        singleLinkedlist.add(ljy);
        singleLinkedlist.add(lc);
        singleLinkedlist.addByOrder(wy);
        singleLinkedlist.addByOrder(wy);
        singleLinkedlist.update(new HerNode(5, "公孙胜", "入云龙"));
        singleLinkedlist.list();

        singleLinkedlist.delete(6);
        System.out.println("==========delete===========");
        singleLinkedlist.list();
//        singleLinkedlist.reverse();
        System.out.println("==========reverse===========");
        System.out.println(SingleLinkedListDemo.length(singleLinkedlist.getFirst()));
        System.out.println(SingleLinkedListDemo.reverseCountNode(singleLinkedlist.getFirst(),2));
        singleLinkedlist.list();
        System.out.println("==========reversep===========");
        reversePrint(singleLinkedlist.getFirst());
    }
    public static int length(HerNode head){
        HerNode tmp=head.next;
        int count=0;
        for(;tmp!=null;tmp=tmp.next){
            count++;
        }
        return count;
    }

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static HerNode reverseCountNode(HerNode head,int k){
        HerNode first=head;
        HerNode second=head;
        int count=0;
        while (first!=null){
            first=first.next;
            count++;
            if(count>k){
                second=second.next;
            }
        }
        return second;
    }

    /**
     * 逆序打印
     * 也可以使用栈
     * @param head
     */
    public static void reversePrint(HerNode head){
        if(head==null)return;
        reversePrint(head.next);
        System.out.println(head);
    }

    public static HerNode merge(HerNode head1,HerNode head2) {
        HerNode newNode = new HerNode(0, "", "");
        HerNode tmp=newNode;
        HerNode tmp1 = head1;
        HerNode tmp2 = head2;

        while (true) {
            if (tmp1 == null) {
                tmp.next = tmp2;
                break;
            }
            if (tmp2 == null) {
                tmp.next = tmp1;
                break;
            }
            if (tmp1.no > tmp2.no) {
                tmp.next=tmp2;
                tmp=tmp.next;
            }else{
                tmp.next=tmp1;
                tmp=tmp.next;
            }
        }
        return newNode;
    }
}
class SingleLinkedlist{
    private HerNode first;

    public SingleLinkedlist() {
        this.first = new HerNode(0,"","");
    }

    public HerNode getFirst() {
        return first;
    }

    public void add(HerNode herNode){
        HerNode tmp=first;
        while (true){
            if (tmp.next==null){
                tmp.next=herNode;
                break;
            }
            tmp=tmp.next;
        }
    }

    public void addByOrder(HerNode herNode){
        HerNode tmp=first;
        boolean flag=false;
        while (true){
            if (tmp.next==null){
                break;
            }else if(tmp.next.no>herNode.no){
                break;
            }if (tmp.next.no== herNode.no){
                flag=true;
                break;
            }
            tmp=tmp.next;
        }
        if(flag){
            System.out.println("已存在");
        }else{
            herNode.next=tmp.next;
            tmp.next=herNode;
        }
    }
    public void update(HerNode newHerNode){
        if(isEmpty()){
            System.out.println("为空");
        }
        HerNode tmp=first;
        for(;tmp.next!=null&&tmp.next.no!= newHerNode.no;tmp=tmp.next);
        if (tmp.next==null){
            System.out.println("未找到对应节点");
        }else{
            tmp.next=newHerNode.next;
            tmp.next=newHerNode;
        }
    }
    public void delete(int no){
        HerNode tmp=first;
        for(;tmp.next!=null&&tmp.next.no!=no;tmp=tmp.next);
        if (tmp.next==null){
            System.out.println("未找到");
        }else{
            tmp.next=tmp.next.next;
        }
    }
    public boolean isEmpty(){
        return first.next==null;
    }
    public void list(){
        HerNode tmp=first;
        for(;tmp!=null;tmp=tmp.next){
            System.out.println(tmp);
        }
    }
    public void reverse(){



    }
}
class HerNode{
    public int no;
    public String name;
    public String nickname;
    public HerNode next;

    public HerNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}'+"\n";
    }
}
