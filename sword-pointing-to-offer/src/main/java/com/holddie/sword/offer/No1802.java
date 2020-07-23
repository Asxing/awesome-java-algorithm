package com.holddie.sword.offer;

/**
 * 删除链表中重复的结点
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/23 8:32
 */
public class No1802 {

    /**
     * 题目描述：
     * 假设一个链表中的值有序，进行相同的结点去重
     *
     * 思路：
     * 那就是前后两个结点值进行比较，过滤值相同的结点
     */

    private ListNode deleteDuplication(ListNode pHead){
        if (pHead == null || pHead.next ==null){
            return pHead;
        }
        ListNode next = pHead.next;
        if(pHead.data.equals(next.data)){
            while (next != null && pHead.data.equals(next.data)){
                next = next.next;
            }
            return deleteDuplication(next);
        }else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.data.equals(next.data)) {
            while (next != null && pHead.data.equals(next.data))
                next = next.next;
            return deleteDuplication1(next);
        } else {
            pHead.next = deleteDuplication1(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode("A");
        ListNode node2 = new ListNode("B");
        ListNode node3 = new ListNode("C");
        ListNode node4 = new ListNode("C");
        ListNode node5 = new ListNode("C");

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);


        No1802 no19 = new No1802();
        no19.deleteDuplication1(node1);
        System.out.println(node1);
    }



}
