package com.holddie.sword.offer;

/**
 * 两个链表的第一个公共结点
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/20 9:22
 */
public class No52 {

    /**
     * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
     * <p>
     * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；同样地，
     * 当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
     * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        No52 no52 = new No52();
        ListNode listNode1 = new ListNode("1");
        ListNode listNode2 = new ListNode("2");
        ListNode listNode3 = new ListNode("3");
        ListNode listNode4 = new ListNode("4");
        ListNode listNode5 = new ListNode("5");
        ListNode listNode6 = new ListNode("6");
        ListNode listNode7 = new ListNode("7");
        ListNode listNode8 = new ListNode("8");
        ListNode listNode9 = new ListNode("9");
        ListNode listNode10 = new ListNode("10");

        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode8);

        listNode5.setNext(listNode6);
        listNode6.setNext(listNode7);
        listNode7.setNext(listNode8);

        listNode8.setNext(listNode9);
        listNode9.setNext(listNode10);

        System.out.println(no52.findFirstCommonNode(listNode1, listNode5));

    }
}
