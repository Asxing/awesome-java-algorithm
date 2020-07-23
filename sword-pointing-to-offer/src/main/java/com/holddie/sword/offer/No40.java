package com.holddie.sword.offer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如
 * 输入4,5,1,6,2,7,3,8这8个数字，则最小
 * 的4个数字是1,2,3,4,。
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/5 8:10
 */
public class No40 {

    private ArrayList<Integer> getLeastNumbersSolution(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0) {
            return ret;
        }
        int kthSmallest = findKthSmallest(nums, k - 1);
        for (int i = 0; i < k; i++) {
            ret.add(nums[i]);
        }
        return ret;
    }

    private int findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partion(nums, l, h);
            if (j == k) {
                break;
            }
            if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }

    private int partion(int[] nums, int l, int h) {
        // 切分元素
        int parti = nums[l];
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < parti) ;
            while (j != l && nums[--j] > parti) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static void main(String[] args) {
        No40 no40 = new No40();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(no40.getLeastNumbersSolution(nums, 4));
    }
}
