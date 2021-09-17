package com.demi.code.tencent;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：最小栈
 */
public class Q_155 {
    public static void main(String[] args) {

    }
}

class MinStack {
    // 辅助栈
    Deque<Integer> stack;
    // 最小栈
    Deque<Integer> minStack;
    public MinStack() {
        // 栈的初始化
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        // 初始化最小栈的第一个元素
        minStack.push(Integer.MAX_VALUE);
    }
    // 入栈
    public void push(int val) {
        // 辅助栈入栈，正常操作
        stack.push(val);

        // 每入栈一个值，都需要与最小栈栈顶元素作比较。每次都存储最小值在最小栈中
        minStack.push(Math.min(minStack.peek(), val));
    }
    // 出栈
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    // 获取栈顶元素
    public int top() {
        return stack.peek();
    }
    // 得到最小元素
    public int getMin() {
        return minStack.peek();
    }
}
