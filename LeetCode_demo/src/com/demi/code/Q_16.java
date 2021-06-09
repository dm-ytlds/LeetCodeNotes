package com.demi.code;

/*
  题目：最接近的三数之和
	给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
	找出 nums 中的三个整数，使得它们的和与 target 最接近。
	返回这三个数的和。假定每组输入只存在唯一答案。

	示例：
		输入：nums = [-1,2,1,-4], target = 1
		输出：2
		解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/3sum-closest

*/

public class Q_16 {
	public static void main(String[] args) {
		// 测试用例
	}
	// 自己想的方法：
	// 	运行结果：超出时间限制
	public int threeSumClosest01(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int len = nums.length;
        // 存储所有的三数之和 sum 与 target 的差值
        List<Integer> ress = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            int l = i + 1;
            int r = len - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                ress.add(sum - target);
				l++;
				r--;
            }
        }
		// 循环遍历得到最小的值
        int res = ress.get(0);
        for(int j = 1; j < ress.size(); j++) {
            if(res > ress.get(j))
                res = ress.get(j);
        }
        return res;
    }
	
	// 官方解答
	/*
		解题思路：
			先对整个整数数组进行排序。
			然后对整个数组进行一次外循环。
			在外循环中使用双指针来减少一次循环（如果按照暴力枚举的方式，就是3层循环，
			而使用双指针的话，就可以将两层内循环变成一次循环）。
			注意：每一次循环中，都需要对重复值进行筛选，因为重复值对和的计算没有意义，
			只会增加计算时间。
	*/
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		// store best answer
		int bestAns = 10000;
		// 循环一遍（外循环）
		for(int i = 0; i < len; ++i) {
			// 用++i，然后判断的时候，用i和i - 1的值作比较，避免指针越界
			if(i > 0 && nums[i] == nums [i - 1]) {
				continue
			}
			// 使用双指针
			int l = i + 1;
			int r = len - 1;
			while(l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if(sum == target) {
					return target;
				}
				if(Math.abs(sum - target) < Math.abs(bestAns - target)) {
					bestAns = sum;
				}
				if(sum > target) {
					// 如果sum 大于target，移动右指针
					// 定义一个临时变量，方便去除右指针对应的重复值
					int r0 = r - 1;
					while(l < r0 && nums[r0] == nums[r]) {
						--r0;
					}
					r = r0;
				}else {
					int l0 = l + 1;
					while(l0 < r && nums[l0] == nums[l]) {
						++l0;
					}
					l = l0;
				}
			}
			
		}
		return bestAns;
	}
	
}