package com.demi.code;

/**
 * 题目：外观数列
 * 要求：给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 */
public class Q_38 {
    public static void main(String[] args) {
        String res = countAndSay(4);
        System.out.println(res);
    }

    /**
     *  首先找出基本样例：n == 1的情况；
     *  根据每一次得到的String结果集res，将res的第一个字符作为初始化字符currFirstChar，并且初始化该字符的个数currCharCount，
     *  然后遍历整个结果集res，如果当前字符currFirstChar等于ch，当前字符的个数currCharCount + 1，否则将当前字符及其个数放进实现创建的StringBuffer字符串currNumChars中，
     *  (注意：按照题目要求，先放数量，在放字符。)并且更新当前字符串为ch（currFirstChar = ch），及其个数更新为1（currCharCount = 1）。
     *  内层循环结束后，注意：最后一个字符也需要放进currNumChars中去，别忘了。更新res结果集为currNumChars.toString()。
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        // n = 1的时候，属于基本样例
        if (n == 1) {
            return "1";
        }
        // 将最基本的样例存入结果字符串res中
        String res = "1";
        //
        for (int i = 0; i < n - 1; i++) {
            // 创建一个StringBuffer对象
            StringBuffer currentCombinedStr = new StringBuffer();
            // 取出结果集中的第一个字符
            char currFirstChar = res.charAt(0);
            // 初始化当前字符的个数currentCharCount
            int currentCharCount = 0;
            // 遍历结果集中的所有字符
            for (char ch : res.toCharArray()) {
                if (ch == currFirstChar)
                    currentCharCount += 1;
                else {
                    // 先将当前字符的个数存进串中
                    currentCombinedStr.append(currentCharCount);
                    // 再将当前字符放进去
                    currentCombinedStr.append(currFirstChar);

                    // 更新当前字符以及当前字符的个数
                    currFirstChar = ch;
                    currentCharCount = 1;
                }
            }

            // 做一个最后字符及其个数的处理
            currentCombinedStr.append(currentCharCount);
            currentCombinedStr.append(currFirstChar);
            res = currentCombinedStr.toString();
        }
        return res;
    }
}
