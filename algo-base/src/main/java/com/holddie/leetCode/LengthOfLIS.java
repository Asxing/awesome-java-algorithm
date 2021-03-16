package com.holddie.leetCode;

import org.assertj.core.api.Assertions;

public class LengthOfLIS {

	public static int lengthOfLIS(int[] nums) {
		int maxL = 0;
		int[] dp = new int[nums.length];
		// 核心逻辑就是找如果这个数比已知的小就往里面赋值，把之前的给顶替掉
		for (int num : nums) {
			int lo = 0, hi = maxL;
			while (lo < hi) {
				int mid = lo + (hi - lo) / 2;
				if (dp[mid] < num) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			}
			dp[lo] = num;
			if (lo == maxL) {
				maxL++;
			}
		}
		return maxL;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{0, 1, 0, 3, 2, 3};
		Assertions.assertThat(lengthOfLIS(nums)).isEqualTo(4);
	}
}
