package com.holddie.sword.offer;

/**
 * 二叉搜索树的第K个结点
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/21 9:44
 */
public class No54 {

    private TreeNode ret;
    private int cnt = 0;

    private TreeNode kthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt > k) {
            return;
        }
        inOrder(root.left, k);
        cnt++;
        if (cnt == k) {
            ret = root;
        }
        inOrder(root.right, k);
    }

    public static void main(String[] args) {
        No54 no54 = new No54();

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

        System.out.println(no54.kthNode(treeNode5, 3));
    }
}
