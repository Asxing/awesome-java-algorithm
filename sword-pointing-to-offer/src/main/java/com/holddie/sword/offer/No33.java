package com.holddie.sword.offer;

/**
 * 二叉树搜索树的后续遍历序列
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/1 8:17
 */
public class No33 {


    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int fastIndex, int lastIndex) {
        if (lastIndex - fastIndex <= 1) {
            return true;
        }
        int rootVal = sequence[lastIndex];
        int cutIndex = fastIndex;
        while (cutIndex < lastIndex && sequence[cutIndex] <= rootVal) {
            cutIndex++;
        }
        for (int i = cutIndex + 1; i < lastIndex; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, fastIndex, cutIndex - 1) && verify(sequence, cutIndex, lastIndex - 1);
    }

    public static void main(String[] args) {
        int[] aa = {1, 3, 2};
        No33 no33 = new No33();
        System.out.println(no33.verifySquenceOfBST(aa));
    }


}
