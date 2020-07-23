package com.holddie.leetcode;

/**
 * 无重复字符的最长子串
 * @author holddie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/12/5 10:31 AM
 */
public class Lc003 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int maxLength = 0;
        int[] index = new int[256];
        for (int j = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            maxLength = Math.max(maxLength, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return maxLength;
    }

    public static void main(String[] args) {

    }

}
