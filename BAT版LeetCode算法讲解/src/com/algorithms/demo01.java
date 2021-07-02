package com.algorithms;

/** 暴力递归到动态规划1
 * https://www.bilibili.com/video/BV1PB4y1w7Tj?from=search&seid=8056243090427949156
 * 将链表中第 m 到 n 个节点进行逆置。
 * 示例：
 *      1->2->3->4->5->6
 *      逆置2到5节点
 *      结果为：
 *      1->5->4->3->2->6
 */
public class demo01 {
    public static void main(String[] args) {
        demo01 qus = new demo01();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode new_a = qus.reverse(a, 2, 4);
        System.out.println(new_a);
    }

    public ListNode reverse(ListNode head, int m, int n) {
        int change_len = n - m + 1; // 计算出要逆置的长度
        ListNode pre_head = null;  // 初始化逆置段头节点前驱
        ListNode result = head;    // 最终转换后的链表头节点
        // 将head节点移动到新的头节点的下一个节点处
        while(head.next != null && m != 0) {
            --m;
            pre_head = head; // 将head向前移动m - 1个位置
            head = head.next; // 记录head的前驱节点
        }
        ListNode new_head = null;
        ListNode modify_list_tail = head;
        // 从head开始，逆置change_len = n - m + 1个节点
        while(head.next != null && change_len != 0) {
            ListNode next = head;
            head.next = new_head;
            new_head = head;
            head = next;
            change_len--;
        }
        // 将modify_list_tail与head相连
        modify_list_tail.next = head;
        if(pre_head != null) {
            pre_head.next = new_head;
        }else {
            result = new_head;
        }
        return result;
    }
}


class ListNode {
    public int value;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}