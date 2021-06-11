package com.zhl.graph;

import java.util.Stack;

/**
 * 寻找两点之间的路径
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (Integer i : G.adj(v)) {
            if (!marked[i]) {
                edgeTo[i] = v;
                dfs(G, i);
            }
        }
    }

    /**
     * 是否存在从s到v的路径
     *
     * @param v
     * @return
     */
    boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * s到v的路径，如果不存在则返回null
     *
     * @param v
     * @return
     */
    Iterable<Integer> pathTo(int v) {
        if (hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
