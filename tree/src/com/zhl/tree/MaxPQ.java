package com.zhl.tree;

/**
 * 最大优先队列，队列中父节点必须比两个子结点都大，
 * 但是左右结点不要求谁大谁小
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;

    private int n = 0;

    private static final int DEFAULT_CAPACITY = 10;

    public MaxPQ() {
        this.pq = (Key[]) new Object[DEFAULT_CAPACITY + 1];
    }

    public MaxPQ(int length) {
        this.pq = (Key[]) new Object[length + 1];
    }

    public MaxPQ(Key[] keys) {
        this.pq = keys;
    }

    /**
     * 插入元素
     *
     * @param key
     */
    public void insert(Key key) {
        pq[++n] = key;
        swim(n);
        if(n>pq.length*0.75){
            resize(pq.length*2);
        }
    }

    /**
     * 返回最大值
     *
     * @return
     */
    public Key max() {
        return pq[1];
    }

    /**
     * 删除并返回最大值
     *
     * @return
     */
    public Key delMax() {
        Key key = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);
        if(n<pq.length/2){
            resize(pq.length/2);
        }
        return key;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * 最大优先队列的长度
     *
     * @return
     */
    public int size() {
        return n;
    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void exch(int i, int j) {
        Key key = pq[i];
        pq[i] = pq[j];
        pq[j] = key;
    }

    /**
     * 上浮
     * 如果父节点i/2比子结点i小，两者交换，i=i/2
     *
     * @param i
     */
    public void swim(int i) {
        while (i > 1 && less(i / 2, i)) {
            exch(i / 2, i);
            i /= 2;
        }
    }

    /**
     * 下沉
     * 如果父节点小于子结点较大的那个
     * 父节点与子结点交换
     * 否则
     * 结束
     *
     * @param i
     */
    public void sink(int i) {
        while (2 * i <= n) {
            int j = 2 * i;
            if (less(j, j + 1)) j++;
            if (!less(i, j)) break;
            exch(i, j);
            i = j;
        }
    }

    public void resize(int newLen) {
        Key[] keys = (Key[]) new Object[newLen];
        for (int i = 0; i <= n; i++) {
            keys[i] = pq[i];
        }
        this.pq = keys;
    }
}
