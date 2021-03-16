package com.holddie.leetCode;

public class SortColors {
    public static void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        int i = 0;
        while (i <= high) {
            if (nums[i] == 0) {
                swap(nums, i++, low++);
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, high--);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
