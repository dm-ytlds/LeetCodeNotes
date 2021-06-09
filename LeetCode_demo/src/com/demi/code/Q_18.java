package com.demi.code;

/*
  题目：四数之和
	给定一个包含 n 个整数的数组 nums 和一个目标值 target，
	判断 nums 中是否存在四个元素 a，b，c 和 d ，
	使得 a + b + c + d 的值与 target 相等？
	找出所有满足条件且不重复的四元组。
	
	注意：答案中不可以包含重复的四元组。
	
	示例 1：
	输入：nums = [1,0,-1,0,-2,2], target = 0
	输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
	
	示例 2：
	输入：nums = [], target = 0
	输出：[]


	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/4sum

*/

public class Q_18 {
	public static void main(String[] args) {
		// 测试用例
	}
	
	/*
		整体思路和找三数之和是一样的。
		先双重循环，在用双指针消除一层循环，最终的时间复杂度为O(n^3)
	*/
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		if(nums == null || len < 4) {
			return res;
		}
		Arrays.sort(nums);
		for(int i = 0; i < len - 3; i++) {
			// 防止下标越界：用第i 个值和第i - 1个值做比较
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			// 如果排序后的前四个数本就大于目标值，那么就不可能存在有四个数加起来能等于目标值，
			// 所以直接结束查找
			if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
				break;
			}
			// 如果nums[i] + nums[len - 1] + nums[len -2] + nums[len - 3] < target，那么本轮就直接结束，进行下一轮循环
			if(nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
				continue;
			}
			// 第二重循环启动
			for(int j = i + 1; j < len - 2; j++) {
				if(j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
					break;
				}
				if(nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
					continue;
				}
				
				// 使用双指针，去除第四重循环
				int l = j + 1; 
				int r = len - 1;
				while(l < r) {
					int sum = nums[i] + nums[j] + nums[l] + nums[r];
					if(sum == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
						while(l < r && nums[l] == nums[l + 1]) {
							l++;
						}
						l++;
						while(l < r && nums[r] == nums[r - 1]) {
							r--;
						}
						r--;
					}
					else if(sum > target) {
						// 四数和比目标值大，说明需要找更小的数，
						r--;
					}
					else(sum < target) {
						l++;
					}
				}
			}
		}
		return res;
    }
}