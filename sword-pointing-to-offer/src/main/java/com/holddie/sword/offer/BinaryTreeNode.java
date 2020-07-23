package com.holddie.sword.offer;

/**
 * 二叉树数据结构
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/2 8:54
 */
public class BinaryTreeNode {
    private Object data;
    private BinaryTreeNode LchildNode;
    private BinaryTreeNode RchildNode;

    public BinaryTreeNode(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BinaryTreeNode getLchildNode() {
        return LchildNode;
    }

    public void setLchildNode(BinaryTreeNode lchildNode) {
        LchildNode = lchildNode;
    }

    public BinaryTreeNode getRchildNode() {
        return RchildNode;
    }

    public void setRchildNode(BinaryTreeNode rchildNode) {
        RchildNode = rchildNode;
    }
}
