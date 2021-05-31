package com.demi.code;

/**
 * 题目要求：
 * 	给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 示例 2：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class Q_11 {
	public static void main(String[] args){
		int[] h = {1,8,6,2,5,4,8,3,7};
		Q_11 qus = new Q_11();
		int res = qus.maxArea(h);
		System.out.println(res);
	}

	/**
	 * 双指针
	 *	第一遍，没想到双指针，每次循环都和前一个结果作比较，就不需要单独的数组来存储结果了。
	 *
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		// 左指针
		int left = 0;
		// 右指针
		int right = height.length - 1;
		// 结果初始化
		int res = 0;

		// 判断条件得是左指针小于右指针
		while(left < right) {
			// 水槽的实际高度由两板中的短板决定，
			int ans = Math.min(height[left], height[right]) * (right - left);
			res = Math.max(res, ans);
			// 每次都移动数字较小的那边
			if(height[left] < height[right]) {
				left++;
			}else {
				right--;
			}
		}

		return res;
    }
}