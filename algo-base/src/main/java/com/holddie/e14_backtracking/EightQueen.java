package com.holddie.e14_backtracking;

import java.util.Date;


/**
 * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
 * 即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 */
public class EightQueen {
    /**
     * 使用常量来定义，方便之后解N皇后问题
     */
    private static final short N = 8;
    /**
     * 结果计数器
     */
    private static int count = 0;

    public static void main(String[] args) {
        Date begin = new Date();
        short[][] chess = new short[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chess[i][j] = 0;
            }
        }
        putQueenAtRow(chess, 0);
        Date end = new Date();
        System.out.println("解决 " + N + " 皇后问题，用时：" + (end.getTime() - begin.getTime()) + "毫秒，计算结果：" + count);
    }

    private static void putQueenAtRow(short[][] chess, int row) {
        if (row == N) {
            count++;
            System.out.println("第 " + count + " 种解：");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(chess[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        short[][] chessTemp = chess.clone();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chessTemp[row][j] = 0;
            }
            chessTemp[row][i] = 1;
            if (isSafety(chessTemp, row, i)) {
                putQueenAtRow(chessTemp, row + 1);
            }
        }
    }

    private static boolean isSafety(short[][] chess, int row, int col) {
        int step = 1;
        while (row - step >= 0) {
            if (chess[row - step][col] == 1) {
                return false;
            }
            if (col - step >= 0 && chess[row - step][col - step] == 1) {
                return false;
            }
            if (col + step < N && chess[row - step][col + step] == 1) {
                return false;
            }
            step++;
        }
        return true;
    }
}