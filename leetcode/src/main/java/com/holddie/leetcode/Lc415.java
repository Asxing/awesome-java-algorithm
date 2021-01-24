package com.holddie.leetcode;

// 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
// 注意：
//
//
// num1 和num2 的长度都小于 5100.
// num1 和num2 都只包含数字 0-9.
// num1 和num2 都不包含任何前导零。
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
//
// Related Topics 字符串
// 👍 193 👎 0

class Lc415 {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        boolean haveCarryOver = false;
        StringBuilder totalString = new StringBuilder();
        for (int i = 0; i < len1 || i < len2; i++) {
            int single;
            if (i >= len1) {
                single = Integer.parseInt(num2.substring(len2 - 1 - i, len2 - i));
            } else if (i >= len2) {
                single = Integer.parseInt(num1.substring(len1 - 1 - i, len1 - i));
            } else {
                single =
                        Integer.parseInt(num1.substring(len1 - 1 - i, len1 - i))
                                + Integer.parseInt(num2.substring(len2 - 1 - i, len2 - i));
            }
            if (haveCarryOver) {
                single++;
            }

            if (single > 9) {
                haveCarryOver = true;
                totalString.append(single % 10);
            } else {
                haveCarryOver = false;
                totalString.append(single);
            }
        }
        if (haveCarryOver) {
            totalString.append(1);
        }
        return totalString.reverse().toString();
    }

    public String addStringsWayOne(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = (i >= 0 ? num1.charAt(i) - '0' : 0);
            int y = (j >= 0 ? num2.charAt(j) - '0' : 0);
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
