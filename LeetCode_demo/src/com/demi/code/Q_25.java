package com.demi.code;

import com.demi.code.utils.ListNode;

import java.util.Stack;

/** 题目：K个一组翻转链表
 *  题目描述：
 *      给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *      k是一个正整数，它的值小于或等于链表的长度。
 *      如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *  进阶：
 *      你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 *      你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Q_25 {
    /*public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        // 用栈存储取出的元素
        Stack<ListNode> stack = new Stack();
        ListNode pre = new ListNode(-1);
        ListNode curr = head;
        head = pre;
        // 求出链表的长度
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        if (len % k != 0) {
            for (int i = 0; i < k; i++) {
                stack.add(curr);
                curr = curr.next;
            }
            curr = curr.next;
            for (int i = 0; i < k; i++) {
                pre.next = stack.pop();
                pre = pre.next;
            }

        }
    }*/

    /**
     *  解题思路：
     *      需要把链表节点按照 k 个一组分组，所以可以使用一个指针 head 依次指向每组的头节点。
     *      这个指针每次向前移动 k 步，直至链表结尾。
     *      对于每个分组，我们先判断它的长度是否大于等于 k。若是，我们就翻转这部分链表，否则不需要翻转。
     *
     *      问题就是如何翻转一个分组内的子链表。翻转一个链表并不难，过程可以参考「206. 反转链表」。
     *      但是对于一个子链表，除了翻转其本身之外，还需要将子链表的头部与上一个子链表连接，以及子链表的尾部与下一个子链表连接。
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 创建一个新的节点，指向整个链表的最前端，即头节点的前面
        ListNode h = new ListNode(-1);
        // 让h节点的下一个节点指向头节点head
        h.next = head;
        // 新建一个pre指针节点指向h节点，移动时，作为子链表的头节点
        ListNode pre = h;

        while (head != null) {
            // 初始化子链表的尾指针tail
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if(tail == null) {
                    // 如果子链表的长度小于 k ，直接返回整个链表
                    return h.next;
                }
            }

            // 标出当前子链表的尾节点的下一个节点，方便子链表之间的头尾连接
            ListNode ne = tail.next;

            ListNode[] reverse = myReverse(head, tail);

            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = ne;
            // 将pre 指针 tail 指针和head 指针重定位，指向下一个子链表对应的位置
            pre = tail;
            head = tail.next;
        }
        return h.next;
    }

    // 子链表翻转的过程
    private ListNode[] myReverse(ListNode head, ListNode tail) {
        // 从子链表的尾节点出发，
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[] {tail, head};
    }
}
