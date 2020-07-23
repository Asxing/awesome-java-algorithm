package com.holddie.sword.offer;

import lombok.Data;

/**
 * 合并两个排序的链表
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 10:09
 */
public class No25 {

    /**
     * 递归方法合并链表
     * @param list1 链表1
     * @param list2 链表2
     * @return ListNode
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/27 10:19
     */
    private ListNode MergeRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.data < list2.data) {
            list1.next = MergeRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = MergeRecursive(list1, list2.next);
            return list2;
        }
    }

    /**
     * 迭代合并两个有序链表
     * @param list1 链表1
     * @param list2 链表2
     * @return ListNode
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/27 10:32
     */
    private ListNode MergeIterative(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode('B');
        ListNode node3 = new ListNode('C');
        ListNode node4 = new ListNode('D');
        ListNode node5 = new ListNode('E');
        ListNode node6 = new ListNode('F');
        ListNode node7 = new ListNode('G');

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        node5.setNext(node6);
        node6.setNext(node7);

        No25 no25 = new No25();
//        System.out.println(no25.MergeRecursive(node1, node5));
        System.out.println(no25.MergeIterative(node1, node5));
    }


    @Data
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int date) {
            this.data = date;
        }
    }
}
