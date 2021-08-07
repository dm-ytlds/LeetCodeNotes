package com.demi.code;

import com.demi.code.utils.ListNode;

/**
 * 归类：链表
 * 两数相加
 */
public class Q_02_me {
    public static void main(String[] args) {
        ListNode node01 = new ListNode(2);
        ListNode node02 = new ListNode(4);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(5);
        ListNode node05 = new ListNode(6);
        ListNode node06 = new ListNode(4);
        node01.next = node02;
        node02.next = node03;
        node04.next = node05;
        node05.next = node06;
        ListNode sum = twoSums(node01, node04);
        System.out.println(sum);

    }

    public static ListNode twoSums(ListNode l1, ListNode l2) {
        // 初始化头节点和尾节点
        ListNode head = null, tail = null;
        // 可能存在进位。初始化进位标志
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            // 求相应节点数值数字和
            int sum = n1 + n2 +carry;
            if (head == null) {
                // 头节点为空，更新头节点和尾节点
                head = tail = new ListNode(sum % 10);
            } else {
                // 在尾节点处添加新节点
                tail.next = new ListNode(sum % 10);
                // 切记：更新尾节点
                tail = tail.next;
            }
            // 更新进位值
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }
}
