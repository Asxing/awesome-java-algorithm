package com.holddie.sword.offer;

import lombok.Data;

/**
 * 链表的复制
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/3 14:57
 */
public class No35 {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        // 插入新节点
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.lable);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random;
            }
            cur = clone.next;
        }

        // 拆分
        cur = pHead;
        RandomListNode cloneHead = pHead.next;

        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        node1.setRandom(node3);
        node2.setRandom(node4);
        node3.setRandom(node1);
        node4.setRandom(node2);

        No35 no35 = new No35();
        System.out.println(no35.Clone(node1));
    }
}

@Data
class RandomListNode {

    int lable;

    RandomListNode next = null;

    RandomListNode random = null;

    RandomListNode(int lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "RandomListNode{" + "lable=" + lable + ", next=" + next + '}';
    }
}
