package com.holddie.sword.offer;

/**
 * 剪绳子
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/17 8:13
 */
public class No14 {

    /**
     * 描述：把一根绳子剪成多段，并且使得每段的长度乘积最大。
     * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
     */

    /**
     * 动态规划法
     * @param n 长度
     * @return 最大乘积
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/17 8:17
     */
    private int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }

    /**
     * 贪心算法实现
     * @param n 长度
     * @return 最大乘积
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/17 8:29
     */
    private int integerBreakGreedy(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timeOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timeOf2));
    }


    public static void main(String[] args) {
        No14 no14 = new No14();
        System.out.println(no14.integerBreak(5));
//        System.out.println(no14.integerBreakGreedy(15));

    }

}
