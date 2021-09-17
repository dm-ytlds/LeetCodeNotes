package com.demi.code;

/**
 * 归类：字符串
 * 题目：最长回文子串
 * 解题方法：双指针
 */
public class Q_05_me {
    public static void main(String[] args) {
        String s = "cbbd";
        String sub = LongestCallBackSubString(s);
        System.out.println(sub);
    }

    public static String LongestCallBackSubstring(String s) {
        // 将字符串转换成字符数组，因为后面要用到字符的遍历
        // 不用s.charAt(xxx)的原因是每次调用字符串的charAt()方法太耗时。不建议使用
        char[] charsArray = s.toCharArray();
        // 存储最大子串的长度，起始值为1，因为最小就是第一个字符
        int maxLen = 1;
        // 回文子串开始的位置
        int start = 0;
        // 字符串的长度
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 双指针用双循环实现。内存遍历的开始，是外层遍历 + 1
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((j - i + 1) > maxLen && isRight(charsArray, i, j)) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * isRight 方法是用来判断是否是回文串的。
     * i和j 表示字符数组区间的首位值
     * @param charsArray
     * @param i
     * @param j
     * @return
     */
    private static boolean isRight(char[] charsArray, int i, int j) {
        while (i < j) {
            // 如果字符串对应的首位字符不相等，必不可能是回文串
            if (charsArray[i] != charsArray[j]) {
                return false;
            }
            // 否则移动指针，继续判断
            i++;
            j--;
        }
        // 直到左右指针相等（左不可能大于右），还是相等字符，则是回文串
        return true;
    }

    /**
     * 动态规划解题：五部曲
     * 1 确定dp数组以及数组下标的含义
     *      布尔类型的dp[i][j]，表示区间的范围[i, j]（左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
     * 2 确定递推公式
     *   整体上分为两种情况：
     *   (1) 当s[i]和s[j]不相等，那么dp[i][j]必为false；
     *   (2) 当s[i]和s[j]相等，有以下三种情况：
     *       a) 下标i与下标j对应的字符相同，即指向同一个字符，当然是回文串；
     *       b) 下标i与j相差为1，例如aa，当然也是回文串；
     *       c) 下标i与j相差大于1时，例如abcba，此时s[i]和s[j]已经相同了，
     *           要想直到i和j区间是不是回文子串，就需要看bcb是不是回文子串，bcb的区间就是i+1和j-1区间，
     *           要知道这个区间是不是回文，就看dp[i+1][j-1]是否为true。
     *   得出递推公式：
     *   if (s[i] == s[j]) {
     *       if (j - i <= 1) {
     *           dp[i][j] = true;
     *       } else if (dp[i + 1][j - 1]) {
     *           dp[i][j] = true;
     *       }
     *   }
     *   在得到[i, j]区间是否为回文子串时，直接保存最长回文子串的左右边界，代码如下：
     *   if (dp[i][j] && j - i + 1 > maxLen) {
     *       maxLen = j - i + 1;
     *       left = i;
     *       right = j;
     *   }
     * 3 dp数组如何初始化
     *      dp[i][j]初始化为false。即默认都不是回文子串
     * 4 确定遍历顺序
     *      首先从递推公式中可以看出，情况三是根据dp[i + 1][j - 1]是否为true，在对dp[i][j]进行赋值true的。
     *      dp[i + 1][j - 1] 在 dp[i][j]的左下角。
     *      如果这矩阵是从上到下，从左到右遍历，那么会用到没有计算过的dp[i + 1][j - 1]，也就是根据不确定是不是回文的区间[i+1,j-1]，
     *      来判断了[i,j]是不是回文，那结果一定是不对的。
     *      所以一定要从下到上，从左到右遍历，这样保证dp[i + 1][j - 1]都是经过计算的。
     *      有的代码实现是优先遍历列，然后遍历行，其实也是一个道理，都是为了保证dp[i + 1][j - 1]都是经过计算的。
     *   代码如下：
     *   for (int i = s.length() - 1; i >= 0; i--) {
     *       for (int j = i; j < s.length(); j++) {
     *           if (s[i] == s[j]) {
     *               dp[i][j] = true;
     *           } else if (dp[i + 1][j - 1]) {
     *               dp[i][j] = true;
     *           }
     *       }
     *       if (dp[i][j] && j - i + 1 > maxLen) {
     *           maxLen = j - i + 1;
     *           left = i;
     *           right = j;
     *       }
     *   }
     * @param s
     * @return
     */

    public static String LongestCallBackSubString(String s) {

        // dp[][]数组初始化
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化最长回文子串的长度
        int maxLen = 0;
        // 初始化区间的左右值
        int left = 0;
        int right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        // 指向同一个字符，即同一个字符，必是回文
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        // 如果内区间是回文，那么外区间一定也是回文
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    // [i, j]区间是回文，且长度大于最长
                    maxLen = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, maxLen);
    }
}
