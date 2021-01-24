package com.holddie.sword.offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数
 * 组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/5 7:51
 */
public class No39 {

    /**
     * 解题思路： 多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
     *
     * <p>使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素不相 等时，令 cnt--。如果前面查找了 i 个元素，且 cnt == 0 ，说明前 i 个 元素没有
     * majority，或者有 majority，但是出现的次数少于 i / 2 ，因 为如果多于 i / 2 的话 cnt 就一定不会为 0 。此时剩下的 n - i 个元素
     * 中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
     */
    private int morethanhalfnumSolution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for (int val : nums) {
            if (val == majority) {
                cnt++;
            }
        }
        return cnt > nums.length / 2 ? majority : 0;
    }

    public static void main(String[] args) {
        No39 no39 = new No39();
        //        int[] nums = {2, 1, 2, 3, 2, 5, 2, 4, 2};
        int[] nums = {2, 1, 2};
        System.out.println(no39.morethanhalfnumSolution(nums));
    }
}
