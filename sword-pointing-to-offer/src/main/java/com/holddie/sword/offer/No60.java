package com.holddie.sword.offer;

import java.util.*;

/**
 * n个骰子的点数
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/25 9:05
 */
public class No60 {


    /**
     * 题目描述：
     * 把N个骰子扔在地上，求点数和为S的概率
     * <p>
     * 解题思路:
     * <p>
     * 使用一个二维数组dp存储点数出现的次数，其中 dp[i][j] 表示前 i 个骰子产生点数 j 的次数
     */

    private List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];
        for (int i = 1; i <= face; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= pointNum; j++) {
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        }
        return ret;
    }

    private List<Map.Entry<Integer, Double>> discessSum1(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[2][pointNum + 1];
        for (int i = 1; i <= face; i++) {
            dp[0][i] = 1;
        }
        int flag = 1;
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            for (int j = 0; j <= pointNum; j++) {
                dp[flag][j] = 0; // 旋转数组清零
            }
            for (int j = i; j <= pointNum; j++)  // 使用 i 个骰子最小点数为 i
            {
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[flag][j] += dp[1 - flag][j - k];
                }
            }
        }
        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[1 - flag][i] / totalNum));
        }
        return ret;
    }

    public static void main(String[] args) {
        No60 no60 = new No60();
        System.out.println(Arrays.toString(no60.dicesSum(2).toArray()));
    }

}
