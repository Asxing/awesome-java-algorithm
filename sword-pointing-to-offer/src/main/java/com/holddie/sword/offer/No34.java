package com.holddie.sword.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二叉树中和为某一值的路径
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/1 9:01
 */
public class No34 {

    /**
     * 题目描述：
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();


    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<Integer>());
        return ret;
    }

    private void backtracking(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<Integer>(path));
        } else {
            backtracking(root.left, target, path);
            backtracking(root.right, target, path);
        }
        path.remove(path.size() - 1);
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
        No34 no34 = new No34();
        System.out.println(Arrays.toString(no34.findPath(treeNode1, 53).toArray()));
    }
}
