package com.demi.code.test;


/**
 * 约瑟夫问题：
 *  解题思路：
 *      1.构建含有41个节点的单向循环链表，分别存储1-41的值，分别代表41个人；
 *      2.使用计数器count，记录当前报数的值；
 *      3.遍历链表，每循环一次，count++；
 *      4.判断count的值，如果是3，则从链表中删除这个节点并打印节点的值，把count重置为0.

 */
public class JosephTest {
    public static void main(String[] args) {
        // 构建循环链表
        // 1.first用来记录首节点
        Node<Integer> first = null;
        // 2.pre用来记录前一个节点
        Node<Integer> pre = null;
        // 3.遍历
        for(int i = 1; i <= 41; i++) {
            // 3.1 如果是第一个节点
            if(i == 1) {
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            // 3.2 如果不是第一个节点
            Node<Integer> node = new Node<>(i, null);
            pre.next = node;
            pre = node;
            // 3.3 如果是最后一个节点，需要让最后一个节点的下一个节点变为first
            if(i == 41) {
                pre.next = first;
            }
        }
        // 4.count计数器，模拟报数
        int count = 0;
        // 5.遍历循环链表
        // 记录每次遍历拿到的节点，默认从首节点开始
        Node<Integer> n = first;
        // 记录当前节点的上一个节点
        Node<Integer> before = null;
        // 循环成立的条件：节点的下一个节点不是节点本身
        while (n != n.next) {
            // 模拟报数
            count++;
            // 判断当前报数是不是3
            if(count == 3) {
                // 如果是3， 则把当前节点删除调用，
                // 打印当前节点，重置count = 0，让当前节点n后移
                before.next = n.next;
                System.out.print(n.item + ", ");
                count = 0;

            }else {
                // 如果不是3，让before 变成当前节点，让当前节点继续后移
                before = n;
            }
            n = n.next;
        }
        System.out.println(n.item);
    }

    private static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
