package com.zhl.graph;

import com.zhl.bag.Bag;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    
    public DepthFirstSearch(Graph G,int s){
        marked=new boolean[G.V()];
        
    }
    
    private void dfs(Graph G,int v){
        marked[v]=true;
        count++;
        for (Integer i: G.adj(v)) {
            if(!marked[i])
               dfs(G,i);
        }
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
