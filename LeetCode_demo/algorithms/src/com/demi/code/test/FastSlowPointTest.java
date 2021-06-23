package com.demi.code.test;


public class FastSlowPointTest {
    public static void main(String[] args) {
        // 创建单个节点
        Node<String> first = new Node<>("a", null);
        Node<String> second = new Node<>("b", null);
        Node<String> third = new Node<>("c", null);
        Node<String> four = new Node<>("d", null);
        Node<String> five = new Node<>("e", null);
        Node<String> six = new Node<>("f", null);

        // 完成节点之间的指向
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        five.next = six;

        // 测试
        String mid = FastSlowPointTest.getMid(first);
        System.out.println("链表中间元素为：" + mid);

    }

    // 快慢指针实现：链表中间元素值的查找
    private static String getMid(Node<String> first) {
        // 定义两个指针
        Node<String> slow = first;
        Node<String> fast = first;
        // 使用两个指针遍历链表，当快指针指向的节点没有下一个节点，遍历结束，结束之后慢指针指向的节点就是中间节点
        while(fast != null && fast.next != null) {
            // 快指针移动两格
            fast = fast.next.next;
            // 慢指针移动一格
            slow = slow.next;
        }
        return slow.item;
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
