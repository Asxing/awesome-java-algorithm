package com.holddie.sword.offer;

/**
 * 表示数值的字符串
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/25 9:00
 */
public class No20 {

    public boolean isNumberic(char[] str) {
        return str != null && new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        No20 no20 = new No20();
        //        System.out.println(no20.isNumberic("+100".toCharArray()));
        //        System.out.println(no20.isNumberic("+100".toCharArray()));
        System.out.println(no20.isNumberic("5e2".toCharArray()));
    }
}
