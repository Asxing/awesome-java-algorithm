package com.holddie.leetCode;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] num = {-2, 0, 1, 1, 2};
        System.out.println(threeSumClosest(num, 0));
    }

    public static int threeSumClosest(int[] num, int target) {
        // 数组中3数之和与target的差值
        int dv = Integer.MAX_VALUE;
        // 返回值
        int res = Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                i++;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[left] + num[right];
                if (sum + num[i] == target) {
                    return target;
                } else if (sum + num[i] < target) {
                    if (dv > Math.abs(sum + num[i] - target)) {
                        dv = Math.abs(sum + num[i] - target);
                        res = sum + num[i];
                    }
                    left++;
                } else {
                    if (dv > Math.abs(sum + num[i] - target)) {
                        dv = Math.abs(sum + num[i] - target);
                        res = sum + num[i];
                    }
                    right--;
                }
            }
        }
        return res;
    }
}
