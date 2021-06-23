package com.zhl.ginterface;

public interface G {

    int V();//返回边数
    int E();//返回定点数
    void addEdge(int v,int w);//添加一条v->w的边
    Iterable<Integer> adj(int v);//返回点v连接的所有边

}
