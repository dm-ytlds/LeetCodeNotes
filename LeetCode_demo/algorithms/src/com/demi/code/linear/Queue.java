package com.demi.code.linear;

import java.util.Iterator;

/**
 * 队列的实现
 *
 */
public class Queue<T> implements Iterable<T> {
    Node head;
    Node last;
    int N;


    private static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    // 返回队列中元素的个数
    public int size() {
        return N;
    }

    // 向队列中插入元素t
    // 注意：插入节点是插在队列的尾节点处，而不是头节点处
    public void enqueue(T t) {
        if(last == null) {
            // 如果尾节点为空，直接将新节点插入就行
            last = new Node(t, null);
            head.next = last;
        }
        else {
            // 当前尾节点last不为空，找到当前尾节点
            Node oldLast = last;
            // 让新元素的节点指向尾节点，成为新的尾节点
            last = new Node(t, null);
            oldLast.next = last;
        }
        // 队列元素个数 + 1
        N++;
    }

    // 从队列中取出一个元素
    public T dequeue() {
        if(isEmpty()) {
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;

        // 如果队列中没有元素了，则重置队列
        if(isEmpty()) {
            last = null;
        }
        return (T)oldFirst.item;
    }


    @Override
    public Iterator<T> iterator() {
        return new RIterator<>();
    }
    private class RIterator<T> implements Iterator<T> {
        private Node curr;

        public RIterator() {
            this.curr = head;
        }

        @Override
        public boolean hasNext() {
            return curr.next != null;
        }

        @Override
        public T next() {
            curr = curr.next;
            return (T)curr.item;
        }
    }
}
