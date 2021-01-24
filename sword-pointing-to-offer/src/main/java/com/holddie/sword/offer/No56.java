package com.holddie.sword.offer;

import java.util.Arrays;

/**
 * 数组中只出现一次的数字
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/22 8:58
 */
public class No56 {

    public void findNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 4};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        No56 no56 = new No56();
        no56.findNumsAppearOnce(nums, num1, num2);
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }
}
