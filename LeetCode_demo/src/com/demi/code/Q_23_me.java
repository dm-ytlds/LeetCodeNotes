package com.demi.code;

import com.demi.code.utils.ListNode;

import java.util.List;

/**
 * 归类：链表
 * 题目：合并k个链表
 * 注意：链表都是升序链表。
 */
public class Q_23_me {
    public static void main(String[] args) {

    }

    /**
     * 二分法 + 递归 + 合并两个链表的方法
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    // 二分法
    private static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    // 合并两个有序链表
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prev = new ListNode(-1);
        ListNode head = prev;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 == null) {
            prev.next = l2;
        } else if (l2 == null) {
            prev.next = l1;
        }
        return head.next;
    }
}
