package com.holddie.sword.offer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵数字
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 8:25
 */
public class No29 {

    /**
     * 整体就是围绕着矩阵的四个参数循环遍历，
     * 然后中间再判断一下行的开始和结束是否相等
     * @param matrix 二位矩阵数组
     * @return 循环遍历完的数组
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/29 8:36
     */
    private ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>(matrix.length * matrix[0].length);

        int row_start = 0, row_end = matrix.length - 1;
        int col_start = 0, col_end = matrix[0].length - 1;

        while (row_start <= row_end && col_start <= col_end) {
            for (int i = col_start; i <= col_end; i++) {
                ret.add(matrix[row_start][i]);
            }
            for (int j = row_start + 1; j <= row_end; j++) {
                ret.add(matrix[j][col_end]);
            }
            if (row_start != row_end) {
                for (int i = col_end - 1; i >= col_start; i--) {
                    ret.add(matrix[row_end][i]);
                }
            }
            if (col_start != col_end) {
                for (int i = row_end - 1; i > row_start; i--) {
                    ret.add(matrix[i][col_start]);
                }
            }
            row_start++;
            row_end--;
            col_start++;
            col_end--;
        }
        return ret;
    }

    public static void main(String[] args) {

        int[][] martrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        No29 no29 = new No29();
        System.out.println(no29.printMatrix(martrix));
    }


}
