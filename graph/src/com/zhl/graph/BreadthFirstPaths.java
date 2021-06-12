package com.zhl.graph;

import com.zhl.queue.LinkedQueue;

import java.util.LinkedList;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        marked[s] = true;
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            Integer v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    queue.enqueue(w);
                    edgeTo[w] = v;
                    marked[w] = true;
                }
            }
        }
    }
}
