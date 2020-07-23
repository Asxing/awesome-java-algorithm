package com.holddie.sword.offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列
 * 是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列
 * 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应
 * 的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/30 8:28
 */
public class No31 {


    /**
     * 针对于入栈和出栈，首先借助的数据结构是栈，因为是两个数组，其实核心思想就是，
     * 确保出栈的顺序和入栈的同步，整体也是就是 比如出栈的数组开始是从4出栈，则要
     * 保证的就是，类似在入栈4之后的数字，都应该在出栈的时候在4之后，这样顺序同步，
     * 采用递归的思想，出栈的就不考虑了。
     * <p>
     * 但是在实现的过程中，更加巧妙
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        // 貌似不加也可以，通杀型
//    if (pushA.length != popA.length){
//        return false;
//    }

        int n = pushA.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (popIndex < n && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};

        No31 no31 = new No31();
        System.out.println(no31.IsPopOrder(pushA, popA));
    }

}
