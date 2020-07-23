package com.holddie.sword.offer;

/**
 * 左旋转字符串
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/23 14:57
 */
public class No5802 {
    /**
     * 题目描述：
     * 对于一个给定的字符序列 S，请你把其循环左移 K 位后的序列输出。
     * 例如，字符序列 S=”abcXYZdef”, 要求输出循环左移 3 位后的结果，即“XYZdefabc”。
     * <p>
     * 解题思路：
     * 将 "abcXYZdef" 旋转左移三位，可以先将 "abc" 和 "XYZdef" 分别旋转，
     * 得到 "cbafedZYX"，然后再把整个字符串旋转得到 "XYZdefabc"。
     */
    private String leftRotateString(String str, int n) {
        if (n >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }


    public static void main(String[] args) {
        No5802 no5802 = new No5802();
        System.out.println(no5802.leftRotateString("abcXYZdef", 3));
    }
}
