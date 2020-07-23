package com.holddie.sword.offer;

/**
 * 数字序列中的某一位数字
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/8 8:55
 */
public class No44 {

    private int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digit = 1;
        while (true) {
            int amount = getAmountOfDigit(digit);
            int totalAmount = amount * digit;
            if (index < totalAmount) {
                return digitAtIndex(index, digit);
            }
            index -= totalAmount;
            digit++;
        }
    }

    private int getAmountOfDigit(int digit) {
        if (digit == 1) {
            return 10;
        }
        return (int) (Math.pow(10, digit - 1) * 9);
    }

    private int digitAtIndex(int index, int digit) {
        int number = biginMumber(digit) + index / digit;
        int remain = index % digit;
        return (number + "").charAt(remain) - '0';
    }

    private int biginMumber(int digit) {
        if (digit == 1) {
            return 0;
        }
        return (int) Math.pow(10, digit - 1);
    }

    public static void main(String[] args) {
        No44 no44 = new No44();
        System.out.println(no44.digitAtIndex(10));
        System.out.println(no44.digitAtIndex(11));
        System.out.println(no44.digitAtIndex(12));
        System.out.println(no44.digitAtIndex(13));
        System.out.println(no44.digitAtIndex(14));
        System.out.println(no44.digitAtIndex(15));
    }

}
