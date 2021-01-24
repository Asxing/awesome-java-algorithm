package com.holddie.sword.offer;

/**
 * 从1到n整数中1出现的次数
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/7 9:21
 */
public class No43 {

    private int numberof1between1andSolution(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            cnt += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        No43 no43 = new No43();
        System.out.println(no43.numberof1between1andSolution(10));
    }
}
