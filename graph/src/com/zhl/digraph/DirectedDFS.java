package com.zhl.digraph;

import com.zhl.bag.Bag;

public class DirectedDFS {
    private boolean[] marked;

    /**
     * 找到G图中s可达的所有顶点
     * @param G
     * @param s
     */
    public DirectedDFS(Digraph G,int s){
        marked=new boolean[G.V()];
        dfs(G,s);
    }

    /**
     * 找到G图中sourcesl可达的所有顶点
     * @param G
     * @param sources
     */
    public DirectedDFS(Digraph G,Iterable<Integer> sources){
        marked=new boolean[G.V()];
        for (Integer i:sources)
            dfs(G,i);
    }

    public void dfs(Digraph G,int s){
        marked[s]=true;
        for(Integer i:G.adj(s)){
            if(!marked[i]){
                dfs(G,i);
            }
        }
    }

    boolean marked(int v){
        return marked[v];
    }

}
