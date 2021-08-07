package com.demi.code;

import com.demi.code.utils.ListNode;

/**
 * 归类：链表
 * 题目：合并两个有序链表
 *
 */
public class Q_21_me {
    public static void main(String[] args) {

    }

    /**
     * 遍历两个链表，每次选出较小的值来连接。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode head = prev;
        // 注意：同时遍历
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            // 前进一个节点
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
            l1 = l1.next;
        }
        if (l2 != null) {
            prev.next = l2;
            l2 = l2.next;
        }
        return head;
    }
}
