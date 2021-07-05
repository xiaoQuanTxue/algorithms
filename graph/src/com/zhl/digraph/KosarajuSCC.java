package com.zhl.digraph;

/**
 * 科萨拉珠算法
 * 计算强连通分量
 *
 * 1）先深度遍历逆向图，获取顶点逆后续排列
 * 2）以逆后序遍历原图
 * 3）算法完毕
 *
 * 强连通分量 如果两个顶点v和w互相是可达的，则称他们为强连通分量
 * 即存在从v到w的有向路径，也存在从w到v的有向路径
 *
 * 这个算法的原理（本人理解）：
 * 根据有向连通分量的定义，v和w强连通，意味着v->w,w->v（逆向）
 * 所以先遍历一边方向图，然后获取顶点的逆后序排列
 *
 * 获取顶点的逆后序排列的意义
 *
 * 解释一下便是逆后序队列中顶点v直接或者间接连通的顶点w都在顶点v的后边
 *
 * 强连通的定义是从当两个顶点是互相可达的就是强连通的。具体解释的话就是正着v可以到w,反过来w也可以到v。
 *
 * 因此先遍历反向图，获取逆后序。
 *
 * 接着按照逆后序遍历正向图仍然连通的顶点便是强连通的了。
 *
 */
public class KosarajuSCC {
    private int[] id;
    private boolean[] marked;
    private int count;

    public KosarajuSCC(Digraph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for (int s : order.reversePost()) {
            dfs(G,s);
            count++;
        }
    }

    private void dfs(Digraph G, int v) {
        id[v] = count;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                id[w] = count;
                dfs(G, w);
            }
        }
    }

    public int id(int v) {
        return id[v];
    }

    public int count(){
        return count;
    }

    public boolean connected(int v,int w){
        return id[v]==id[w];
    }
}
