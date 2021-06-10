package com.zhl.tree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 二叉搜索树
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private BSTNode<T> root;

    public BinarySearchTree() {

    }

    public BinarySearchTree(BSTNode<T> root) {
        this.root = root;
    }

    public void setRoot(BSTNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /*
    中序遍历
     */
    public void inOrderTraversal(BSTNode<T> root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + "\t");
            inOrderTraversal(root.right);
        }
    }

    /*
    先序遍历
     */
    public void preOrderTraversal(BSTNode<T> root) {
        if (root != null) {
            System.out.print(root.val + "\t");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /*
    后续遍历
     */
    public void postOrderTraversal(BSTNode<T> root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val + "\t");
        }
    }

    //非递归中序遍历
    public void nonInOrderTraversal(BSTNode<T> root) {
        Stack<BSTNode<T>> stack = new Stack<>();
        BSTNode<T> t = root;

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
    public void nonPreOrderTraversal(BSTNode<T> root) {
        Stack<BSTNode<T>> stack = new Stack<>();
        BSTNode<T> t = root;
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
    public void levelOrderTraversal(BSTNode<T> root) {
        LinkedList<BSTNode<T>> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            BSTNode<T> t = list.removeFirst();
            System.out.print(t.val + "\t");
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

    public void preOrderPrintLeaves(BSTNode<T> root) {
        if (root != null) {
            if (root.right == null && root.left == null) {
                System.out.print(root.val + "\t");
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
    public int getHeight(BSTNode<T> root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 通过队列层序创建二叉树
     *
     * @return
     */
    public BSTNode<Integer> createTree() {
        BSTNode<Integer> root = null;
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i == 0) {
            return root;
        }
        LinkedList<BSTNode<Integer>> queue = new LinkedList<>();
        root = new BSTNode<>(i, null, null);
        queue.addLast(root);
        while (!queue.isEmpty()) {
            BSTNode<Integer> t = queue.removeFirst();
            int leftVal = scanner.nextInt();
            if (leftVal == 0) {
                t.left = null;
            } else {
                t.left = new BSTNode<>(leftVal, null, null);
                queue.addLast(t.left);
            }
            int rightVal = scanner.nextInt();
            if (rightVal == 0) {
                t.right = null;
            } else {
                t.right = new BSTNode<>(rightVal, null, null);
                queue.addLast(t.right);
            }
        }
        return root;
    }

    /**
     * 递归查找
     *
     * @param root
     * @param val
     * @return
     */
    public BSTNode<T> find(BSTNode<T> root, T val) {
        if (root == null) return null;
        if (root.val.compareTo(val) > 0) {
            find(root.left, val);
        } else if (root.val.compareTo(val) < 0) {
            find(root.right, val);
        }
        return root;
    }

    /**
     * 非递归查找
     *
     * @param root
     * @param val
     * @return
     */
    public BSTNode<T> nonFind(BSTNode<T> root, T val) {
        while (root != null) {
            if (root.val.compareTo(val) > 0) {
                root = root.left;
            } else if (root.val.compareTo(val) < 0) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    /**
     * 递归查找最小值
     *
     * @param root
     * @return
     */
    public BSTNode<T> min(BSTNode<T> root) {
        if (root == null || root.left == null) return root;
        return min(root.left);
    }

    /**
     * 非递归查找最大值
     *
     * @param root
     * @return
     */
    public BSTNode<T> max(BSTNode<T> root) {
        if (root == null) return null;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    /**
     * 插入结点
     *
     * @param root
     * @param val
     * @return
     */
    public BSTNode<T> insert(BSTNode<T> root, T val) {
        if (root == null) {//若树为空，生成搜索树结点并返回
            return new BSTNode<T>(val, null, null);
        }
        if (val.compareTo(root.val) > 0) root.right = insert(root.right, val);
        else if (val.compareTo(root.val) < 0) root.left = insert(root.left, val);
        return root;
    }

    /**
     * 搜索树删除结点
     * 1.先找到要删除的结点
     * 1) 如果要删除的结点有两个结点，找到右子树的最小结点或者左子树的最大结点
     * 将最小或最大结点的值付给要删除的结点，然后删除最小或最大的结点
     * 2) 如果要删除的结点只有一个结点或没有结点，将左或右结点直接赋给被删除结点
     *
     * @param bst
     * @param val
     * @return
     */
    public BSTNode<T> delete(BSTNode<T> bst, T val) {
        if (bst == null) {
            return null;
        }
        if (bst.val.compareTo(val) > 0) {
            bst.left = delete(bst.left, val);
        } else if (bst.val.compareTo(val) < 0) {
            bst.right = delete(bst.right, val);
        } else {
            if (bst.left != null && bst.right != null) {
                System.out.println(bst);
                BSTNode<T> min = min(bst.right);
                System.out.println("右子树最小结点"+min);
                bst.val = min.val;
                bst.right = delete(bst.right, min.val);
            } else {
                if (bst.left != null) {
                    bst = bst.left;
                } else {
                    System.out.println("=======April"+bst);
                    bst = bst.right;
                }
            }
        }
        return bst;
    }

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        String[] s = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < s.length; i++) {
            bst.root = bst.insert(bst.root, s[i]);
        }
        System.out.println("树的高度" + bst.getHeight(bst.root));
        bst.preOrderTraversal(bst.root);
        System.out.println("删除一个结点");
        bst.delete(bst.root, "Apr");
        bst.preOrderTraversal(bst.root);
        bst.delete(bst.root, "Mar");
        bst.preOrderTraversal(bst.root);
    }

    /**
     * 平衡插入算法
     * @param root
     * @param val
     * @return
     */
    public BSTNode<T> insertAVL(BSTNode<T> root,T val){
        if(root==null){
            return new BSTNode<T>(val,1,null,null);
        }

        BSTNode<T> t=null;
        if(root.val.compareTo(val)>1){
            root.left=insertAVL(root.left,val);
            /*
            插入后判断是否平衡，如果左子树高度-右子树高度==2 左倾
             */
            if(getHeight(root.left)-getHeight(root.right)==2){
                //如果破坏平衡的结点在左子树的右节点上
                if(root.left.val.compareTo(val)<0){
                    rotateLeftRight(root);
                }else{
                    //如果破坏平衡的结点在左子树的左节点上
                    rotateRight(root);
                }
            }

        }else if(root.val.compareTo(val)<1){
            root.right=insertAVL(root.right,val);
            /*
            插入后判断是否平衡，如果左子树高度-右子树高度==-2 右倾
             */
            if(getHeight(root.left)-getHeight(root.right)==-2){
                //如果破坏平衡的结点在右子树的左子树上
                if(root.right.val.compareTo(val)>0){
                    rotateRightLeft(root);
                }else{
                    // 如果破坏平衡的子结点在右子树的右节点上
                    rotateLeft(root);
                }
            }
        }
        root.height=getHeight(root);
        return root;
    }

    /**
     * 右旋算法
     *
     *结点的左节点代替结点的位置
     * 结点变为子结点的右节点
     * 左节点的右节点变为结点的左节点
     * @param node
     * @return
     */
    public BSTNode<T> rotateRight(BSTNode<T> node){
        BSTNode<T> left=node.left;
        node.left=left.right;
        left.right=node;
        //更新原结点的高度
        left.right.height=getHeight(left.right);
        //更新新节点的高度
        left.height=Math.max(getHeight(left.left),left.right.height)+1;
        return left;
    }

    /**
     * 结点的右节点代替结点的位置
     * 结点变为右节点的左节点
     * 结点的右节点变为右节点的左节点
     * @param node
     * @return
     */
    public BSTNode<T> rotateLeft(BSTNode<T> node){
        BSTNode<T> right=node.right;
        node.right=right.left;
        right.left=node;
        //更新原结点的高度
        right.left.height=getHeight(right.left);
        //更新新节点的高度
        right.height=Math.max(getHeight(right.right),right.left.height);
        return right;
    }

    /**
     * 影响平衡的结点在结点的右子树的左节点上
     * 先右旋
     * 再左旋
     * @param node
     * @return
     */
    public BSTNode<T> rotateRightLeft(BSTNode<T> node){
        node.left=rotateRight(node.left);
        return rotateLeft(node.right);
    }
    /**
     * 影响平衡的结点在结点的左子树子树的右节点节点上
     * 先左旋
     * 再右旋
     * @param node
     * @return
     */
    public BSTNode<T> rotateLeftRight(BSTNode<T> node){
        node.right=rotateLeft(node.right);
        return rotateLeft(node.right);
    }
}

class BSTNode<T> {
    T val;
    int height;
    BSTNode<T> right;
    BSTNode<T> left;

    public BSTNode(T t, BSTNode<T> right, BSTNode<T> left) {
        this.val = t;
        this.right = right;
        this.left = left;
    }

    public BSTNode(T val, int height, BSTNode<T> right, BSTNode<T> left) {
        this.val = val;
        this.height = height;
        this.right = right;
        this.left = left;
    }

    public BSTNode(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "val=" + val +
                '}';
    }
}