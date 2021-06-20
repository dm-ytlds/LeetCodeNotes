package com.demi.code;

import com.demi.code.utils.ListNode;

import java.util.Stack;

/** 题目：两两交换链中的节点
 *    题目描述：表
 *      给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *      示例1：
 *          输入：head = [1,2,3,4]
 *          输出：[2,1,4,3]
 *      示例2：
 *          输入：head = []
 *          输出：[]
 *
 *      来源出处：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Q_24 {
    public static void main(String[] args) {

    }

    /**
     * 解题思路：递归
     *  只要链表中节点的个数大于1个就可以做交换。
     *  我们来一一分析下，假设链表总长是偶数，那么递归函数执行到终止条件时，head 就等于 null。
     *  如果链表总长是偶数，那么递归函数执行到终止条件时，head.next 就等于 null。
     *  递归函数内，我们要改变 1->2 的指向，将其改为 2->1。
     *  那后面的节点怎么办呢？不用担心，这是由下一层递归函数来解决。
     *  下一层递归函数返回后的节点是 4，就是4->3->...这样的了，也就是后面的节点都已经串联好了。
     *  所以我们只需要将 1 节点指向 4 就可以啦。
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/dong-hua-yan-shi-24-liang-liang-jiao-huan-lian-bia/
     * @param head
     * @return
     */
    public ListNode swapPairs01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs01(newHead.next);
        newHead.next = head;
        return newHead;
    }


    /** 解题思路：迭代
     *      假设链表是 1->2->3->4->5->6；
     *      迭代的时候，每次处理两个节点，于是第一轮 a指向1， b指向2；
     *      在第二论迭代的时候，a指向 3， b指向 4，同理，第三轮的时候， a指向 5， b指向 6。
     *      可以通过 a.next = b.next， 以及b.next = a 就把两个指针的位置反转了，于是 1->2 就变成了 2->1 。
     *      当第二轮迭代的时候，a 指向 3， b 指向 4。 按照题目要求，最终应该是2->1->4->3。
     *      也就是节点1需要跟节点4串起来，只有两个节点就完成不了，所以需要再创建一个指针tmp，用来记录上一轮a的位置，
     *      然后下一轮迭代的时候，将原先的a（也就是节点1）指向 4。
     *
     *
     * @param head
     * @return
     */
    public ListNode swapPairs02(ListNode head) {
        // 方便最后储存生成的交换后的链表
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 创建两个指针，以及一个tmp指针
        ListNode a = pre;
        ListNode b=  pre;
        ListNode tmp = pre;
        while(b != null && b.next != null && b.next.next != null) {
            // a前进一位，b前进两位
            a = a.next;
            b = b.next.next;
            /*
                这步很关键，tmp指针用来处理边界条件的
                假设链表是1->2->3->4，a指向1，b指向2
                改变a和b的指向，于是就变成2->1，但是1指向谁呢？
                1是不能指向2的next，1应该指向4，而循环迭代的时候一次处理2个节点
                1和2的关系弄清楚了，3和4的关系也能弄清楚，但需要一个指针来处理
                2->1，4->3的关系，tmp指针就是干这个用的
            */
            tmp.next = b;
            a.next = b.next;
            b.next = a;

            // 经过上面的处理，链表就变成了2->1->4->3
            // tmp和pre都指向了节点1，等下一次迭代的时候，
            // a就变成了3，b就变成4，然后tmp 就指向b，也就是节点1指向节点4
            tmp = a;
            b = a;
        }
        return pre.next;
    }

    /** 解题思路：栈的 后进先出 原则
     *      我们利用一个 stack，然后不断迭代链表，每次取出两个节点放入 stack 中，再从 stack 中拿出两个节点。
     *      借助 stack 后进先出的特点，放进去的时候是 1,2 。拿出来的时候就是 2，1 两个节点了。
     *      再把这两个节点串联起来，重复这个逻辑遍历完整个链表，就可以做到两两反转的效果了。
     *      虽然用到了 stack，但因为只存了两个元素，所以空间复杂度还是 O(1)，时间复杂度是 O(n)。
     *
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/dong-hua-yan-shi-24-liang-liang-jiao-huan-lian-bia/
     *
     * @param head
     * @return
     */
    public ListNode swapPairs03(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // 用stack保存每次迭代的两个节点
        Stack<ListNode> stack = new Stack<>();
        ListNode p = new ListNode(-1);
        ListNode cur = head;
        // head指向新的p节点，方法结束时返回head.next即可
        head = p;
        while (cur != null && cur.next != null) {
            // 将两个节点放入栈中
            stack.add(cur);
            stack.add(cur.next);
            // 当前节点cur往前走两步
            cur = cur.next.next;
            // 从stack 中弹出两个节点，然后用p节点指向新弹出的两个节点
            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        // 注意边界条件。当链表长度是奇数时，cur就不为空
        if(cur != null) {
            p.next = cur;
        } else {
            p.next = null;
        }
        return head.next;

    }

}
