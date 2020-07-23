package com.holddie.sword.offer;

/**
 * 反转链表
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 9:43
 */
public class No24 {

    /**
     * 递归方式反转链表
     * @param head 链表头
     * @return ListNode
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/27 9:53
     */
    private ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newNode = ReverseList(next);
        next.next = head;
        return newNode;
    }

    /**
     * 递归方式反转链表
     * @param head 链表头
     * @return ListNode
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/27 10:04
     */
    private ListNode ReverseListVersion2(ListNode head) {
        ListNode newListNodes = new ListNode("-1");

        while (head != null) {
            ListNode next = head.next;
            head.next = newListNodes.next;
            newListNodes.next = head;
            head = next;
        }
        return newListNodes;
    }

}
