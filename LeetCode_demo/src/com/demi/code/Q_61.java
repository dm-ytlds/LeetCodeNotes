package com.demi.code;

import com.demi.code.utils.ListNode;

/**
 * 题目：旋转链表
 * 给你一个链表的头节点head，旋转链表，将链表每个节点向右移动k个位置。
 *
 * 示例：
 *  输入：head = [1,2,3,4,5], k = 2
 *  输出：[4,5,1,2,3]
 */
public class Q_61 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = rotateRight(a, 6);
        System.out.println(res);
    }

    /**
     * 从给的示例可以看出：如果链表长度len小于需要旋转的次数k，则k对len取模，得到的数就是需要旋转的次数，因为每移动n次就会让链表恢复原状。
     * 所以新链表的最后一个节点为原链表的第(n-1)-(k mod n)个节点(从0开始计数的)。
     * 实现步骤：
     *  具体代码中，我们首先计算出链表的长度 n，并找到该链表的末尾节点，将其与头节点相连。这样就得到了闭合为环的链表。
     *  然后我们找到新链表的最后一个节点（即原链表的第 (n - 1) - (k mod n) 个节点），将当前闭合为环的链表断开，即可得到我们所需要的结果。
     *  特别地，当链表长度不大于 1，或者 k 为 n 的倍数时，新链表将与原链表相同，我们无需进行任何处理。
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        // 先计算ListNode的长度
        int len = 1;
        // 注意：在计算长度的时候，需要用新的节点指向head，不然head最后指向了空节点，影响后续的引用。
        ListNode h = head;
        while (h.next != null) {
            len++;
            h = h.next;
        }
        // 对环形链表来说，给一个整合过后的断开点。
        // 计算出需要移动的次数
        int move = len - k % len;
        if (move == len) {
            return head;
        }
        // 算完长度后。h就指向了null，所以此时h是一个空指针节点，直接引用，减少空间开辟的内存浪费
        h.next = head;
        // 寻找环截断点
        while (move > 0) {
            h = h.next;
            move--;
        }
        // 返回最终结果
        ListNode res = h.next;
        h.next = null;
        return res;
    }
}
