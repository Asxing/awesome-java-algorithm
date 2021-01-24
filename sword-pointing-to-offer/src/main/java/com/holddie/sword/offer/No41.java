package com.holddie.sword.offer;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/6 7:47
 */
public class No41 {

    /** 思路： 1、如果是偶数个数，则中位数就是中间两个数的平均值 2、如果是奇数个数，则中位数就是排序后的中间数 3、因为涉及到排序，因此在左边使用大顶堆，右边使用小顶堆 */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);

    private PriorityQueue<Integer> right = new PriorityQueue<>();

    private int n = 0;

    public void insert(Integer val) {
        if (n % 2 == 0) {
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        n++;
    }

    public Double getMedian() {
        if (n % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return Double.valueOf(right.peek());
        }
    }

    public static void main(String[] args) {
        No41 no41 = new No41();
        no41.insert(1);
        no41.insert(2);
        no41.insert(3);
        no41.insert(4);
        no41.insert(5);
        no41.insert(6);
        no41.insert(7);
        no41.insert(8);

        System.out.println(no41.getMedian());
    }
}
