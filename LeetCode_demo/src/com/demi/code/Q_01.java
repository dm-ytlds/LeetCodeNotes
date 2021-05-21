package com.demi.code;

import java.util.HashMap;
import java.util.Map;
/*题目：
    给定一个整数数组nums和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。

示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class Q_01 {
    /**
     * 测试用例
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Q_01 a = new Q_01();
        int[] result = a.twoSum02(nums, target);
        for(int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 方法1：暴力枚举
     * 最容易想到的方法是枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
     * 当我们使用遍历整个数组的方式寻找 target - x 时，需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，
     * 因此不需要再进行匹配。而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x。
     * @param nums 数组
     * @param target 目标值
     * @return 目标值对应数组中两数求和的下标
     */
    public int[] twoSum01(int[] nums, int target) {
         // 初始化一个数组a，存放数组下标
         int[] a = new int[2];
         int len = nums.length;
         // 遍历数组
         for(int i = 0; i < len; i++) {
             for(int j = i + 1;j < len; j++) {
                 if((nums[i] + nums[j]) == target) {
                     a[0] = i;
                     a[1] = j;
                     break;
                 }
             }
         }
         return a;
    }

    /**
     * 方法2：哈希表求解
     * 注意到方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素。
     * 如果存在，我们需要找出它的索引。
     * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。
     * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
     * @param nums 数组
     * @param target 目标值
     * @return 目标值对应数组中两数求和的下标
     */
    public int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashmap.containsKey(target- nums[i])){
                return new int[] {hashmap.get(target- nums[i]), i};
            }
            hashmap.put(nums[i], i);
        }
        return new int[0];
    }
}
