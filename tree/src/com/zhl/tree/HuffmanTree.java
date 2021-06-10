package com.zhl.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class HuffmanTree {
    public static void main(String[] args) {
        System.out.println(args.length);
        Arrays.stream(args).forEach(System.out::print);
        int[] nums = {13, 7, 8, 3, 29, 6, 1};
        HuffmanNode huffmanNode = HuffmanTree.create(nums);
        HuffmanNode.preOrder(huffmanNode);
    }

    public static HuffmanNode create(int[] keys) {
        ArrayList<HuffmanNode> huffmanNodes = new ArrayList<>();
        for (int i : keys) {
            huffmanNodes.add(new HuffmanNode(i));
        }

        while (huffmanNodes.size() > 1) {
            Collections.sort(huffmanNodes);

            HuffmanNode left = huffmanNodes.get(0);
            HuffmanNode right = huffmanNodes.get(1);

            HuffmanNode parent = new HuffmanNode(left.val + right.val, right, left);

            huffmanNodes.remove(1);
            huffmanNodes.remove(0);


            huffmanNodes.add(parent);

        }
        return huffmanNodes.get(0);
    }


}

class HuffmanNode implements Comparable<HuffmanNode> {
    public int val;

    private HuffmanNode right;

    private HuffmanNode left;

    public HuffmanNode(int val) {
        this.val = val;
    }

    public HuffmanNode(int val, HuffmanNode right, HuffmanNode left) {
        this.val = val;
        this.right = right;
        this.left = left;
    }

    public static void preOrder(HuffmanNode node) {
        if (node != null) {
            System.out.println(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.val - o.val;
    }

}
