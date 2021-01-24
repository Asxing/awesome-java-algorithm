package com.holddie.sword.offer;

/**
 * 二叉搜索树与双向链表
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/3 15:55
 */
public class No36 {

    /** 题目描述： 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。 要求不能创建爱你任何新的结点，只能调整树中节点指针的指向。 */
    private TreeNode pre = null;

    private TreeNode head = null;

    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode2.setLeft(treeNode1);
        treeNode2.setRight(treeNode3);

        No36 no36 = new No36();
        System.out.println(no36.convert(treeNode1));
    }
}
