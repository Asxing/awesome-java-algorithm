package com.holddie.leetCode;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx
                && rightIdx < nums.length
                && nums[leftIdx] == target
                && nums[rightIdx] == target) {
            return new int[] {leftIdx, rightIdx};
        }
        return new int[] {-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                // 本身暗含了小于等于这种情况
                left = mid + 1;
            }
        }
        return ans;
    }
}
