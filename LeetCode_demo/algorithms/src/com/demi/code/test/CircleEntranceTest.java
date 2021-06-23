package com.demi.code.test;

public class CircleEntranceTest {
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
        Node node = CircleEntranceTest.getEntrance(first);
        System.out.println("该链表中环的入口为节点：" + node.item);

    }

    /**
     * 查找有环链表中 环的入口节点
     *
     * @param first 链表的首节点
     * @return 环的入口节点
     */
    public static Node getEntrance(Node<String> first) {
        // 定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        // 临时指针，备用
        Node<String> temp = null;

        // 遍历链表，先找到环(快慢指针相遇)，准备一个临时指针，
        // 指向链表的首节点，继续遍历，直到临时指针与慢指针相遇，就结束
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果链表中有环，则放入临时指针，操作和慢指针一样：一次移动一格
            if(fast.equals(slow)) {
                temp = first;
                continue;
            }
            // 让临时节点变换
            // 若临时节点不为空，说明链表中有环
            // 有环，临时指针开始移动，移动方式和慢指针一样：一次移动一格
            if(temp != null) {
                temp = temp.next;
                // 判断临时指针是否和慢指针相遇
                if(temp.equals(slow)) {
                    break;
                }
            }

        }
        return temp;
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
