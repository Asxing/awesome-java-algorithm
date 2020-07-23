package com.holddie.sword.offer;

import java.util.Arrays;

/**
 * 扑克牌顺子
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/26 8:59
 */
public class No61 {


    /**
     * 题目描述：
     * 五张牌，其中大小鬼为癞子，牌面大小为0，判断是否能组成癞子
     */
    private boolean isCountinuous(int[] nums) {
        if (nums.length < 5) {
            return false;
        }
        Arrays.sort(nums);
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) {
                cnt++;
            }
        }
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                return false;
            }
            cnt -= nums[i + 1] - nums[i] - 1;
        }
        return cnt >= 0;
    }
}
