package com.holddie.leetCode;

import org.assertj.core.api.Assertions;

public class Search {

    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        Assertions.assertThat(search(nums, 4)).isEqualTo(0);
        Assertions.assertThat(search(nums, 3)).isEqualTo(-1);
    }
}
