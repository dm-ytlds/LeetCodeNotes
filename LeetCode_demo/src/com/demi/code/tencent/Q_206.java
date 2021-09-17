package com.demi.code.tencent;

import com.demi.code.utils.ListNode;

/**
 * 题目：反转链表
 * 给定单链表的头节点 head ，返回翻转后的链表。
 */
public class Q_206 {
    public static void main(String[] args) {
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(4);
        ListNode node05 = new ListNode(5);
//        ListNode root = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;

        ListNode root = reverseList(node01);
        System.out.println(root);
    }

    /**
     * 每一反转一个指向。
     *  所以需要保存当前节点，和当前节点的下一个节点位置
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 初始化一个空指针节点用来移动遍历链表中的每一个节点
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // 下一个节点
            ListNode next = curr.next;
            // 当前节点指向prev节点
            curr.next = prev;
            // 空指针节点prev指向当前节点
            prev = curr;
            // 当前节点向下一个节点移动
            curr = next;
        }
        return prev;
    }
}
