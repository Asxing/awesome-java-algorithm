package com.holddie.sword.offer;

/**
 * 链表中环的入口节点
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/26 13:29
 */
public class No23 {

    /**
     * 题目描述： 一个链表中存在环，求该环的入口节点。
     *
     * <p>解题思路： 此题同样是一个距离问题，实现的办法同样是使用两个步长不同的指针进行判断， 一个步长为y，另一个步长为：2y，当两者从同一个起点进行出发，当两者第一次相遇
     * 时，此慢的一方和快的一方之间的相差n个环的距离，同理此时将快的节点重置到开始 出发点，但是此时步长为1，当两者再次相遇的时候，此时的节点就是环的入口节点
     */
    private ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead, fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                fast = pHead;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    /** 当然也可以使用一个HashSet方法，循环遍历，完全循环整个链表 总会有一个节点的指定，环的入口，此时就会判断是否存在，若存在 就表明这个节点就是入口地址。 */
    public static void main(String[] args) {

        ListNode node1 = new ListNode("A");
        ListNode node2 = new ListNode("B");
        ListNode node3 = new ListNode("C");
        ListNode node4 = new ListNode("D");
        ListNode node5 = new ListNode("E");
        ListNode node6 = new ListNode("F");
        ListNode node7 = new ListNode("G");

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node4);

        No23 no23 = new No23();
        System.out.println(no23.EntryNodeOfLoop(node1));
    }
}
