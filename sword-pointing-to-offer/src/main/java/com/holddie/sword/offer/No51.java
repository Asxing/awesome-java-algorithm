package com.holddie.sword.offer;

/**
 * 数组中的逆序对
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/11 10:01
 */
public class No51 {

    private long cnt = 0;
    private int[] tmp; // 在这里创建辅助数组，而不是在 merge() 递归函数中创建

    private int inversepairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1) {
            return;
        }
        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m) {
                tmp[k] = nums[j++];
            } else if (j > h) {
                tmp[k] = nums[i++];
            } else if (nums[i] < nums[j]) {
                tmp[k] = nums[i++];
            } else {
                tmp[k] = nums[j++];
                this.cnt += m - i + 1; // a[i] > a[j]，说明 a[i...mid] 都大于 a[j]
            }
            k++;
        }
        for (k = l; k <= h; k++) {
            nums[k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        No51 no51 = new No51();
        int[] nums = new int[]{1, 2, 0};
        System.out.println(no51.inversepairs(nums));
    }

}
