package com.holddie.sword.offer;

/**
 * 斐波那契数列
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/8 8:08
 */
public class No10 {
    /** 题目描述： 求斐波那契数列，菲波那契数列的第 n 项，n <= 39。 */

    /**
     * 解题思路： 使用原有的递归，就会重复计算一些问题。 计算 f(10) 需要计算 f(9) 和 f(8)，计算 f(9) 需要计算 f(8) 和 f(7)，可以看到 f(8)
     * 被重复计算了。
     *
     * <p>目前使用动态规划的思路就是，从最开始往后迭代，但是每次都缓存前面两个值，然后迭代往后计算。
     */
    public static void main(String[] args) {
        No10 no10 = new No10();
        System.out.println(no10.fibonacci(2));

        Solution solution = new Solution();
        System.out.println(solution.fibonacci(2));
    }

    /**
     * 思路一：就是这样迭代往上走
     *
     * @param n 第n个数
     * @return int
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/8 8:36
     */
    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int pre0 = 0;
        int pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre0 + pre1;
            pre0 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}

/**
 * 思路二：应为限定了大小，所以可以至直接声明一个数组大小进行全部计算 之后就可以直接使用了
 *
 * @author HoldDie
 * @version v1.0.0
 * @email HoldDie@163.com
 * @date 2018/5/8 8:43
 */
class Solution {
    private int[] fib = new int[40];

    Solution() {
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }

    public int fibonacci(int n) {
        return fib[n];
    }
}
