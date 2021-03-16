package com.holddie.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CanPartition {

    /**
     * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/
     */
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; --j) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        System.out.println(Arrays.toString(dp));
        List<Integer> tmp = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int index = dp.length - 1;
        Iterator<Integer> it = tmp.iterator();
        while (index > 0) {
            while (it.hasNext()) {
                int num = it.next();
                if (dp[index - num]) {
                    System.out.println(num);
                    it.remove();
                    tmp.remove(num);
                    index = index - num;
                }
            }
        }
        System.out.println(tmp);
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        canPartition(nums);
    }
}
