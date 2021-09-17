package com.demi.code;

/**
 * 题目：二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 */
public class Q_67 {
    public static void main(String[] args) {
        String a = "1001";
        String b = "1101";
        System.out.println(addBinary(a, b));
    }

    /**
     * 二进制求解：遇二进一。
     * 需要注意的是：数字型字符转换成对应的数字，只需要 - '0'，相应的字母型字符转换成数字，只需要 - 'a'是一样的道理。
     * 解题巧妙之处：在计算时，将较短的字符串前面补0来进行计算，所以遍历的次数为较长字符串的长度。
     *            将求和变量放在循环体，初始化为进位数值：这样的话，不管有没有进位，都加上了进位数值。
     *            用StringBuilder拼接每一次得到的结果。注意：拼接每次都是追加在后面，所以结果是反序的，需要reverse()一下。
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            // 此处的sum为每次两个位置的数相加的和，初始化为carry的妙处：如果有进位，则加上进位值。
            int sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        ans.append(carry == 1 ? carry : "");
        // append里面处理的都是String字符串，进去的字符串顺序都是追加在后面，所有是反序的。
        return ans.reverse().toString();
    }
}
