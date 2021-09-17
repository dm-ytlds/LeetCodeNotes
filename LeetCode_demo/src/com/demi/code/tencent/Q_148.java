package com.demi.code.tencent;

import com.demi.code.utils.ListNode;

/**
 * 题目：链表排序
 */

public class Q_148 {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    /**
     * 归并排序
     * 快慢指针找中间点
     * @param start
     * @param end
     * @return
     */
    private ListNode sort(ListNode start, ListNode end) {
        // 拆分链表的终止条件
        if (start == end) {
            return start;
        }
        // 使用快慢指针找中间节点
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode l2 = sort(slow.next, end);
        // 从中间节点处，断开链表
        slow.next = null;
        ListNode l1 = sort(start, slow);

        return merge(l1, l2);
    }

    /**
     * 合并链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        // 合并的终止条件。
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
