package com.demi.code;

/**
* 题目要求：
* 	编写一个函数来查找字符串数组中的最长公共前缀。
*
* 	如果不存在公共前缀，返回空字符串""。
*
*	示例 1：
*
*	输入：strs = ["flower","flow","flight"]
*	输出："fl"
*
*	来源：力扣（LeetCode）
*	链接：https://leetcode-cn.com/problems/longest-common-prefix
*
*/

public class Q_14 {
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		Q_14 qus = new Q_14();
//		String str01 = qus.longestCommonPrefix01(strs);
		String str02 = qus.longestCommonPrefix02(strs);
		// 按行扫描
//		System.out.println(str01);
		// 按列扫描
		System.out.println(str02);
	}
//	/*
//		求解函数：
//		（1）按行扫描。
//		时间复杂度：O(n^2)；
//		空间复杂度：O(1)。
//	*/
//	public String longestCommonPrefix01(String[] strs) {
//		if(strs == null || strs.length == 0) {
//			return "";
//		}
//		// 初始化前缀字符串
//		String prefixStr = strs[0];
//		for(int i = 1; i < strs.length; i++) {
//			// 从数组中第二个字符串开始读取，并循环遍历串中字符
//			prefixStr = longestCommonPrefix(prefixStr, strs[i]);
//			if(prefixStr.length() == 0) {
//				break;
//			}
//		}
//		return prefixStr;
//	}
//
//	public String longestCommonPrefix(String str1, String str2) {
//		int length = Math.min(str1.length(), str2.length());
//		int index = 0;
//		while(index < length && str1.charAt(index) == str2.charAt(index)) {
//			index++;
//		}
//		return str1.substring(0, index);
//	}

	/*
		求解函数：
		（2）按列扫描。
		时间复杂度：O(n^2)；
		空间复杂度：O(1)。
	*/
	public String longestCommonPrefix02(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		// 没有必要找出最小的那个字符串长度，随便一个都可以，因为随便找一个长度要么长了，也无所谓，要么就是最短的，那刚好
        // 作为列数
        int length = strs[0].length();
		// 行数
		int count = strs.length;
        // 按列扫描
		for(int i = 0; i < length; i++) {
			char ch = strs[0].charAt(i);
			for(int j = 1; j < count; j++) {
				// 用|| 而不是 &&
                // 当列数达到了该行字符串的长度，或者该行列位置的元素不再等于第0行该列的字符
				if(i == strs[j].length() || strs[j].charAt(i) != ch) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}

}