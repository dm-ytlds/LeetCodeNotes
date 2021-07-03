package src.com.algorithms;

import java.util.List;


/**
 * 列举字符串的全排列
 * 示例：
 *  s = "abc"
 *  找出s的全排列：
 *  abc, acb, bac, bca, cba, cab
 */
public class demo02 {
    public static void main(String[] args) {

    }

    /**
     * str[] 里的每一个值都有机会来到i位置
     * i终止位置，就是其中一种结果 。返回到ans中
     */
    public static void process(char[] str, int i, List<String> ans) {
        // 如果i已经遍历到字符串的最后一个字符，则遍历终止
        if (i == str.length) {
            ans.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, ans);
                swap(str, i ,j);
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
    }
}
