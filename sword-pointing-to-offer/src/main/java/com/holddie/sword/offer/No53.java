package com.holddie.sword.offer;

/**
 * 数字在排序数组中出现的次数
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/20 9:38
 */
public class No53 {

    private int getNumberOfK(int[] nums, int k) {
        int first = binarySearch(nums, k);
        int last = binarySearch(nums, k + 1);
        return (first == nums.length || nums[first] != k ? 0 : last - first);
    }

    private int binarySearch(int[] nums, int k) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= k) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
//        No53 no53 = new No53();
//        int[] nums = {1, 2, 3, 3, 3, 3, 4, 6};
//        System.out.println(no53.getNumberOfK(nums, 3));
        System.out.println(123);
    }

}
