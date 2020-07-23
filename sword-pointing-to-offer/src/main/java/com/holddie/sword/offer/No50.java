package com.holddie.sword.offer;

import java.util.BitSet;

/**
 * 第一次出现一次的字符位置
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/11 9:31
 */
public class No50 {

    private int firstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    private int firstNotRepeatingCharUseSet(String string) {
        BitSet bitSet1 = new BitSet(256);
        BitSet bitSet2 = new BitSet(256);
        for (char c : string.toCharArray()) {
            if (!bitSet1.get(c) && !bitSet2.get(c)) {
                bitSet1.set(c);
            } else if (bitSet1.get(c) && !bitSet2.get(c)) {
                bitSet2.set(c);
            }
        }
        for (int i = 0; i < string.length(); i++) {
            if (bitSet1.get(string.charAt(i)) && !bitSet2.get(string.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        No50 no50 = new No50();
        System.out.println(no50.firstNotRepeatingChar("avsdsdfasdasdh"));
        System.out.println(no50.firstNotRepeatingCharUseSet("112312345746765789"));
    }

}
