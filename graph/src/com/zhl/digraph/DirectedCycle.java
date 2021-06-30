package com.zhl.digraph;

import com.zhl.graph.Graph;

import java.util.Stack;

public class DirectedCycle {

    private int[] edgeTo;
    private boolean[] marked;
    private boolean[] onStack;//递归递归调用的栈上的所有顶点
    private Stack<Integer> cycle; //有向环中的所有顶点，如果存在

    public DirectedCycle(Digraph G) {
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];

    }


    public void dfs(Digraph G,int v){
        marked[v]=true;
        onStack[v]=true;
        for(Integer w:G.adj(v)){
            if(hasCycle()) return;
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }else if(onStack[w]){
                cycle=new Stack<>();
                for(int x=v;x!=w;x=edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        //和v连接的点都没有环
        onStack[v]=false;
    }

    /**
     * G是否含有有向环
     *
     * @return
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * 有向环中的所有顶点
     *
     * @return
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
}
