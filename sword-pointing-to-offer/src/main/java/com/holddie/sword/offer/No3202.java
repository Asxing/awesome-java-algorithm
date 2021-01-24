package com.holddie.sword.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字形顺序打印二叉树
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/31 9:20
 */
public class No3202 {

    private ArrayList<ArrayList<Integer>> print(TreeNode node) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (node == null) {
            return arrayLists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode tmp = queue.poll();
                arrayList.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            if (reverse) {
                Collections.reverse(arrayList);
            }
            reverse = !reverse;
            arrayLists.add(arrayList);
        }
        return arrayLists;
    }

    public static void main(String[] args) {
        No3202 no3202 = new No3202();

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

        System.out.println(no3202.print(treeNode1));
    }
}
