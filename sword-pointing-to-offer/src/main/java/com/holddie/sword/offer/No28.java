package com.holddie.sword.offer;

/**
 * 判断二叉树是否是对称二叉树
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 8:05
 */
public class No28 {

    /** 思路总结： 1、首先判断根节点 2、然后判断子节点是否为空，不为空判断是否相等 3、然后递归判断左左子节点是否和右右子节点相等 */
    boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
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
        //        treeNode3.setLeft(treeNode4);
        //        treeNode4.setLeft(treeNode5);
        //        treeNode4.setRight(treeNode6);

        No28 no28 = new No28();
        System.out.println(no28.isSymmetrical(treeNode1));
        ;
    }
}
