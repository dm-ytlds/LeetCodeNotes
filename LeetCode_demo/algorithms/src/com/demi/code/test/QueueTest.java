package com.demi.code.test;

import com.demi.code.linear.Queue;

public class QueueTest {
    public static void main(String[] args) {
        // 创建队列对象
        Queue<String> queue = new Queue<>();

        // enqueue
        queue.enqueue("A");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("D");
        for(String s : queue) {
            System.out.println(s);
        }


        int size = queue.size();
        System.out.println("入队后元素的个数：" + size);
        System.out.println("----------------");

        // dequeue
        for (int i = 0; i < size; i++) {
            System.out.println("第 " + (i + 1) + "个出队元素为：" + queue.dequeue());
        }

        int size01 = queue.size();
        System.out.println("出队后元素的个数：" + size01);
    }


}
