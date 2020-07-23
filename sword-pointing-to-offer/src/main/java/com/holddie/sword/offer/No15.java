package com.holddie.sword.offer;

/**
 * 二进制中1的个数
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/22 8:06
 */
public class No15 {

    /**
     * 描述：输入一个整数，输出该数二进制表示中1的个数
     */
    public int numberOf(int n) {
        return Integer.bitCount(n);
    }


    public static void main(String[] args) {
        No15 no15 = new No15();
        System.out.println(no15.numberOf(3));
        System.out.println(no15.numberOf2(3));
    }

    /**
     * 实际因为在二进制下一个位表示的地方：不是0就是1
     * 这样当进行减一操作时，就会把二进制中有1的地方进行借位运算
     * @param n 整数
     * @return int
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/22 8:13
     */
    private int numberOf2(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

}
