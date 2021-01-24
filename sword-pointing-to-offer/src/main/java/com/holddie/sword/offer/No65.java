package com.holddie.sword.offer;

/**
 * 不用加减乘除做加法
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/28 9:18
 */
public class No65 {

    /**
     * 题目描述： 写一个函数，求两个整数之和，要求函数体内不得使用 +，-，*，/ 四则运算
     *
     * <p>a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
     *
     * <p>递归会终止的原因是 (a & b) << 1 最右边会多一个 0，那么继续递归，进位最右边的 0 会慢慢增多，最后进位会变为 0，递归终止。
     */
    private int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        No65 no65 = new No65();
        System.out.println(no65.add(1, 2));

        System.out.println(1 ^ 2);
        System.out.println((3 & 2) << 1);
    }
}
