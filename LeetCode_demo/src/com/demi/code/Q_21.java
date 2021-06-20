package com.demi.code;

import com.demi.code.utils.ListNode;

/**
 * 题目：合并两个有序列表
 *  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *  示例：
 *      输入：l1 = [1,2,4], l2 = [1,3,4]
 *      输出：[1,1,2,3,4,4]
 */
public class Q_21 {
    public static void main(String[] args) {
        Q_21 qus = new Q_21();
        ListNode n3 = new ListNode(1);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(4, n2);
//        System.out.println(n1);

        ListNode n6 = new ListNode(1);
        ListNode n5 = new ListNode(3, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode l = qus.mergeTwoLists(n1, n4);
        System.out.println(l);
    }

    /** 递归
     *  解题思路：
     *      如果链表一开始就是空链表，那么没有任何操作需要合并，所以只需要返回空链表。
     *      否则需要判断l1和l2哪一个链表的头节点值更小，然后递归的界定下一个添加到结果里的节点。
     *      如果两个链表有一个为空，递归结束。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 特例
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        // 如果链表1的头节点值比链表2的头节点值小，链表1向后移动
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l2;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l1;
        }
    }


    /**
     * 迭代
     * 解题思路：
     *  当两个链表都不是空链表时，判断l1和l2哪一个链表的头节点的值更小，
     *  将较小值的节点添加到结果里，当一个节点被添加到结果里之后，将对应链表中的节点先后移一位。
     * 实现过程：
     *      首先，我们设定一个哨兵节点 preNode ，这可以在最后让我们比较容易地返回合并后的链表。
     *      我们维护一个 pre 指针，我们需要做的是调整它的 next 指针。
     *      然后，我们重复以下过程，直到 l1 或者 l2 指向了 null ：如果 l1 当前节点的值小于等于 l2 ，
     *      我们就把 l1 当前的节点接在 pre 节点的后面同时将 l1 指针往后移一位。
     *      否则，我们对 l2 做同样的操作。不管我们将哪一个元素接在了后面，我们都需要把 pre 向后移一位。
     *      在循环终止的时候， l1 和 l2 至多有一个是非空的。由于输入的两个链表都是有序的，
     *      所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。
     *      这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表即可。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        // 定义一个preNode指针
        ListNode preNode = new ListNode(-1);
        ListNode pre = preNode;
        // 终止条件是链表当前节点不为空，而不是下一个节点不为空
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 == null) {
            pre.next = l2;
        }else if(l2 == null) {
            pre.next = l1;
        }
        return preNode.next;
    }
}
