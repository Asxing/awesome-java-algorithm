package com.holddie.sword.offer;

import java.util.Arrays;

/**
 * 构建乘积数组
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/28 9:32
 */
public class No66 {

    /**
     * 题目描述： 给定一个数组 A[0, 1,..., n-1], 请构建一个数组 B[0, 1,..., n-1], 其中 B 中的元素
     * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     */
    private int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[A.length];

        for (int i = 0, product = 1; i < n; i++) {
            B[i] = product;
            product *= A[i];
        }

        for (int i = n - 1, product = 1; i >= 0; i--) {
            B[i] *= product;
            product *= A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        No66 no66 = new No66();
        System.out.println(Arrays.toString(no66.multiply(new int[] {1, 2, 3})));
    }
}
