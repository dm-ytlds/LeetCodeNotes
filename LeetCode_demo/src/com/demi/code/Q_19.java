package com.demi.code;

import com.demi.code.utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：删除链表的倒数第N个节点
 * 描述：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Q_19 {
    public static void main(String[] args) {

    }

    /**
     * 解题思路：
     *  先把单链表的长度len求出来，然后遍历单链表，找到第len - n + 1 节点就是需要删除的节点；
     *  最后，将剩余的节点形成的单链表返回。
     * @param head 链表
     * @param n 删除的节点位置
     * @return  返回删除节点的值
     */
    public ListNode removeNthFromEnd01(ListNode head, int n) {
        int length = length(head);
        // 自定义一个头节点之前的节点，作为起始节点
        // 因为链表是从1开始计数的，所以这里把起始节点放在第 0 个位置
        ListNode h = new ListNode(0, head);
        ListNode currNode = h;
        for(int i = 1; i < length - n + 1; ++i) {
            currNode = currNode.next;
        }
        // 把需要删除节点的前面节点过滤
        // 然后通过指针下移，跳过需要删除的节点
        currNode.next = currNode.next.next;
        // 返回除自定义的起始节点以外的节点形成的单链表。
        ListNode ans = h.next;
        return ans;
    }

    /**
     * 获取链表的长度
     * @param head
     * @return
     */
    public int length(ListNode head) {
        int len = 0;
        while(head != null) {
            // 采用 ++len 的方式，以保持删除节点的节点位置一致
            ++len;
            head = head.next;
        }
        return len;
    }

    /**
     * 思路2：利用栈数据结构的 先进后出 原则
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 初始节点
        ListNode first = new ListNode(0, head);
        // 创建栈对象
        Deque<ListNode> stack = new LinkedList<ListNode>();
        // 初始化当前节点
        ListNode currNode = first;
        // 将节点放入栈中
        while(currNode != null) {
            stack.push(currNode);
            currNode = currNode.next;
        }

        // 先跳出前n个节点
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        // 去掉第n个节点
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = first.next;
        return ans;
    }
}




