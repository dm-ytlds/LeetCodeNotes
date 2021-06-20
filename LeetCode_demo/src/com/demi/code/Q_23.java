package com.demi.code;

import com.demi.code.utils.ListNode;
/**
	题目：合并K个升序链表
	描述：给定一个链表数组，每个链表都已经按升序排序。
		  将所有链表合并成一个升序链表，返回合并后的链表。
	示例：
		输入：lists = [[1,4,5],[1,3,4],[2,6]]
		输出：[1,1,2,3,4,4,5,6]
*/

public class Q_23 {
	public static void main(String[] args) {
		
	}
/*
 方式1：
		用迭代的方式。
	
		每两个链表做一次合并。
		时间复杂度：O(k^2 * n)。其中k为循环的次数；n为数组中链表的个数（数组的长度）。
		空间复杂度：O(1)。
*/

	public ListNode mergeKLists01(ListNode[] lists) {
		// 数组的长度
		int len = lists.length;
		
		ListNode res = null;
		for (int i = 0; i < len; i++) {
			res = mergeTwoLists(res, lists[i]);
		}
		return res;
	}
	
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		if (a == null || b == null) {
			return a != null ? a : b;
		}
		ListNode head = new ListNode(-1);
		ListNode pre = head;
		while (a != null && b != null) {
			if (a.val < b. val) {
				pre.next = a;
				a = a.next;
			}else {
				pre.next = b;
				b = b.next;
			}
			pre = pre.next;
		}
		if (a == null) {
			pre.next = b;
			
		}
		else if (b == null) {
			pre.next = a;
			
		}
		return head.next;
	}
/*
 方法二：分治合并
		思路:考虑优化方法一，用分治的方法进行合并。

			将 k 个链表配对并将同一对中的链表合并；
			第一轮合并以后， k 个链表被合并成了 k / 2 个链表，平均长度为 2n / k，
			然后是 k / 4 个链表， k / 8 个链表等等；
			重复这一过程，直到我们得到了最终的有序链表。
		时间复杂度：O(k * n * logk);
		空间复杂度：O(logk)。
		作者：LeetCode-Solution
		链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
*/

	public ListNode mergeKLists(ListNode[] lists) {
		return merge(lists, 0, lists.length - 1);
	}
	
	public ListNode merge(ListNode[] lists, int l, int r) {
		// 链表数组中有一个空链表
		if(l == r) {
			return lists[l];
		}
		// 数组为空
		if(l > r) {
			return null;
		}
		
		// (l + r) >> 1 等同于 (l + r) / 2;
		int mid = (l + r) >> 1;
		return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
	}
}
