package com.demi.code;

import com.demi.code.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 归类：链表
 * 题目：删除链表的倒数第N个节点
 * 要求：使用一次扫描实现删除。
 */
public class Q_19_me {
    public static void main(String[] args) {

    }

    /**
     * method01：计算出倒数第n个节点对应的顺序节点是第 链表长度 - n + 1 个节点。
     *          所以首先解决链表求长度问题，然后，遍历完前链表长度 - n + 1各节点，
     *          删除第 链表长度 - n + 1 节点即可。
     * 注意细节：需要创建一个pre节点指向head节点，创建一个curr节点作为遍历指针，先指向pre。
     * @param head
     * @param n
     * @return
     */
    public static ListNode deleteN01(ListNode head, int n) {
        int len = len(head);
        if (n > len) return null;
        ListNode pre = new ListNode(-1, head);
        ListNode curr = pre;
        // 将倒数第n个，转换成顺序第len - n + 1个
        // 遍历完这几个数
        for (int i = 1; i < len - n + 1; i++) {
            curr = curr.next;
        }
        // 删除第len - n + 1个节点
        curr.next = curr.next.next;
        return pre.next;
    }
    // 求链表的长度
    private static int len(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }

    /**
     * method02：运用栈“先进后出”原则，找到倒数第n个节点，删除即可。
     * @param head
     * @param n
     * @return
     */
    public static ListNode deleteN02(ListNode head, int n) {
        // 头节点指针
        ListNode pre = new ListNode(-1, head);
        // 当前节点指针
        ListNode curr = pre;
        // 创建栈
        Deque<ListNode> stack = new ArrayDeque<>();
        // 将所有节点存入栈中
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        // 先弹出栈中的前n - 1个节点
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        // 删除第n个节点
        ListNode nodeN = stack.peek();
        nodeN.next = nodeN.next.next;
        return pre.next;
    }

}
