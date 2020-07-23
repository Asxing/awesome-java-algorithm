package com.holddie.sword.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串的排列
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/4 8:21
 */
public class No38 {

    private ArrayList<String> ret = new ArrayList<>();

    private ArrayList<String> permutation(String str) {
        if (str.length() == 0) {
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuffer());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuffer sb) {
        if (sb.length() == chars.length) {
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) { //去重
                continue;
            }
            hasUsed[i] = true;
            sb.append(chars[i]);
            backtracking(chars, hasUsed, sb);
            sb.deleteCharAt(sb.length() - 1);
            hasUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        No38 no38 = new No38();
        System.out.println(no38.permutation("aabc"));
    }

}
