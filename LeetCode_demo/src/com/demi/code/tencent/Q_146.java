package com.demi.code.tencent;

import java.util.HashMap;
import java.util.Map;

public class Q_146 {
//    LRUCache lru = new LRUCache();

}
class LRUCache {

    // 重新定义个一个双向链表
    class DListNode {
        int key;
        int val;
        DListNode pre;
        DListNode next;
        public DListNode() {}
        public DListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private int capacity;
    private int size;
    private Map<Integer, DListNode> map = new HashMap<>();
    private DListNode head;
    private DListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;
    }
    // 取值操作
    public int get(int key) {
        // 通过key ， 取出map中的对应节点
        DListNode node = map.get(key);
        // 如果该节点不存在
        if (node == null) {
            return -1;
        }
        // 存在的话，返回节点的值，并移动到头节点的下一个节点
        moveToHead(node);
        return node.val;
    }
    // 移动节点到头节点的操作
    public void moveToHead(DListNode node) {
        // 删除该节点removeNode(node);

        node.next.pre = node.pre;
        node.pre.next = node.next;
        // 增加到头节点addToHead(node);
        // 注意：此处的指针指向先后顺序
        node.pre = head;
        node.next = head.next;
        head.next = node;
        head.next.pre = node;

    }
    // 存值操作
    public void put(int key, int value) {
        // 通过所给的key， 查找map中是否已经有对应的value，没有则添加，有则覆盖
        DListNode node = map.get(key);
        if (node == null) {
            // 存key value
            DListNode newNode = new DListNode(key, value);
            map.put(key, newNode);
            // 移到头节点处
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DListNode res = removeTail();
                map.remove(res.key);
                --size;
            }
        } else {
            // 覆盖之前的value
            node.val = value;
            moveToHead(node);
        }
    }

    public void addToHead(DListNode node) {
        node.pre = head;
        node.next = head.next;
        head.next = node;
        head.next.pre = node;
    }

    public DListNode removeTail() {
        // 链表中的tail指针为伪尾节点
        DListNode res = tail.pre;
        res.next.pre = res.pre;
        res.pre.next = res.next;
        return res;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */