package com.demi.code;

import com.demi.code.utils.ListNode;

/**
 * 归类：链表
 * 题目：两两交换链表中的节点
 */
public class Q_24_me {

    /**
     * 创建一个当前节点curr，以及当前节点的下一个节点的下一个节点nextNode。
     *
     * @param head
     * @return
     */
    public ListNode exchangeEachOfTwoNodes(ListNode head) {
        // 空链表
        if (head == null) return null;
        // 一个节点
        if (head.next.next == null) return head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        // 创建两个指针，以及一个临时指针
        // 指针a 指向下一个节点
        ListNode a = prev;
        // 指针b指向下下一个节点
        ListNode b = prev;
        ListNode tmp = prev;
        while (b != null && b.next != null && b.next.next != null) {
            a = a.next;
            b = b.next.next;

            tmp.next = b;
            a.next = b.next;
            b.next = a;

            tmp = a;
            b = a;

        }
        return prev.next;
    }
}
