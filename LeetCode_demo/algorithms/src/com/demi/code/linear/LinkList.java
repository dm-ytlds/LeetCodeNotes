package com.demi.code.linear;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {
    private Node head;
    private int N;

    private class Node<T> {
        // 存储数据
        T item;
        // 下一个节点
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        // 初始化头节点
        this.head = new Node<T>(null, null);
        // 初始化链表长度
        this.N = 0;
    }
    // 清空链表
    public void clear() {
        head.next = null;
        N = 0;
    }
    // 获取链表的长度
    public int length() {
        return N;
    }
    // 判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }
    // 获取指定位置i 处的元素
    public T get(int i) {
        // 通过循环，从头节点开始往后找，依次找 i 次，就可以找到对应的元素
        Node<T> n = head.next;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return n.item;
    }
    // 向链表中添加元素t
    public void insert(T t) {
        // 找到当前的最后一个元素
        Node<T> n = head;
        while (n.next !=null) {
            n = n.next;
        }
        // 创建新节点，保存元素t
        Node<T> newNode = new Node<T>(t, null);
        // 让当前的最后一个节点指向新节点
        n.next = newNode;
        // ！！！元素个数 + 1
        N++;
    }

    // 向指定位置i处插入元素
    public void insert(int i, T t) {
        // 找到i位置处的节点
        Node<T> pre = head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        Node<T> curr = pre.next;
        // 创建新节点，并且新节点需要指向原来i位置的节点
        Node<T> newNode = new Node<T>(t, curr);
        // 原来i位置的前一个节点指向新节点
        pre.next = newNode;
        // 元素个数 + 1
        N++;
    }
    // 删除指定位置i处的元素，并返回被删除的元素
    public T remove(int i) {
        // 找到i位置的前一个节点
        Node<T> pre = head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        // 找到i位置的节点
        Node<T> curr = pre.next;
        // 找到i位置的下一个节点
        Node<T> nextNode = curr.next;
        // 前一个节点指向下一个节点
        pre.next = nextNode;
        // 元素个数 - 1
        N--;
        return curr.item;
    }

    // 查找元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        Node<T> n = head;
        for (int i = 0; i < N; i++) {
            n = n.next;
            if(n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    // 链表反转
    public void reverse() {
        // 判断当前链表是否为空，如果为空，则结束；否则调用重载的reverse()方法完成反转
        if(isEmpty()) {
            return;
        }
        reverse(head.next);
    }

    private Node<T> reverse(Node<T> curr) {
        if( curr.next == null) {
            head.next = curr;
            return curr;
        }
        // 递归反转当前节点curr的下一个节点，返回值就是链表反转后。当前节点的上一个节点
        Node<T> pre = reverse(curr.next);
        // 让返回的节点的下一个节点变成当前节点curr
        pre.next = curr;
        // 把当前节点的下一个节点变成null
        curr.next = null;
        return curr;
    }

    @Override
    public Iterator<T> iterator() {
        return new RIterator();
    }

    private class RIterator<T> implements Iterator<T> {

        private Node<T> n;
        public RIterator() {
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }
}
