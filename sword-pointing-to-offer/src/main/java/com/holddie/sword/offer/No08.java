package com.holddie.sword.offer;

import lombok.Data;

/**
 * 二叉树的下一个节点
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/7 7:41
 */
public class No08 {
    /**
     * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     *
     * <p>思路： 1、如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点 2、否则向上找第一个左链接，指向的树包含该节点的祖先节点
     */
    public static void main(String[] args) {
        No08 no08 = new No08();
        TreeLinkNode treeNode1 = new TreeLinkNode(3);
        TreeLinkNode treeNode2 = new TreeLinkNode(9);
        TreeLinkNode treeNode3 = new TreeLinkNode(20);
        TreeLinkNode treeNode4 = new TreeLinkNode(15);
        TreeLinkNode treeNode5 = new TreeLinkNode(7);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode3.setLeft(treeNode4);
        treeNode3.setRight(treeNode5);

        //        System.out.println(no08.getNext(treeNode1));
        System.out.println(no08.getNext(treeNode3));
    }

    private TreeLinkNode getNext(TreeLinkNode treeLinkNode) {
        if (treeLinkNode.right != null) {
            TreeLinkNode node = treeLinkNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (treeLinkNode.parent != null) {
                TreeLinkNode parentNode = treeLinkNode.parent;
                if (parentNode.left == treeLinkNode) {
                    return parentNode;
                }
                treeLinkNode = treeLinkNode.parent;
            }
        }
        return null;
    }
}

@Data
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode parent = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
