package com.zhl.doublelinkedlist;


public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HerNode2 sj = new HerNode2(1, "宋江", "及时雨");
        HerNode2 ljy = new HerNode2(2, "卢俊义", "玉麒麟");
        HerNode2 wy = new HerNode2(3, "吴用", "智多星");
        HerNode2 lc = new HerNode2(4, "林冲", "豹子头");

        DoubleLinkedList singleLinkedlist = new DoubleLinkedList();
        singleLinkedlist.add(sj);
        singleLinkedlist.add(ljy);
        singleLinkedlist.add(lc);
        singleLinkedlist.addByOrder(wy);
        singleLinkedlist.list();
        System.out.println("==============update================");
        singleLinkedlist.update(new HerNode2(4, "公孙胜", "入云龙"));
        singleLinkedlist.list();
        singleLinkedlist.delete(6);
        System.out.println("==========delete===========");
        singleLinkedlist.list();
    }
}
class DoubleLinkedList{
    private HerNode2 head=new HerNode2(0,"","");

    public HerNode2 getHead() {
        return head;
    }

    public void delete(int no){
        HerNode2 temp=head.next;
        for(;temp!=null&&temp.no!=no;temp=temp.next){
        }
        if(temp==null){
            System.out.println("未找到或链表为空");
        }else{
            // 将要删除节点前一个节点的next指向要删除节点的下一个节点
            temp.pre.next=temp.next;
            //如果要删除节点为最后一个节点，不必更新下个节点的前一个节点
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }
    }
    public void list(){
        HerNode2 tmp=head.next;
        for(;tmp!=null;tmp=tmp.next){
            System.out.println(tmp);
        }
    }
    public void update(HerNode2 newHerNode){
        if(isEmpty()){
            System.out.println("为空");
        }
        HerNode2 tmp=head;
        for(;tmp!=null&&tmp.no!= newHerNode.no;tmp=tmp.next);
        if (tmp==null){
            System.out.println("未找到对应节点");
        }else{
            tmp.pre.next=newHerNode;
            newHerNode.pre=tmp.pre;
            newHerNode.next=tmp.next;
            if(tmp.next!=null){
                tmp.next.pre=newHerNode;
            }
        }
    }
    public boolean isEmpty(){
        return head.next==null;
    }
    public void addByOrder(HerNode2 herNode){
        HerNode2 tmp=head;
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
            tmp.next.pre=herNode;
            herNode.pre=tmp;
            tmp.next=herNode;
        }
    }
    public void add(HerNode2 herNode){
        HerNode2 tmp=head;
        while (true){
            if (tmp.next==null){
                tmp.next=herNode;
                herNode.pre=tmp;
                break;
            }
            tmp=tmp.next;
        }
    }
}
class HerNode2{
    public int no;
    public String name;
    public String nickname;
    public HerNode2 next;
    public HerNode2 pre;
    public HerNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HerNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                "}";
    }
}
