// package com.demi.code;

/*
  题目要求：
	给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
	使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

	注意：答案中不可以包含重复的三元组。
	
	示例 1：
	输入：nums = [-1,0,1,2,-1,-4]
	输出：[[-1,-1,2],[-1,0,1]]
	
	示例 2：
	输入：nums = []
	输出：[]
	
	示例 3：
	输入：nums = [0]
	输出：[]

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/3sum


*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_15 {
	public static void main(String[] args) {
		
	}
	/*
	  题解：
		用双指针从头尾遍历，可以降低时间复杂度。
		如果暴力枚举，需要三层循环，而在一次循环中，套用双指针，就可以省去第三次循环。
		时间复杂度：O(n^2);
		空间复杂度：O(1)。
	*/
	public List<List<Integer>> threeSum(int[] nums) {
		// 双指针：头尾指针
		int len = nums.length;
		// 列表套列表
		List<List<Integer>> ans = new ArrayList();
		if(nums == null || len < 3)
			return ans;
		// 对数组排序
		Arrays.sort(nums);
        for(int i = 0; i < len; i ++) {
			// 排序后，如果第一个元素就比1大，那么结果肯定不小于1
            if(nums[i] > 0)
				break;
			// 去除重复的数字
			if(i > 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = len - 1;
			
			// 左指针小于右指针
			while(left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if(sum == 0) {
					List<Integer> list = new ArrayList();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					ans.add(list);
					while(nums[left] == nums[left + 1])
						left ++;
					while(nums[right] == nums[right - 1])
						right --;
				}
				else if(sum < 0) {
					left ++;
				}
				else {
					right --;
				}
			}
			
        }
		return ans;
    }
	
}