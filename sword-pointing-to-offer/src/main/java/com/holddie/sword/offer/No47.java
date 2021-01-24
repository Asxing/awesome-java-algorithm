package com.holddie.sword.offer;

/**
 * 礼物最大值
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/9 14:54
 */
public class No47 {

    /**
     * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
     * 给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
     *
     * <p>1 10 3 8 12 2 9 6 5 7 4 11 3 7 16 5 礼物的最大价值为 1+12+5+7+7+16+5=53。
     */
    private int getMost(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int n = values[0].length;
        int[] dp = new int[n];
        for (int[] value : values) {
            dp[0] += value[0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + value[j];
                System.out.println(dp[j]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {

        No47 no47 = new No47();
        int[][] values = {
            {1, 10, 3, 8},
            {12, 2, 9, 6},
            {5, 7, 4, 11},
            {3, 7, 16, 5}
        };

        System.out.println(no47.getMost(values));
    }
}
