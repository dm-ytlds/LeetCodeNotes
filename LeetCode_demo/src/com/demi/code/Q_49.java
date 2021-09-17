package com.demi.code;

import java.util.*;

/**
 * 题目：字母异位词分组
 *
 */
public class Q_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = group02(strs);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    /**
     * 采用的方式：对字符串数组中的字符串排序，作为map集合的键，如果排序后的结果在map集合中存在，则将该字符串放在该键对应的列表里。
     * 执行用时：7 ms, 在所有 Java 提交中击败了75.17%的用户；
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了83.96%的用户。
     * @param strs
     * @return
     */
    public static List<List<String>> group01(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> values = map.getOrDefault(key, new ArrayList<>());
            values.add(str);
            map.put(key, values);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 采用的方式：由于互为异位词的两个字符串包含的字母相同，因此像个字符串中的相同字母出现的次数也是相同的，
     * 故可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
     * 总共26个字母，构建一个计数数组，记录每个字母出现的次数。
     * 执行用时：9 ms, 在所有 Java 提交中击败了39.85%的用户；
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了20.63%的用户。
     * @param strs
     * @return
     */
    public static List<List<String>> group02(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            // 计算出每个字符串对应字母数组上的个数
            for (int i = 0; i < str.length(); i++) {
                // 每一个字母的初始个数都为0，且字母a对应下标0位置上的个数，b对应下标1位置上的个数，以此类推。
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数>0的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            // 生成键的过程。键的只要特质：保证唯一性。为了确保唯一性，将字母和数字拼接成键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char)('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> values = map.getOrDefault(key, new ArrayList<>());
            values.add(str);
            map.put(key, values);
        }
        return new ArrayList<>(map.values());
    }
}
