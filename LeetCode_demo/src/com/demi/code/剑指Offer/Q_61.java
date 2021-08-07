package com.demi.code.剑指Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 归类：数组
 * 题目：扑克牌中的顺子
 *
 */
public class Q_61 {
    public static void main(String[] args) {
        Solution qus = new Solution();
        int[] nums = {0, 0, 1, 2, 5};
        boolean isRight = qus.isStraight(nums);
        System.out.println(isRight);
    }
}

class Solution {
    /**
     * 思路：首先想到一个集合，保存不重复的数字，如果有重复，数组直接不可能连续。
     *      然后因为大小王即0，可以为任意数字，也就是说，在遍历数组的时候，可以当0不存在，遇到了直接continue，
     *      通过分析也可以发现：对于本题来说，规定了数组长度为5，假如有两个0（最多两个），数组中数字的最大值与最小值的差值不能大于4，
     *      大于4就不可能组成连续的5个数。
     * 注意：两点：(1) 集合的使用；(2) 分析出最大最小值之差。（本题为不大于4才有意义。）
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        // 定义一个数字集合,保存不重复的数字
        Set<Integer> noRepeat = new HashSet<>();
        // 最大值初始化时尽可能的小，保证在交换的时候尽可能交换到大的值
        int max = 0;
        // 最小值初始化时尽可能的大，保证在交换的时候尽可能交换到小的值
        int min = 14;

        for (int num : nums) {
            // 遇到0，就继续遍历
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            // 如果集合中存在该数字了，直接就不可能连续了，返回false。
            if (noRepeat.contains(num)) {
                return false;
            }
            noRepeat.add(num);
        }
        // 如果最大值与最小值之差大于4，总共就两个可以为任意数字的牌，
        // 去掉一个介于最大最小值之间的数，怎么都不能凑成连续的数字串
        // 所以，只有在最大最小之差小于5的情况下才可能连续，否则不连续。
        return (max - min) < 5;
    }
}
