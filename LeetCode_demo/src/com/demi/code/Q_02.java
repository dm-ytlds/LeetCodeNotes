package com.demi.code;

import java.util.LinkedList;

/**
题目：
    给定两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
    并且每个节点只能存储一位数字。

    请将两个数相加，并以相同的形式返回一个表示和的链表。
    你可以假设除了数字0以外，这两个数都不会以0开头。
    示例1：
        输入：l1 = [2,4,3], l2 = [5,6,4]
        输出：[7,0,8]
        解释：342 + 465 = 807.
    示例2：
        输入：l1 = [0], l2 = [0]
        输出：[0]
    示例3：
        输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        输出：[8,9,9,9,0,0,0,1]
 */
public class Q_02 {
    public static void main(String[] args) {
        Q_02 a = new Q_02();
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(4, n3);
        ListNode n1 = new ListNode(2, n2);
        System.out.println(n1);

        ListNode n6 = new ListNode(4);
        ListNode n5 = new ListNode(6, n6);
        ListNode n4 = new ListNode(5, n5);
        System.out.println(n4);

        ListNode result = a.addTwoNNumbers(n1, n4);
        System.out.println(result);  // ListNode{val=7, next=ListNode{val=0, next=ListNode{val=8, next=null}}}


    }

    /**
     * 解题思路：
     *  由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
     *  我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。具体而言，如果当前两个链表处相应位置的数字为 n1,n2,进位值为carry，
     *  则它们的和为 n1+n2+carry；其中，答案链表处相应位置的数字为 (n1+n2+carry) % 10，而新的进位值为(n1+n2+carry) / 10
     *  如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 0 。
     *  此外，如果链表遍历结束后，有 carry > 0，还需要在答案链表的后面附加一个节点，节点的值为 carry。
     * @param l1  链表1
     * @param l2  链表2
     * @return
     */
    public ListNode addTwoNNumbers(ListNode l1, ListNode l2) {
        //初始化链表的头节点和尾节点
        ListNode head = null, tail = null;
        // 初始化一个进位标识
        int carry = 0;
        // 循环单链表l1和l2
        while(l1 != null || l2 != null) {
            // 循环遍历。用赋值0来保证循环的次数一样。
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            // 求和
            int sum = n1 + n2 + carry;
            if(head == null) {
                // 更新头节点，并初始化尾节点为头节点
                head = tail = new ListNode(sum % 10);

            }else {
                // 头节点不为空。更新当前尾节点
                tail.next = new ListNode(sum % 10);
                tail = tail.next;

            }
            carry = sum / 10;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}

// 链表定义
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}