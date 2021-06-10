package com.zhl.graph;

import com.zhl.bag.Bag;

import java.io.InputStream;

/**
 * 图
 */
public class Graph {

    private final int V;                //顶点数目
    private int E;                      //边的数目
    private Bag<Integer>[] adj;         //邻接表

    public Graph(int v) {
        this.V = v;
        adj = (Bag<Integer>[]) new Bag[V];    //创建临接表
        for (int i = 0; i < V; i++)           //初始化邻接表
            adj[i] = new Bag<Integer>();
    }

    public Graph(InputStream in, int v) {
        this(v);
    }

    public int V(){ return V; }

    public int E(){ return E; }

    public void addEdge(int v,int w){
        adj[v].add(w);                  //将w添加到v的链表中
        adj[w].add(v);                  //将v添加到w的链表中
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }


}
