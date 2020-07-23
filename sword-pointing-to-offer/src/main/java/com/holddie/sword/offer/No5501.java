package com.holddie.sword.offer;

/**
 * 判断是否平衡二叉树
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/21 10:09
 */
public class No5501 {

    /**
     * 平衡二叉树左右子树高度不超过1
     */
    private boolean isBalance = true;

    private boolean isbalancedSolution(TreeNode root) {
        height(root);
        return isBalance;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        No5501 no5501 = new No5501();

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

        System.out.println(no5501.isbalancedSolution(treeNode5));
    }
}
