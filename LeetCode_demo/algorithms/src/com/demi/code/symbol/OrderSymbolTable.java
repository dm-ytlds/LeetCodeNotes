package com.demi.code.symbol;

/**
 * 符号表的实现
 *
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    // 记录首节点
    private Node head;
    // 记录符号表中元素的个数
    private int N;

    private class Node {
        // 键key
        public Key key;
        // 值value
        public Value value;
        // 下一个节点
        public Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // 构造方法
    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    // 获取符号表中键值对的个数
    public int size() {
        return N;
    }

    // 往符号表中插入键值对
    public void put(Key key, Value value) {
        // 定义两个Node变量，分别记录当前节点和当前节点的上一个节点
        Node curr = head.next;
        Node pre = head;
        while (curr != null && key.compareTo(curr.key) > 0) {
            // 变换当前节点和前一个节点
            pre = curr;
            curr = curr.next;
        }
        // 如果当前节点curr的键和要插入元素key值一样，把新的节点插入到curr之前
        if(curr != null && key.compareTo(curr.key) == 0) {
            curr.value = value;
            return;
        }
        // 如果当前节点curr的键和要插入元素key值不一样，把新的节点插入到curr之前
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;

        // 元素个数 + 1
        N++;
    }

    // 删除键为key的键值对
    public void delete(Key key) {
        // 找到键为key的节点
        Node n = head;
        while (n.next != null) {
            // 判断n节点的下一个节点的键是否为key，如果是，则删除该节点
            if(n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    // 从符号表中获取key对应的值
    public Value get(Key key) {
        // 找到键为key的节点
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if(n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }
}
