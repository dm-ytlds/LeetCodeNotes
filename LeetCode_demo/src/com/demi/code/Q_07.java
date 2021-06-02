package com.demi.code;

/**
 * 题目要求：
 *	请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个32位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数myAtoi(string s) 的算法如下：
 * 	读入字符串并丢弃无用的前导空格
 * 	检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 	读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 	将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 	如果整数数超过 32 位有符号整数范围 [−2^31,2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。
 * 	具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
 * 	返回整数作为最终结果。
 *
 * 注意：
 * 	本题中的空白字符只包括空格字符 ' ' 。
 * 	除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 示例看题目描述：
 * 	https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Q_07 {
	public static void main(String args[]) {
		Q_07 qus = new Q_07();
		String s = "  1234 5is a number. ";
		int num = qus.myAtoi(s);
		System.out.println(num);
	}

	/**
	 * 解题思路：
	 * 	首先将字符串转换成字符数组。然后按照字符判断是否是数字，得到最终的输出结果。
	 * 	特别注意：
	 * 		对于符号位的判断重点：把符号位初始化为 1，如果为 '+'，则为 1； 如果为 '-'，则为 -1。
	 * 		在输出的结果字符串中，每次都加入符号位：res = res * 10 + sign * (currChar - '0')
	 * @param s  输入的字符串
	 * @return	 返回取出的数字
	 */
    public int myAtoi(String s) {
		// 将字符串转换成字符数组
		char[] chars = s.toCharArray();
		int index = 0;
		int len = s.length();
		// 去掉前导空格
		while(index < len && chars[index] == ' ') {
			index++;
		}
		
		// 极端情况：s = "          "
		if(index == len) {
			return 0;
		}
		
		// 符号位的判断*****
		int sign = 1;
		char firstChar = chars[index];
		if(firstChar == '+') {
			index++;
		}else if(firstChar == '-') {
			index++;
			sign = -1;
		}
		
		// 出现字符，判断字符是否是数字字符
		int res = 0;
		while(index < len) {
			char currChar = chars[index];
			// 字符不是数字字符的情况
			if(chars[index] > '9' || chars[index] < '0') {
				break;
			}
			
			// 判断得到的结果res是否大于2^31-1，如果大于，转成最大整数
			if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && currChar - '0' > Integer.MAX_VALUE % 10)) {
				return Integer.MAX_VALUE;
			}
			if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && currChar - '0' > -(Integer.MIN_VALUE % 10))) {
				return Integer.MIN_VALUE;
			}
			res = res * 10 + sign * (currChar - '0');
			index++;
		}
		return res;
    }
}