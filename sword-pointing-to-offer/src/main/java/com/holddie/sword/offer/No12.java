package com.holddie.sword.offer;

/**
 * 矩阵中的路径
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/9 9:31
 */
public class No12 {

    /**
     * 题目描述： 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如下面的矩阵包含了一条 bfce 路径。
     */
    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private int rows;
    private int cols;

    public static void main(String[] args) {
        No12 no12 = new No12();
        //        no12.hasPath()
    }

    /**
     * 判断是否存在
     *
     * @param array 矩阵字符串
     * @param rows 矩阵行
     * @param cols 矩阵列
     * @param str 字符串路径
     * @return 存在一条路径返回true，否则false
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/9 9:35
     */
    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix, str, marked, 0, i, j)) return true;
        return false;
    }

    private boolean backtracking(
            char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {
        if (pathLen == str.length) return true;
        if (r < 0
                || r >= rows
                || c < 0
                || c >= cols
                || matrix[r][c] != str[pathLen]
                || marked[r][c]) return false;
        marked[r][c] = true;
        for (int[] n : next)
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1])) return true;
        marked[r][c] = false;
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) matrix[i][j] = array[idx++];
        return matrix;
    }

    /**
     * 问题本质： 首先，在矩阵中任选一个格子作为路径的起点，如果路径上的第i个字符不是ch，那么这个格子不可能出资按路径上的第i个位置
     * 如果路径上的第i个字符正好是ch，那么往相邻的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其他格子都有4个相邻的格子。
     *
     * <p>重复这个过程直到路径上的所有字符都在矩阵中找到相应的位置。
     *
     * <p>由于回朔法的递归特性，路径可以被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后，
     * 在与第n个字符对应的格子的周围都没有找到第n+1个字符，这个时候只要在路径上回到第n-1个字符，重新定位第n个字符。
     *
     * <p>由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。
     *
     * <p>当矩阵中坐标为（row,col）的格子和路径字符串中相应的字符一样时，
     * 从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中下一个字符
     * 如果4个相邻的格子都没有匹配字符串中下一个的字符，表明当前路径字符串中字符在矩阵中的定位不正确，
     * 我们需要回到前一个，然后重新定位。一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置
     */
}
