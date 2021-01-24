package com.holddie.sword.offer;

/**
 * 二叉树子节点镜像
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/28 8:34
 */
public class No27 {

    /**
     * 递归思想
     *
     * @param root 根节点
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/28 8:40
     */
    private void Mirror(TreeNode root) {

        if (root == null) {
            return;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
    }

    public static void main(String[] args) {

        No27 no27 = new No27();
        TreeNode treeNode1 = new TreeNode(11);
        TreeNode treeNode2 = new TreeNode(12);
        TreeNode treeNode3 = new TreeNode(13);
        TreeNode treeNode4 = new TreeNode(14);
        TreeNode treeNode5 = new TreeNode(15);
        TreeNode treeNode6 = new TreeNode(16);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode3.setLeft(treeNode4);
        treeNode4.setLeft(treeNode5);
        treeNode4.setRight(treeNode6);

        System.out.println(treeNode1);
        no27.Mirror(treeNode1);
        System.out.println(treeNode1);
    }
}
