package com.demi.code.test;

import com.demi.code.linear.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // 测试压栈
        stack.push("a");
        stack.push("b");
        stack.push("D");
        stack.push("C");
        // 元素个数
        int size = stack.size();
        System.out.println("压栈后元素的个数为：" + size);
        System.out.println("--------------------------");
        for(String s : stack) {
            System.out.println("元素分别为：" + s);
        }
        System.out.println("--------------------------");
        // 测试弹栈
        for (int i = 0; i < size; i++) {
            String top = stack.pop();
            System.out.println("弹出的元素为：" + top);
        }
        System.out.println("--------------------------");
        // 元素个数测试
        int size02 = stack.size();
        System.out.println("弹栈后元素的个数为：" + size02);

    }
}
