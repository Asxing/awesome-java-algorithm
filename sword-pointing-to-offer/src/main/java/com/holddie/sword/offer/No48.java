package com.holddie.sword.offer;

import java.util.Arrays;

/**
 * 最长不含重复字符的子字符串
 *
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/10 15:39
 */
public class No48 {

    /** 题目描述： 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的 子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字 符串为 acfr，长度为 4。 */
    private int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            int preIndex = preIndexs[c];
            if (preIndex == -1 || i - preIndex > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = i - preIndex;
            }
            preIndexs[c] = i;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

    public static void main(String[] args) {
        No48 no48 = new No48();
        System.out.println(no48.longestSubStringWithoutDuplication("arabcacfr"));
        //        System.out.println("123123123");
    }
}
