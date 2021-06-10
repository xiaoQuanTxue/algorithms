package com.zhl.tree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BineryTree<T> {
    private Node<T> root;

    public BineryTree() {

    }

    public BineryTree(Node<T> root) {
        this.root = root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /*
    中序遍历
     */
    public void inOrderTraversal(Node<T> root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val);
            inOrderTraversal(root.right);
        }
    }

    /*
    先序遍历
     */
    public void preOrderTraversal(Node<T> root) {
        if (root != null) {
            System.out.print(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /*
    后续遍历
     */
    public void postOrderTraversal(Node<T> root) {
        if (root != null) {
            postOrderTraversal(root.left);
            System.out.print(root.val);
            postOrderTraversal(root.right);
        }
    }

    //非递归中序遍历
    public void nonInOrderTraversal(Node<T> root) {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> t = root;

        while (!stack.isEmpty() || t != null) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            System.out.print(t.val);
            t = t.right;
        }

    }

    //非递归先序遍历
    public void nonPreOrderTraversal(Node<T> root) {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> t = root;
        while (!stack.isEmpty() || t != null) {
            while (t != null) {
                System.out.print(t.val);
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            t = t.right;
        }
    }

    //层序遍历
    public void levelOrderTraversal(Node<T> root) {
        LinkedList<Node<T>> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node<T> t = list.removeFirst();
            System.out.print(t.val);
            if (t.left != null) {
                list.addLast(t.left);
            }
            if (t.right != null) {
                list.addLast(t.right);
            }
        }
    }

    /**
     * 输入所有叶子结点
     */

    public void preOrderPrintLeaves(Node<T> root) {
        if (root != null) {
            if (root.right == null && root.left == null) {
                System.out.print(root.val);
            }
            preOrderPrintLeaves(root.left);
            preOrderPrintLeaves(root.right);
        }
    }

    /**
     * 获取树的高度
     *
     * @param root
     * @return
     */
    public int getHeight(Node<T> root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 通过队列层序创建二叉树
     * @return
     */
    public Node<Integer> createTree() {
        Node<Integer> root = null;
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if(i==0){
            return root;
        }
        root = new Node<>(i, null, null);
        LinkedList<Node<Integer>> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node<Integer> t = queue.removeFirst();
            int leftVal = scanner.nextInt();
            if (leftVal == 0) {
                t.left = null;
            } else {
                t.left = new Node<>(leftVal, null, null);
                queue.addLast(t.left);
            }
            int rightVal = scanner.nextInt();
            if (rightVal == 0) {
                t.right = null;
            } else {
                t.right = new Node<>(rightVal, null, null);
                queue.addLast(t.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BineryTree<Integer> bt = new BineryTree<>();

        Node<Integer> root = bt.createTree();

        bt.setRoot(root);

        bt.preOrderPrintLeaves(root);

        System.out.print(bt.getHeight(root));
    }
}

class Node<T> {
    T val;
    Node<T> right;
    Node<T> left;

    public Node(T t, Node<T> right, Node<T> left) {
        this.val = t;
        this.right = right;
        this.left = left;
    }

    public Node(T val) {
        this.val = val;
    }
}
