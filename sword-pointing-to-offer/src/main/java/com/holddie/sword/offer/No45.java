package com.holddie.sword.offer;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/8 9:17
 */
public class No45 {

    /**
     * 题目描述： 输入一个正整数数组，把数组里所有数字拼接起来排成一个数， 打印能拼接出的所有数字中最小的一个。例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为
     * 321323。
     */
    private String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder ret = new StringBuilder();
        for (String str : nums) {
            ret.append(str);
        }
        return ret.toString();
    }

    /**
     * 主要的核心思想： 1、进行int转string 2、记性数组的sort一下
     *
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/6/8 9:23
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        No45 no45 = new No45();
        System.out.println(no45.printMinNumber(numbers));
    }
}
