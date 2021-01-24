package com.holddie.sword.offer;

/**
 * 链表中倒数第k个结点
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/26 12:44
 */
public class No22 {

    /**
     * 解题思路： 设链表的长度为 N。设两个指针 P1 和 P2，先让 P1 移动 K 个节点， 则还有 N - K 个节点可以移动。此时让 P1 和 P2 同时移动，可以知 道当 P1
     * 移动到链表结尾时，P2 移动到 N - K 个节点处，该位置就 是倒数第 K 个节点。
     */
    private ListNode FindKthTotail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && k-- > 0) {
            fast = fast.next;
        }
        if (k > 0) {
            return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 核心思想：利用两个指针一个做标记，两个指针之间相差k个距离，这样 当第一个走完的时候，慢的那个指针也就刚好到达倒数的第k的位置。
     *
     * <p>缺点：会全部遍历一遍
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode("A");
        ListNode node2 = new ListNode("B");
        ListNode node3 = new ListNode("C");
        ListNode node4 = new ListNode("D");
        ListNode node5 = new ListNode("E");

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        No22 no22 = new No22();
        System.out.println(no22.FindKthTotail(node1, 3));
    }
}
