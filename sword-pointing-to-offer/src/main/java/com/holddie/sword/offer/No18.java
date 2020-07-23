package com.holddie.sword.offer;

/**
 * 在o(1)时间内删除链表节点
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/23 8:20
 */
public class No18 {

    /**
     * 解题思路
     * ① 如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，
     * 然后令该节点指向下下个节点，再删除下一个节点，时间复杂度为 O(1)。
     * <p>
     * ② 否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个
     * 节点指向 null，时间复杂度为 O(N)。
     * <p>
     * 综上，如果进行 N 次操作，那么大约需要操作节点的次数为 N-1+N=2N-1，
     * 其中 N-1 表示 N-1 个不是尾节点的每个节点以 O(1) 的时间复杂度操作节点的
     * 总次数，N 表示 1 个尾节点以 O(N) 的时间复杂度操作节点的总次数。
     * (2N-1)/N ~ 2，因此该算法的平均时间复杂度为 O(1)。
     */

    private ListNode deleteNode(ListNode head, ListNode toDeleteNode) {
        if (head == null || head.next == null || toDeleteNode == null) {
            return null;
        }
        if (toDeleteNode.next != null) {
            ListNode next = toDeleteNode.next;
            toDeleteNode.data = next.data;
            toDeleteNode.next = next.next;
        } else {
            ListNode cur = head;
            while (cur.next != toDeleteNode) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }

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

        No18 no18 = new No18();
        no18.deleteNode(node1, node5);
        System.out.println(node1);
    }
}
