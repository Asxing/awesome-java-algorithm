package com.holddie.leetCode;

public class PathSum {

    int pathNumber;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return pathNumber;
    }

    private void Sum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            pathNumber++;
        }
        Sum(root.left, sum);
        Sum(root.right, sum);
    }
}
