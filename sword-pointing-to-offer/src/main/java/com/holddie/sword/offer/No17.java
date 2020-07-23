package com.holddie.sword.offer;

/**
 * 打印从1到最大的n位数
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/22 8:40
 */
public class No17 {

    /*
    题目描述：输入数字n，按顺序打印从1最大的n位十进制，比如输入3，则打印1、2、3 一致到最大的3位数即999
     */
    private void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, -1);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit + 1] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }

    /**
     * 解题思路：对于多少位的数，就申请多大的一个数组作为缓冲的标记地方，
     * 在每次优先进行深度遍历，并且判断是否为0，若为0则当前为不输出，从
     * 不是0的地方开始输出
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/22 9:23
     */
    public static void main(String[] args) {
        No17 no17 = new No17();
        no17.print1ToMaxOfNDigits(2);
    }
}
