package com.holddie.sword.offer;

/**
 * 旋转数组的最小数
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/9 8:58
 */
public class No11 {

    /**
     * 题目描述：
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1。
     * NOTE：给出的所有元素都大于 0，若数组大小为 0，请返回 0。
     */
    public static void main(String[] args) {
        No11 no11 = new No11();
        int[] nums = {3, 4, 5, 6, 2};
        System.out.println(no11.minnumsberInRotateArray(nums));
    }

    private int minnumsberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
    /**
     * 问题本质：
     * 1、类似于折半查找
     * 2、片段的有序
     * 3、数组
     */
}
