package com.demi.code;

/*
  题目：电话号码的字母组合
	给定一个仅包含数字2-9的字符串，返回它所有能表示的字母组合。答案可以按 任意顺序 返回。
	给出数字到字母的映射与电话按键相同。

	示例1：
		输入：digits = "23"
		输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
		
	示例2：
		输入：digits = ""
		输出：[]

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number

*/

public class Q_17 {
	public static void main(String[] args) {
		// 测试用例
	}
	
	/*
		观察到：在数字2-9中，只有数字7和9对应4个字母，其它6个数字都对应3个字母
	*/
	public List<String> letterCombinations(String digits) {
		// 将数字字符串转换成数字
		int nums = Integer.valueOf(digits);
		// 
		StringBuffer sb = new StringBuffer();
		while(nums != 0) {
			int num = nums % 10;
			String s = numToLetter(num);
			sb.append(s);
			nums -= nums / 10;
		}
		// 将StringBuffer转换成字符串
		String ss = String.valueOf(sb);
		int len = ss.length();
		String[] sts = new String[len * len];
		for(int i = 0; i < len; i++) {
			for(int j = 1; j < len; j++) {
				sts
			}
		}
		
    }
	
	// 返回每个数字所对应的字符串
	public static String numToLetter(int num) {
		
		switch(num) {
			case 2:
				return "abc";
			case 3:
				return "def";
			case 4:
				return "ghi";
			case 5:
				return "jkl";
			case 6:
				return "mno";
			case 7:
				return "pqrs";
			case 8:
				return "tuv";
			case 9:
				return "wxyz";
			default:
				return null;
		}
	}
	
	
	
	
}