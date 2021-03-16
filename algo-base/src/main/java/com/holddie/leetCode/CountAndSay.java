package com.holddie.leetCode;

/**
 * 1 被读作 "one 1" ("一个一") , 即 11。 11 被读作 "two 1" ("两个一"）, 即 21。 21 被读作 "one 2", "one 1" （"一个二" ,
 * "一个一") , 即 1211。 #TODO 迷迷糊糊
 *
 * @author liuchao
 * @date 2019/5/24
 */
public class CountAndSay {
    /**
     * 1 1 4 1211
     *
     * @param n key
     * @return value
     */
    private String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        String temp = "";

        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        if (n == 3) {
            return "21";
        }
        if (n >= 4) {
            temp = countAndSay(n - 1);
        }
        System.out.println("temp = " + temp);
        int check = 1;
        char c = temp.charAt(0);
        for (int i = 1; i < temp.length(); i++) {
            System.out.println(
                    "check = " + check + ",c = " + c + ",temp[" + i + "] = " + temp.charAt(i));
            if (temp.charAt(i) == c) {
                check++;
                continue;
            }
            if (temp.charAt(i) != c) {
                result.append(check);
                result.append(c);
                check = 1;
                c = temp.charAt(i);
            }
        }
        System.out.println("check = " + check + ",c = " + c);
        System.out.println("result-before = " + result);
        result.append(check);
        result.append(c);
        System.out.println("result-after = " + result);
        return result.toString();
    }

    public String countAndSay1(int n) {
        if (n == 1) {
            return "1";
        }
        String num = countAndSay1(n - 1);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            int count = 1;
            while (i < num.length() - 1 && num.charAt(i) == num.charAt(i + 1)) {
                count++;
                i++;
            }
            s.append(count);
            s.append(num.charAt(i));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        int n = 15;
        System.out.println("n = " + n + ",result = " + countAndSay.countAndSay(n));
    }
}
