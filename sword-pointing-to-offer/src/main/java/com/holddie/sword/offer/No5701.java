package com.holddie.sword.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 和为S的两个数字
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/22 9:16
 */
public class No5701 {


    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum) {
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            }
            if (cur < sum) {
                i++;
            } else {
                j--;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3};
        No5701 no5701 = new No5701();
        System.out.println(no5701.findNumbersWithSum(array, 4));
    }


}
