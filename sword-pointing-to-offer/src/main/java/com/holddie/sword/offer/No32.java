package com.holddie.sword.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/31 8:29
 */
public class No32 {

    /**
     * 解题思路：
     * 1、当然在遍历二叉树的时候，使用了队列这种数据结构
     * 2、借助一个数组，在循环遍历每一个层的每一个节点的时候，
     * 都进行数组添加
     */
    private ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int cunt = queue.size();
            while (cunt-- > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                ret.add(tmp.val);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(11);
        TreeNode treeNode2 = new TreeNode(12);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(14);
        TreeNode treeNode5 = new TreeNode(15);
        TreeNode treeNode6 = new TreeNode(16);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode3.setLeft(treeNode4);
        treeNode4.setLeft(treeNode5);
        treeNode4.setRight(treeNode6);

        No32 no32 = new No32();
        System.out.println(no32.printFromTopToBottom(treeNode1));
    }

}
