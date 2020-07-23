package com.holddie.sword.offer;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/4 10:02
 */
public class No06 {

    /**
     * 描述：输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
     */
    //https://github.com/CyC2018/Interview-Notebook/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md#2-%E5%AE%9E%E7%8E%B0-singleton
    public static void main(String[] args) {
        No06 no06 = new No06();
        ListNode node1 = new ListNode("A");
        ListNode node2 = new ListNode("B");
        ListNode node3 = new ListNode("C");
        ListNode node4 = new ListNode("D");
        ListNode node5 = new ListNode("E");

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        no06.printListFromTailToHeadStack(node1).forEach(System.out::println);
        no06.printListFromTailToHeadRecursive(node1).forEach(System.out::println);
        no06.printListFromTailToHeadReverse(node1).forEach(System.out::println);
        no06.printListFromTailToHeadReverse(node1).forEach(System.out::println);
        no06.printListFromTailToHeadLinkedList(node1).forEach(System.out::println);

    }

    /**
     * 使用堆进行先进后出操作
     * @param listNode 链表
     * @return 返回数组内容
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/5 16:16
     */
    private ArrayList<String> printListFromTailToHeadStack(ListNode listNode) {
        Stack<String> stack = new Stack<String>();
        while (listNode != null) {
            stack.add(listNode.data);
            listNode = listNode.next;
        }
        ArrayList<String> ret = new ArrayList<String>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }

    /**
     * 使用递归的方式进行倒序插入
     * @param listNode 链表
     * @return 数组内容
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/5 16:22
     */
    private ArrayList<String> printListFromTailToHeadRecursive(ListNode listNode) {
        ArrayList<String> ret = new ArrayList<String>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHeadRecursive(listNode.next));
            ret.add(listNode.data);
        }
        return ret;
    }

    /**
     * 使用Collections的工具方法进行一个list倒序，只针对其中的内容
     * @param listNode 链表
     * @return 数组内容
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/5 16:32
     */
    private ArrayList<String> printListFromTailToHeadReverse(ListNode listNode) {
        ArrayList<String> ret = new ArrayList<String>();
        while (listNode != null) {
            ret.add(listNode.data);
            listNode = listNode.next;
        }
        Collections.reverse(ret);
        return ret;
    }

    /**
     * 使用链表头进行链表反转很常见
     * @param listNode 链表
     * @return 数据内容
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/5 16:39
     */
    private ArrayList<String> printListFromTailToHeadLinkedList(ListNode listNode) {
        ListNode head = new ListNode("head");
        while (listNode != null) {
            ListNode remainList = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = remainList;
        }

        // 构建ArrayList
        ArrayList<String> ret = new ArrayList<String>();

        head = head.next;
        while (head != null) {
            ret.add(head.data);
            head = head.next;
        }
        return ret;
    }


}

/**
 * 链表数据结构
 * @author HoldDie
 * @version v1.0.0
 * @email HoldDie@163.com
 * @date 2018/5/5 16:33
 */
@Data
class ListNode {
    String data;
    ListNode next;

    ListNode(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data='" + data + '\'' +
                '}';
    }
}
