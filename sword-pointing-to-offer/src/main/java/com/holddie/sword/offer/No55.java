package com.holddie.sword.offer;

/**
 * 二叉树的深度
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/21 10:05
 */
public class No55 {

    /**
     * 从根节点到叶节点依次经过的结点（含根、叶节点）形
     * 成树的一条路径，最长路径的长度为树的深度
     */
    private int treeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    public static void main(String[] args) {

        No55 no55 = new No55();
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode5.setLeft(treeNode3);
        treeNode5.setRight(treeNode7);
        treeNode3.setLeft(treeNode2);
        treeNode3.setRight(treeNode4);
        treeNode7.setLeft(treeNode6);
        treeNode7.setRight(treeNode8);

        System.out.println(no55.treeDepth(treeNode5));

    }


}
