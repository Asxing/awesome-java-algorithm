package com.holddie.e10_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的遍历
 */
public class TraversalTree {
    /**
     * 前序遍历
     * 根左右
     */
    public void preOrderTraversal(Node tree) {
        List<Integer> result = new ArrayList<>();
        if (null == tree) {
            return;
        }
        result.add(tree.data);
        System.out.print(tree.data + " ");
        preOrderTraversal(tree.left);
        preOrderTraversal(tree.right);
    }

    /**
     * 中序遍历
     * 左根右
     */
    public void inOrderTraversal(Node tree) {
        List<Integer> result = new ArrayList<>();
        if (null == tree) {
            return;
        }
        inOrderTraversal(tree.left);
        result.add(tree.data);
        System.out.print(tree.data + " ");
        inOrderTraversal(tree.right);
    }

    /**
     * 后序遍历
     * 左右根
     */
    public void postOrderTraversal(Node tree) {
        List<Integer> result = new ArrayList<>();
        if (null == tree) {
            return;
        }
        postOrderTraversal(tree.left);
        postOrderTraversal(tree.right);
        result.add(tree.data);
        System.out.print(tree.data + " ");
    }

    /**
     * 按层遍历
     *
     * @param tree
     */
    public void levelTraversal(Node tree) {
        List<Integer> result = new ArrayList<>();
        if (null == tree) {
            return;
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        Node node;
        linkedList.offer(tree);
        while (!linkedList.isEmpty()) {
            node = linkedList.poll();
            result.add(tree.data);
            System.out.print(node.data + " ");
            if (null != node.left) {
                linkedList.offer(node.left);
            }
            if (null != node.right) {
                linkedList.offer(node.right);
            }
        }
    }

    public List<List<Integer>> levelOrderLeft2Right(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node;
                node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                tmp.add(node.data);
            }
            result.add(tmp);
        }
        return result;
    }

    /**
     * 从右往左打印
     *
     * @author HoldDie
     */
    public List<List<Integer>> levelOrderRight2Left(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node;
                node = queue.pollLast();
                if (node.left != null) {
                    queue.offerFirst(node.left);
                }
                if (node.right != null) {
                    queue.offerFirst(node.right);
                }
                tmp.add(node.data);
            }
            result.add(tmp);
        }
        return result;
    }

    /**
     * z 字形打印
     *
     * @author HoldDie
     */
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node;
                // 因为是走z字形，所有相邻两层的节点处理是相反的
                if (depth % 2 == 0) {
                    //获取链表最后一个节点
                    node = queue.pollLast();
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                } else {
                    //获取链表第一个节点
                    node = queue.poll();
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                }
                tmp.add(node.data);
            }
            depth++;
            result.add(tmp);
        }
        return result;
    }


    public static void main(String[] args) {

    }
}