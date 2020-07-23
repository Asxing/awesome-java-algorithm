package com.holddie.sword.offer;

/**
 * 圆圈中最后剩下的数
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/26 9:16
 */
public class No62 {

    /**
     * 解题思路：
     * 约瑟夫环，圆圈长度为n的解可以看成长度为n-1
     * 的解在加上报数的长度m，因为是圆圈，所以最后需要对n取余
     */
    private int lastRemainingSolution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (lastRemainingSolution(n - 1, m) + m) % n;
    }

    public static void main(String[] args) {
        No62 no62 = new No62();
        System.out.println(no62.lastRemainingSolution(13, 2));
    }

}
