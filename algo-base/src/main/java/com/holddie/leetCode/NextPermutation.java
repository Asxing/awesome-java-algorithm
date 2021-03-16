package com.holddie.leetCode;

import java.util.Arrays;

import org.assertj.core.api.Assertions;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                l = i;
            }
        }
        for (int i = l + 1; i < nums.length; i++) {
            if (nums[i] > nums[l]) {
                r = i;
            }
        }
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        Arrays.sort(nums, l + 1, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        int[] target = new int[] {1, 3, 2};
        nextPermutation(nums);
        Assertions.assertThat(nums).isEqualTo(target);

        int[] nums1 = new int[] {3, 2, 1};
        int[] target1 = new int[] {1, 2, 3};
        nextPermutation(nums1);
        Assertions.assertThat(nums1).isEqualTo(target1);
    }
}
