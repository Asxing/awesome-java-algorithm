package com.holddie.sword.offer;

/**
 * 连续子数组的最大和
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/7 9:01
 */
public class No42 {

    private int findGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = Integer.MIN_VALUE;
        int sum = 0;
        for (int num :
                nums) {
            sum = sum < 0 ? num : sum + num;
            ret = Math.max(ret, sum);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] dd = {6, -3, -2, 7, -15, 1, 2, 2};
        No42 no42 = new No42();
        System.out.println(no42.findGreatestSumOfSubArray(dd));
    }

}
