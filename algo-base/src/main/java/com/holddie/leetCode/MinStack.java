package com.holddie.leetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 *
 * @author liuchao
 * @date 2019/6/10
 */
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /**
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 push(x) -- 将元素 x 推入栈中。 pop() -- 删除栈顶的元素。 top() --
     * 获取栈顶元素。 getMin() -- 检索栈中的最小元素。 示例: MinStack minStack = new MinStack(); minStack.push(-2);
     * minStack.push(0); minStack.push(-3); minStack.getMin(); --> 返回 -3. minStack.pop();
     * minStack.top(); --> 返回 0. minStack.getMin(); --> 返回 -2.
     */
    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        //        while (!minStack.stack.isEmpty()){
        //            System.out.println("" + minStack.stack.pop());
        //        }
        //        System.out.println("----------------------");
        //        System.out.println("length= " + minStack.stack.size());
        int min = minStack.getMin();
        System.out.println("最小值：" + min);
        minStack.pop();
        int top = minStack.top();
        System.out.println("top:" + top);
        int newMin = minStack.getMin();
        System.out.println("newMin:" + newMin);
    }
}
