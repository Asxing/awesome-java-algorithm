package com.holddie.sword.offer;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/25 9:14
 */
public class No21 {

    public int[] reOrderArray(int[] nums) {
        // 奇数个数
        int oddCount = 0;
        for (int val : nums) {
            if (val % 2 == 0) {
                oddCount++;
            }
        }
        int[] copy = nums.clone();
        int i = 0, j = oddCount;
        for (int num : copy) {
            if (num % 2 == 1) {
                nums[i++] = num;
            } else {
                nums[j++] = num;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        No21 no21 = new No21();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(Arrays.toString(no21.reOrderArray(nums)));
    }
}
