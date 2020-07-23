package com.holddie.sword.offer;

/**
 * 丑数
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/10 16:09
 */
public class No49 {

    /**
     * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
     * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
     * 习惯上我们把 1 当做是第一个丑数。
     * 求按从小到大的顺序的第 N 个丑数。
     */
    public int getuglynumberSolution(int index) {
        if (index <= 6) {
            return index;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int n2 = dp[i2] * 2, n3 = dp[i3] * 3, n5 = dp[i5] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) {
                i2++;
            }
            if (dp[i] == n3) {
                i3++;
            }
            if (dp[i] == n5) {
                i5++;
            }
        }
        return dp[index - 1];
    }

    public static void main(String[] args) {
        No49 no49 = new No49();
        System.out.println(no49.getuglynumberSolution(4));
        System.out.println(no49.getuglynumberSolution(7));
    }

}
