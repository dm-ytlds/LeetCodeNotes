package com.demi.code;

/**
 * 归类：数组
 * 题目：盛最多水的容器
 */
public class Q_11_me {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int max = maxArea(nums);
        System.out.println(max);
    }

    /**
     * 双指针？
     * 左指针指向第一个元素，右指针指向最后一个元素，
     * 初始化一个结果值，选择每一次移动得到的较小元素 * (right - left)得到当前的面积值；
     * 比较每一次的面积值，选出较大的值作为最终的面积值；
     * 比较元素数字的大小，移动较小的元素对应的指针，直到left和right不满足left < right为止。
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        // 初始化最终的结果
        int res = 0;
        while (left < right) {
            // 选择左右数字中较小的值作为面积衡量的标准
            int temp = Math.min(height[left], height[right]) * (right - left);
            // 将每一次比较得到的较大值作为面积的结果输出
            res = Math.max(res, temp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return res;
    }
}
