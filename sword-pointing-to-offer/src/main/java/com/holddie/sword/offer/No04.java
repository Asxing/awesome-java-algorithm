package com.holddie.sword.offer;

/**
 * 有序二维数组查找值
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/2 9:09
 */
public class No04 {

    /** 在一个二维数组中，每一行都按照从左到右递增 的顺序排序，每一列都按照从上到下递增的顺序排序。 请完成一个函数，输入这样的一个二维数组 和一个整数，判断数组中是否函数该整数。 */
    public static void main(String[] args) {

        int[][] arr = {
            {1, 2, 3, 4},
            {2, 3, 4, 5},
            {3, 4, 5, 6},
            {4, 5, 6, 7}
        };
        System.out.println(find(arr, 5));

        /**
         * 总结: 此处的查找，只是判断数组中是否含有某个数字， 关键点就是利用每行和每列的规律，可以从右上角开始， 也可以从左下角开始，利用的就是不对称，
         * 若在其中查找某个数的第几个，此时会在添加一个标志位，此时应指明次序
         */
    }

    private static boolean find(int[][] arr, int i) {
        int a = arr.length;
        int b = arr[0].length;
        for (int c = 0, d = a - 1; c <= b - 1 && d >= 0; ) {
            if (arr[d][c] == i) {
                System.out.println("第" + (d + 1) + "行,第" + (c + 1) + "列");
                return true;
            }
            if (arr[d][c] > i) {
                --d;
            } else {
                ++c;
            }
        }
        return false;
    }
}
