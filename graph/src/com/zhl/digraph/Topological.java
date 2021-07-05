package com.zhl.digraph;

/**
 * 拓扑排序
 * 有向的检测是拓扑排序的前提
 *
 * 有向图的拓扑顺序即为所有顶点的逆后续排序
 */
public class Topological {
    private Iterable<Integer> order;
    public Topological(Digraph G){
        DirectedCycle cycleFinder = new DirectedCycle(G);
        if(!cycleFinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    /**
     * G 是有向无环图吗
     * @return
     */
    public boolean isDAG(){
        return order!=null;
    }

    /**
     * 拓扑有序的所有顶点
     * @return
     */
    Iterable<Integer> order(){
        return order;
    }
}
