package com.holddie.leetCode;

public class CanJump {

    public static boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
