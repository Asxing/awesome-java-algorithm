package com.holddie.sword.offer;

import java.util.Stack;

/**
 * 两个占实现队列
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/8 7:49
 */
public class No09 {

    /**
     * 题目描述：
     * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。队列中的元素为 int 类型。
     */

    /**
     * 解题思路：
     * in 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。
     * 一个元素进入 in 栈之后，出栈的顺序被反转。当元素要出栈时，需要先进入 out 栈，
     * 此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，
     * 先进入的元素先退出，这就是队列的顺序。
     */

    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public static void main(String[] args) throws Exception {
        No09 no09 = new No09();

        no09.push(1);
        no09.push(2);
        no09.push(3);
        System.out.println(no09.pop());
        System.out.println(no09.pop());
        no09.push(4);
        no09.push(5);
        System.out.println(no09.pop());
        System.out.println(no09.pop());
        System.out.println(no09.pop());

    }

    public void push(Integer data) {
        in.push(data);
    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return out.pop();
    }


}
