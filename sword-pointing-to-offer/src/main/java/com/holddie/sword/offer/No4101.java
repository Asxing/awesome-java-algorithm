package com.holddie.sword.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 字符流中第一个不重复的字符
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/6 8:04
 */
public class No4101 {

    /**
     * 题目描述：
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只
     * 出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，
     * 第一个只出现一次的字符是 "l"。
     */
    private int[] cnts = new int[256];

    private Queue<Character> queue = new LinkedList<>();

    private void insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    private char firstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }

    /**
     * 主要思想：
     * 使用了队列进行，进行先进先出，每次在插入元素的时候，都对
     * 队列的头元素进行统计计算，判断是否存在，若存在则进行出栈操作，
     * 同时进行依次遍历循环。
     */
    public static void main(String[] args) {
        No4101 no42 = new No4101();
        no42.insert('g');
        no42.insert('o');
        no42.insert('o');
        no42.insert('o');
        no42.insert('g');
        no42.insert('l');
        no42.insert('e');
        System.out.println(no42.firstAppearingOnce());
    }

}
