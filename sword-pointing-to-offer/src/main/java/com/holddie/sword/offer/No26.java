package com.holddie.sword.offer;

/**
 * 判断是否是子结构
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/28 8:20
 */
public class No26 {


    /**
     * 题目描述：
     * 输入两棵二叉树A，B，判断B是不是A的子结构。
     * （ps：我们约定空树不是任意一个树的子结构）
     */
    private boolean hasSubtree(TreeNode root1, TreeNode root2) {
        return root1 != null && root2 != null && (isSubtree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2));
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        return root2 == null || root1 != null && root1.val == root2.val && isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }

    public static void main(String[] args) {
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

        TreeNode treeNode7 = new TreeNode(14);
        TreeNode treeNode8 = new TreeNode(15);
        TreeNode treeNode9 = new TreeNode(16);

        treeNode7.setLeft(treeNode8);
        treeNode7.setRight(treeNode9);

        No26 no26 = new No26();
        System.out.println(no26.hasSubtree(treeNode1, treeNode7));
    }

}
