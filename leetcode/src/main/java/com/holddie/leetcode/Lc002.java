package com.holddie.leetcode;

/**
 * 两个链表相加
 * @author holddie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/12/4 11:27 PM
 */
public class Lc002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode retNode = new ListNode(0);
        ListNode p = l1, q = l2, curr = retNode;
        int isGTTen = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = isGTTen + x + y;
            isGTTen = sum / 10;
            curr.next = new ListNode(sum % 10);
            if (q != null) {
                q = q.next;
            }
            if (p != null) {
                p = p.next;
            }
        }
        if (isGTTen > 0) {
            curr.next = new ListNode(isGTTen);
        }
        return retNode.next;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
