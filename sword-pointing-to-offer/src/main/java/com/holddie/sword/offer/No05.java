package com.holddie.sword.offer;

/**
 * 替换空格
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/4 9:47
 */
public class No05 {

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为 We Are Happy. 则经过替换之后的字符串为 We%20Are%20Happy。
     */

    private String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        for (int i = 0; i < oldLen; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p1 = oldLen - 1;
        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        No05 no05 = new No05();
        System.out.println(no05.replaceSpace(new StringBuffer("s s s s   s s s s s s")));
    }
    /**
     * 1、根据空格数进行字符串占位，否则长度不够
     * 2、根据数倒序遍历遇到空格重新赋值%20
     */
}
