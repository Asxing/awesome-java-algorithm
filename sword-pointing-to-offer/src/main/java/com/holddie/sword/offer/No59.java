package com.holddie.sword.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/23 15:12
 */
public class No59 {


    /**
     * 题目描述：
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，
     * 那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
     */
    private ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> (o2 - o1));
        if (size > num.length || size < 1) {
            return ret;
        }
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        for (int i = 1, j = i + size - 1; j < num.length; i++, j++) {
            heap.remove(num[i - 1]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        No59 no59 = new No59();
        System.out.println(no59.maxInWindows(num, 3));
    }

}
