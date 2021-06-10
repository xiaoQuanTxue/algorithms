package com.zhl.tree;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node {
        private Key key;
        private Value val;
        private Node right, left;
        private int N;
        private boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }

    private int size(Node x) {
        if (x == null) return 0;
        else           return x.N;
    }

    /**
     * 为空便是黑色
     *
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        if (x == null) return false;
        else           return x.color;
    }

    private void flipColors(Node h) {
        h.right.color = h.left.color = BLACK;
        h.color = RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        h.color = x.color;
        x.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        h.color = x.color;
        x.color = RED;
        x.N = h.N;
        h.N = size(h.right) + size(h.left) + 1;
        return x;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp > 0)
            h.right = put(h.right, key, val);
        else if (cmp < 0)
            h.left = put(h.left, key, val);
        else h.val = val;
        /**
         * 1. 插入结点结点2-结点的时候
         *  1）插入到2-结点的右节点，左旋
         *  2）插入到2-结点的左节点，什么都不用干
         * 2. 插入结点时3-结点的时候
         *  1) 如果结点大于3-结点中的两个结点，将4-结点转为3-结点（调用 filpColor方法）
         *              A                      A                        |r
         *           / r      ->insert c    / r  \r      ->flipColor    A
         *         B                      B         C                / b  \b
         *                                                         B         C
         *  2） 如果结点在3-结点的两个结点中间 rotateLeft 然后到更上一层结点时 rotateRight，然后flipColor
         *          A                         A                               A
         *       / r      -> insert B      / r           ->rotateLeft      / r
         *     C                          C                              B
         *        \ r                         \  r                     / r
         *           B                         B                     C
         *-------------------------------------------------------------------------------------
         *         A                               B
         *       / r     ->rotateRight           / r \r  ->filpColor
         *     B                               C      A
         *   / r
         * C
         *
         *  3） 如果结点小于3-结点中的两个结点，rotateRight
         *
         *
         *
         */
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }

    public void put(Key key,Value val){
        Node root = put(this.root, key, val);
        //将因为可能因为flip方法转变为红色的根节点变回黑色，根节点没从红色变为黑色一次，红黑树的高度便加1
        root.color=BLACK;
    }
}


