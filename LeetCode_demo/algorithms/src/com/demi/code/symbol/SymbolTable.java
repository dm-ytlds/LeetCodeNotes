package com.demi.code.symbol;

/**
 * 符号表的实现
 *
 */
public class SymbolTable<Key, Value> {
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
    public SymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    // 获取符号表中键值对的个数
    public int size() {
        return N;
    }

    // 往符号表中插入键值对
    public void put(Key key, Value value) {
        // 符号表中已经存在键为key的键值对，那么只需要找到该节点，替换值为value即可
        Node node = head;
        while(node.next != null) {
            // 变换node
            node = node.next;
            // 判断node节点存储的键是否为key，如果是，则替换值为value
            if(node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        // 如果符号表中不存在键为key的键值对，只需要创建新节点，
        // 保存要插入的键值对，把新节点插入到链表的头部
        Node newNode = new Node(key, value, null);
        Node oldFirst = head.next;
        newNode.next = oldFirst;
        head.next = newNode;
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
