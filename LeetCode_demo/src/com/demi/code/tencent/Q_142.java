package com.demi.code.tencent;


import com.demi.code.utils.ListNode;

import java.util.List;

/**
 * 题目：环形链表2
 */

public class Q_142 {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {

            slow = slow.next;
            if (fast.next != null) {
                fast =fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr =ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
