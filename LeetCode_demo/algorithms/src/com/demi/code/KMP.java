package com.demi.code;

public class KMP {
    public static void main(String[] args) {
        String src = "aaaaab";
        String sub = "aab";
        int[] next = KMP.getNext(sub);
        for (int i : next) {
            System.out.println(i);
        }
        System.out.println("---------------");
        int index = KMP.kmp(src,sub);
        System.out.println(index);
        // 得到匹配的子串
        System.out.println(src.substring(index));
    }

    /**
     * 根据给定的主串和子串，采用KMP算法来获取模式匹配。
     * @param str
     * @param subStr
     * @return
     */
    public static int kmp(String str, String subStr) {
        // 部分匹配表（模式匹配）生成
        int[] next = getNext(subStr);
        int i = 0, j = 0, index = -1;
        while (i < str.length() && j < subStr.length()) {
            if (str.charAt(i) == subStr.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }

        // 得到开始匹配时的位置索引
        if (j == subStr.length()) {
            index = i - subStr.length();
        }
        return index;
    }

    private static int[] getNext(String subStr) {
        // 初始化子串下标，以及next数组的初始值
        int j = 1, k = 0;
        // 存储next数组，即模式匹配（部分匹配）表
        int[] next = new int[subStr.length()];
        next[0] = -1;  // 人为规定
        next[1] = 0;   // 规定

        // 遍历整个子串的字符
        while (j < subStr.length() - 1) {
            // 讨论j位置处的字符是否和k位置处的字符相等
            /*
                若相等，说明
             */
            if (subStr.charAt(j) == subStr.charAt(k)) {
                next[j + 1] = k + 1;
                j++;
                k++;
            } else if (k == 0) {
                next[j + 1] = 0;
                j++;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
