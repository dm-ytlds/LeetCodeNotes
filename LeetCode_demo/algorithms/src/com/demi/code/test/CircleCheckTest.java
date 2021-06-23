package com.demi.code.test;

public class CircleCheckTest {
    public static void main(String[] args) {
        // 创建单个节点
        Node<String> first = new Node<>("a", null);
        Node<String> second = new Node<>("b", null);
        Node<String> third = new Node<>("c", null);
        Node<String> four = new Node<>("d", null);
        Node<String> five = new Node<>("e", null);
        Node<String> six = new
                Node<>("f", null);

        // 完成节点之间的指向
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        // Circle
        six.next = second;

        // 测试
        boolean b = CircleCheckTest.isCircle(first);
        System.out.println("该链表中是否有环：" + b);

    }

    private static boolean isCircle(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast.equals(slow)) {
                return true;
            }        }
        return false;
    }

    // 节点结构定义
    private static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
