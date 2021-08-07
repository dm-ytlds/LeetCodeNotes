package com.demi.code;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU（最近最少使用）缓存机制
 *  解题思路：哈希表和双向链表
 *      哈希表的key存储欲存入键值对的键，哈希表的value存储欲存入的键值对。实现了键值对的查找时间复杂度O(1)；
 *      双向链表实现了向缓存机制中增加和删除元素的时间复杂度为O(1)。
 *
 */
public class Q_146_me {
    public static void main(String[] args) {
        LRUCache01 lru = new LRUCache01(2);
        // 测试put
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println(lru.get(1));

        System.out.println(lru.get(1));
        for (int i = 0; i < lru.cache.size(); i++) {
            System.out.println();
        }
    }
}

class LRUCache01 {
    // 创建双向链表节点结构
    public class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }
        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // 初始化
    // 链表的大小
    int size = 0;
    // 缓存表的容量
    int capacity;
    // 链表的头尾节点
    DLinkedNode head;
    DLinkedNode tail;
    // 缓存表
    Map<Integer, DLinkedNode> cache = new HashMap<>();

    // 构造方法

    public LRUCache01(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    // get method
    public int get(int key) {
        // 通过key，取出缓存表中的键值对
        DLinkedNode node = cache.get(key);
        // cache中找不到该节点，返回-1
        if (node == null) {
            return -1;
        }
        // cache中找到该节点
        // 将节点的值返回，并刷新该节点到链表的头部
        moveToHead(node);
        return node.val;
    }

    // put method
    public void put (int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果cache中没有该键值对
            // 首先插入该键值对到cache中
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            // 然后将该新的节点添加到头部
            addToHead(newNode);
            ++size;
            // 考虑cache是否满员的情况
            if (size > capacity) {
                // 已满员，删除尾节点
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 节点存在的情况
            // 先更新node 的value
            node.val = value;
            // 再移动到头部
            moveToHead(node);
        }

    }

    private DLinkedNode removeTail() {
        // 有伪尾节点，所以真正的尾节点是tail.prev
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;

    }

    private void moveToHead(DLinkedNode node) {
        // 首先需要删除该节点
        removeNode(node);
        // 然后将节点添加到头节点
        addToHead(node);

    }

    private void addToHead(DLinkedNode node) {
        // 就node节点进行指针指向
        // 记住顺序：
        //    先prev，后next
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        // 双向链表删除节点的操作
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
}
