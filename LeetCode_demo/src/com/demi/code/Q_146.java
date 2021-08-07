package com.demi.code;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** LRU缓存机制 https://leetcode-cn.com/problems/lru-cache
 *  设计和实现一个LRU(最近最少使用)缓存机制。
 *  实现LRUCache类：
 *      LRUCache(int capacity)以正整数作为容量capacity初始化LRU缓存。
 *      int get(int key)如果关键字 key 存在于缓存中，则返回关键字的值，否则返回-1。
 *      void put(int key, inr value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组【关键字-值】。
 *      当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  示例：
 *     输入
 *      ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 *      [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 *     输出
 *      [null, null, null, 1, null, -1, null, -1, 3, 4]
 */
public class Q_146 {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println(lru.get(1));
        lru.put(4, 4);
        System.out.println(lru.get(2));
    }
}

/**
 * key, value形式，需要想到hashMap
 * 改变数据的访问时间：
 *  需要能随机访问；
 *  需要把该数据插入到头部或者尾部
 *
 * 考点：
 *  实现哈希表的解法
 *  想到利用链表解决访问顺序的问题
 */
class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    // 初始化
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    // 构造方法
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 伪节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        // 双向
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 从cache集合中取出key对应的节点
        DLinkedNode node = cache.get(key);
        // 不存在该节点的情况
        if (node == null) {
            return -1;
        }
        // 节点在cache集合中
        // 先通过hash表定位，在移动头部节点
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 从cache集合中取出key对应的节点
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 不存在该节点，创建节点，放入cache和双链表中
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            // 如果链表大小超过缓存容量
            if (size > capacity) {
                // 创建新节点，取出当前双链表的尾节点，并将其从缓存cache中也移除
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                // 同时，链表大小－1
                --size;
            }
        } else {
            // 如果key 存在，修改value 的值，并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // 移除双向链表的尾节点
    private DLinkedNode removeTail() {
        // tail为伪尾节点
        // 所以tail.prev才是真正的尾节点
        DLinkedNode res = tail.prev;
//        res.prev.next = res.next;
//        res.next.prev = res.prev;
        removeNode(res);
        return res;
    }

    // 增加节点到双向链表的头部
    private void addToHead(DLinkedNode newNode) {
        // 先安排newNode
        newNode.prev = head;
        newNode.next = head.next;
        // 再安排head
        head.next.prev = newNode;
        head.next = newNode;
    }

    // 移动节点到双向链表的头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除哪个节点，就从哪个节点出发来考虑。
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}

