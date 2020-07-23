package com.holddie.sword.offer;

/**
 * 数值的整数次方
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/22 8:24
 */
public class No16 {

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent，求base的exponent次方
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }

        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            pow = pow * base;
        }
        return isNegative ? 1 / pow : pow;
    }

    public static void main(String[] args) {
        No16 no16 = new No16();
        System.out.println(no16.Power(4.0, 3));
    }
}
