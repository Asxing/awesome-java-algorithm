package com.holddie.sword.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 大小为 K 的最小堆
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/5 8:48
 */
public class No4001 {

    /**
     * 复杂度：O(NlogK) + O(K)
     * 特别适合处理海量数据
     * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
     * <p>
     * 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
     */
    public ArrayList<Integer> getLeastNumbersSolution(int[] nums, int k) {
        if (k > nums.length || k < 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num :
                nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        ArrayList<Integer> ret = new ArrayList<>(maxHeap);
        return ret;
    }

    public static void main(String[] args) {
        No4001 no4001 = new No4001();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(no4001.getLeastNumbersSolution(nums, 4));
    }


}
