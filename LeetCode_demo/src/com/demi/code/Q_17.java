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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q_17 {
	public static void main(String[] args) {
		// 测试用例
	}
	
	/*
		（1）创建List集合，存储最终的匹配字符串列表；
		（2）用map 集合存储每个数字字符对应的字母字符串；
		（3）用递归方法的思想，实现数字字符与字母字符串的匹配，
		同时，拆解字母字符串进行配对。先存储在StringBuffer数组中，
		遍历结束，在转成字符串的形式，返回最终字符串列表。
	*/
	/*public List<String> letterCombinations(String digits) {
		// 存储返回的字符串列表
		List<String> combs = new ArrayList<>();
		int len = digits.length();
		// 如果输入的是空字符串，返回空列表
		if(len == 0) {
			return combs;
		}
		// 用map集合存储数字对应的字符串
		Map<Character, String> maps = new HashMap<>() {
			{
				put('2', "abc");
				put('3', "def");
				put('4', "ghi");
				put('5', "jkl");
				put('6', "mno");
				put('7', "pqrs");
				put('8', "tuv");
				put('9', "wxyz");
			}
		};
		
		// 提取成递归方法来求解
		backtrack(combs, maps, digits, 0, new StringBuffer());
		return combs;
		
	}
	// 递归方法的使用
	public void backtrack(List<String> combs, Map<Character, String> maps, String digits, int index, StringBuffer combination) {
		// 循环结束，返回字符串列表
		if(index == digits.length()) {
			combs.add(combination.toString());
		}else {
			// 数字
			char num = digits.charAt(index);
			// 数字对应的字符串
			String letters = maps.get(num);
			// 数字对应的字符串的长度
			int lettersLen = letters.length();
			for(int i = 0; i < lettersLen; i++) {
				combination.append(letters.charAt(i));
				backtrack(combs, maps, digits, index + 1, combination);
				combination.deleteCharAt(index);
			}
		}
	}*/
}