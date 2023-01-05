package com.demi.code;

/**
 *
 *
 */
public class Q_151 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        // 1 去除首尾以及中间多余空格
        chars = removeExtraSpaces(chars);
        // 2 整个字符串反转
        reverse(chars, 0, chars.length - 1);
        // 3 单词反转
        reverseEachWord(chars);
        return new String(chars);
    }

    /**
     * 单词反转
     * @param chars 字符数组
     */
    private void reverseEachWord(char[] chars) {
        int start = 0;
        // 之所以end可以等于chars.length，是为了让 end 永远指向单词末尾后一个位置，这样reverse的实参更好设置
        for (int end = 0; end <= chars.length; end++) {
            // 遇到空格或者到字符串尾部，开始反转单词
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
    }

    /**
     * 双指针实现指定范围内字符串反转
     * @param chars 字符数组
     * @param left 左指针
     * @param right 右指针
     */
    private void reverse(char[] chars, int left, int right) {
        if (right >= chars.length) {
            return;
        }
        while (left < right) {
            // 位运算实现字符交换
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }

    /**
     * 用快慢指针去除首尾所有空格以及中间多余的空格
     * @param chars 字符串组
     * @return 返回去除空格后的字符数组
     */
    private char[] removeExtraSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            // 先用fast移除所有空格
            if (chars[fast] != ' ') {
                // 再用slow加空格。除去第一个单词外，单词末尾要加空格
                if (slow != 0) {
                    chars[slow++] = ' ';
                }
                // fast遇到空格或遍历到字符串末尾，就证明遍历完一个单词了
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }

            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }
}
