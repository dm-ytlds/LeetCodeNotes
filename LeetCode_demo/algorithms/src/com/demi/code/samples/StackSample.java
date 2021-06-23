package com.demi.code.samples;

import com.demi.code.linear.Stack;

/**
 * 逆波兰表达式（后缀表达式）的计算问题
 *
 */
public class StackSample {
    public static void main(String[] args) {
        // 中缀表达式 3 * (17 - 15) + 18 / 6的逆波兰表达式为：
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int res = calculate(notation);
        System.out.println("3 * (17 - 15) + 18 / 6 = " + res);
    }

    public static int calculate(String[] notation) {
        // 定义一个栈，存储操作数
        Stack<Integer> stack = new Stack<>();
        // 从左往右遍历逆波兰表达式
        for (int i = 0; i < notation.length; i++) {
            String curr = notation[i];
            // 判断当前元素是运算符还是操作数
            Integer o1;
            Integer o2;
            Integer result;
            switch (curr) {
                // 是运算符，则从栈中弹出两个操作数，完成运算，运算完的结果在压入栈中
                case "+":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    // 注意：栈的弹出是反的，所以在计算结果时，应后者操作前者
                    result = o2 + o1;
                    stack.push(result);
                    break;
                case "-":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 - o1;
                    stack.push(result);
                    break;
                case "*":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 * o1;
                    stack.push(result);
                    break;
                case "/":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    if(o2 != 0) {
                        result = o2 / o1;
                        stack.push(result);
                    }
                    break;
                default:
                    // 是操作数，把该操作数压入栈中
                    stack.push(Integer.valueOf(curr));
                    break;
            }

        }

        int res = stack.pop();
        // 栈中最后一个值就是最终结果
        return res;
    }
}
