package com.holddie.leetCode;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        int[] answer = new int[len];
        L[0] = R[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        for (int i = len - 2; i >= 0; i++) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        for (int i = 0; i < len; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
}
