package com.demi.code;

import com.demi.code.utils.ListNode;

/**
 * 归类：链表
 * 题目：K个一组翻转链表
 */
public class Q_25_me {
    public static void main(String[] args) {

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode curr = prev;
        while (head != null) {
            ListNode tail = curr;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                // 不到k个，直接返回
                if (tail == null) {
                    return prev.next;
                }
            }
            ListNode nextNode = tail.next;
            ListNode[] reverse =  myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表连接原链表
            prev.next = head;
            tail.next = nextNode;
            curr = tail;
            head = tail.next;


        }
        return prev.next;
    }

    private static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;
        while(head != tail) {
            ListNode ne = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ne;

        }
        return new ListNode[] {tail, head};
    }
}
