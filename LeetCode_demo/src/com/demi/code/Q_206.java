package com.demi.code;

import com.demi.code.utils.ListNode;

/**
 * 反转链表
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
     * 解题思路：
     *  将节点之间的指向反向，每一次反转一个指向，所以接下来的指向反转就需要移动到下一个节点，涉及到节点的移动，用创建临时节点来解决。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // prev和curr都会移动
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 临时保存curr的下一个节点，方便curr移动到curr.next
            ListNode temp = curr.next;
            // curr的下一跳反过来指向prev
            curr.next = prev;
            // 将prev移到当前节点curr
            prev = curr;
            // 将当前节点curr移到curr的下一跳curr.next，即temp
            curr = temp;
        }
        return prev;
    }

}

