package com.demi.code;

/**
 * 题目：字符串相乘
 *  给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *  输入: num1 = "2", num2 = "3"
 *  输出: "6"
 *
 * 示例 2:
 *  输入: num1 = "123", num2 = "456"
 *  输出: "56088"
 * 说明：
 *  num1和num2的长度小于110。
 *  num1和num2只包含数字0-9。
 *  num1和num2均不以零开头，除非是数字 0 本身。
 *  不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

 */
public class Q_43 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "24";
        String res = multiplyForStr(num1, num2);
        System.out.println(res);
    }

    /**
     * 数组
     *  知识点引入：
     *      两数相乘的位数区间：令 m 和 n 分别表示 num1 和 num2的位数，并且均不为0，则num1 和 num2的乘积的位数为 m + n - 1 或 m + n。
     *
     *  解题思路：
     *   两数相乘，num1为被乘数，num2为乘数，对于num1和num2字符串整数，外层循环为被乘数，里层循环为乘数，利用数组，将每一个对应的数值取出作乘积，
     *   对于乘积的处理如下：
     *      两数相乘得到的十位数值放在前一个
     *      arr[i - 1] += arr[i] / 10;
     *      两数相乘得到的个位数值放在当前位置
     *      arr[i] %= 10;
     *   每一次的乘积都做相同的处理即可。
     *   注意：这里有一个数组首位字符的处理。
     *   最后将得到的数组转换成字符串(StringBuilder的toString方法可实现)。
     * @param num1
     * @param num2
     * @return
     */
    public static String multiplyForStr(String num1, String num2) {
        // 有一个字符串中的数字为0的情况
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] arr = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                arr[i + j + 1] += x * y;
            }
        }

        // 处理数组中的值
        // 注意：这里的越界条件为 i > 0.因为下标有 i - 1
        for (int i = len1 + len2 - 1; i > 0; i--) {
            // 两数相乘得到的十位数值放在前一个
            arr[i - 1] += arr[i] / 10;
            // 两数相乘得到的个位数值放在当前位置
            arr[i] %= 10;
        }
        // 转换成数组
        // 首先判断数组中的第一位数字是否为0
        // 为0就从数组的第1个元素开始遍历
        // 不为0就从数组的第0个元素开始遍历
        int index = arr[0] == 0 ? 1 : 0;
        StringBuffer res = new StringBuffer();
        while (index < len1 + len2) {
            res.append(arr[index]);
            index++;
        }
        return res.toString();
    }
}
