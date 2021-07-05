package com.zhl.digraph;

import com.zhl.bag.Bag;
import com.zhl.ginterface.G;

public class Digraph implements G {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V){
        this.V=V;
        this.adj=(Bag<Integer>[]) new Bag[this.V];
        for(Bag<Integer> b:this.adj){
            b=new Bag<>();
        }
    }

    @Override
    public int V(){
        return V;
    }

    @Override
    public int E(){
        return E;
    }

    @Override
    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v){
        return this.adj[v];
    }

    public Digraph reverse(){
        Digraph g=new Digraph(this.V);
        for(int v=0;v<this.V;v++){
            for(Integer w:adj(v)) {
                g.addEdge(w,v);
            }
        }
        return g;
    }

}
