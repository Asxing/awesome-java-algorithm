package com.holddie.sword.offer;

/**
 * 求1+2+3+...+n
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/27 9:08
 */
public class No64 {

    /**
     * 题目描述 求 1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句（A?B:C）。
     *
     * <p>解题思路 使用递归解法最重要的是指定返回条件，但是本题无法直接使用 if 语句来指定返回条件。
     *
     * <p>条件与 && 具有短路原则，即在第一个条件语句为 false 的情况下不会去执行第二个条件语句。 利用这一特性，将递归的返回条件取非然后作为 &&
     * 的第一个条件语句，递归的主体转换为第二个条件语句， 那么当递归的返回条件为 true 的情况下就不会执行递归的主体部分，递归返回。
     *
     * <p>以下实现中，递归的返回条件为 n <= 0，取非后就是 n > 0，递归的主体部分为 sum += Sum_Solution(n - 1)， 转换为条件语句后就是 (sum +=
     * Sum_Solution(n - 1)) > 0。
     */
    private int sumSolution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += sumSolution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        No64 no64 = new No64();
        System.out.println(no64.sumSolution(5));
    }
}
