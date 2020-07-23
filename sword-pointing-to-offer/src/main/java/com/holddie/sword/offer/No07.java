package com.holddie.sword.offer;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/5 16:46
 */
public class No07 {
    public static void main(String[] args) {
        No07 no07 = new No07();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        System.out.println(no07.reConstructBinaryTree(pre, in));

    }

    private Map<Integer, Integer> inOrderNumsIndexs = new HashMap<>(); // 缓存中序遍历数组的每个值对应的索引

    private TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            inOrderNumsIndexs.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = inOrderNumsIndexs.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, in, inL, inL + leftTreeSize - 1);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, in, inL + leftTreeSize + 1, inR);
        return root;
    }

}

@Data
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
