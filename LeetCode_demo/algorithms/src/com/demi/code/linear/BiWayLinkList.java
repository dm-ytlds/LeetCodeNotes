package com.demi.code.linear;

import java.util.Iterator;

public class BiWayLinkList<T> implements Iterable<T> {
    // 头节点
    private BiNode head;
    // 尾节点
    private BiNode last;
    // 链表的长度
    private int N;

    private class BiNode {
        public BiNode pre;
        public T item;
        public BiNode next;

        public BiNode(BiNode pre, T item, BiNode next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }
    public BiWayLinkList() {
        this.head = new BiNode(null, null, null);
        this.last = null;
        this.N = 0;
    }
    // 清空双向链表
    public void clear() {
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }

    // 获取双向链表的长度
    public int length() {
        return N;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    // 获取链表的第一个元素
    public T getFirst() {
        if(isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    // 获取链表的最后一个元素
    public T getLast() {
        if(isEmpty()) {
            return null;
        }
        return last.item;
    }
    // 获取链表中i处的元素，并返回
    public T get(int i) {
        BiNode n = head.next;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return n.item;
    }
    // 向链表中插入元素t
    public void insert(T t) {
        if(isEmpty()) {
            // 链表中没有元素
            BiNode newNode = new BiNode(head, t,null);
            // 让新节点成为尾节点
            last = newNode;
            // 让头节点指向尾节点
            head.next = last;
        }else {
            // 链表中有元素
            BiNode oldLast = last;
            BiNode biNode = new BiNode(oldLast, t, null);
            // 让新节点指向当前尾节点
            oldLast.next = biNode;
            // 让新节点指向尾节点
            last = biNode;
        }
        // 元素个数 + 1
        N++;
    }

    // 向指定位置i 处插入元素t
    public void insert(int i, T t) {
        // 找到i位置的前一个节点、
        BiNode pre = head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        // 找到i位置的节点
        BiNode curr = pre.next;
        // 让i位置的前一个节点的下一个节点变成新节点
        BiNode newNode = new BiNode(pre, t, curr);
        pre.next = newNode;
        // 让i 位置的前一个节点变成新节点
        curr.pre = newNode;
        // 元素个数 + 1
        N++;
    }

    // 找到元素t在链表中第一次出现的位置
    public int indexOf(T t) {
        BiNode node = head;
        for (int i = 0; node.next != null; i++) {
            node = node.next;
            if(node.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    // 删除i处的元素，并返回该元素
    public T remove(int i) {
        // 找到i位置的前一个节点
        BiNode pre = head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        // 找到i位置的节点
        BiNode curr = pre.next;
        // 找到i位置的下一个节点
        BiNode nextNode = curr.next;
        // 让i 位置的前一个节点的向下一个节点变成i位置的下一个节点
        pre.next = nextNode;
        // 让i位置的下一个节点的上一个节点变成i位置的前一个节点
        nextNode.pre = pre;
        // 元素个数 - 1
        N--;

        return curr.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new RIterator();
    }

    private class RIterator<T> implements Iterator {
        private BiNode n;
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
            return (T) n.item;
        }
    }

}
