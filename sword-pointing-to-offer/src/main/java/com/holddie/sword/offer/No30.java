package com.holddie.sword.offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/30 8:13
 */
public class No30 {

    /**
     * 主要思想： 利用空间换取时间，使用了一个辅助的数据结构，来存储当前栈中的最小 元素，同样道理使用了一个栈来顺序的存储了当前情况下的最优解，当
     * 相当于是一个记录，记录每一次的最小值。（牛逼）
     */
    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public Integer pop() {
        minStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        No30 no30 = new No30();
        no30.push(2);
        no30.push(3);
        no30.push(1);
        no30.push(5);
        no30.push(6);
        no30.push(3);
        no30.push(2);

        System.out.println(no30.min());
        System.out.println(no30.minStack);
    }
}
