package com.holddie.sword.offer;

/**
 * 序列化二叉树
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/4 8:07
 */
public class No37 {

    /** 实现思路： 就是利用标识分隔符进行区分，然后进行递归的调用操作，反序列化也是同样的道理 */
    private String deserializeStr;

    private String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    private TreeNode deserialize(String str) {
        deserializeStr = str;
        return deserialize();
    }

    private TreeNode deserialize() {
        if (deserializeStr.length() == 0) {
            return null;
        }
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if ("#".equals(node)) {
            return null;
        }
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = deserialize();
        t.right = deserialize();
        return t;
    }

    public static void main(String[] args) {
        No37 no37 = new No37();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode2.setLeft(treeNode1);
        treeNode2.setRight(treeNode3);

        String ser = no37.serialize(treeNode2);

        System.out.println(ser);

        System.out.println(no37.deserialize(ser));
    }
}
