package com.demi.code;

/** 题目：移除元素
 *  题目描述：给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *  不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *  元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *  示例 1：
 *      输入：nums = [3,2,2,3], val = 3
 *      输出：2, nums = [2,2]
 *      解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 *  示例 2：
 *      输入：nums = [0,1,2,2,3,0,4,2], val = 2
 *      输出：5, nums = [0,1,4,0,3]
 *      解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 */
public class Q_27 {
    public static void main(String[] args) {

    }

    /**
     *  解题思路：
     *      题目要求删除数组中等于val的元素，因此输出的数组长度一定小于等于输入数组的长度，我们可以把输出的数组直接写在输入数组上。
     *      使用双指针：右指针right用来指向当前将要处理的元素，左指针left指向下一个将要赋值的位置。
     *          如果右指针指向的元素不等于val, 他一定是输出数组的一个元素，我们将右指针指向的元素复制到左指针位置，然后将左右指针同时向右移动；
     *          如果右指针指向的元素等于val，它不能再输出数组里，此时左指针不动，右指针右移一位。
     *      整个过程保持不变的性质是：区间 [0,\textit{left})[0,left) 中的元素都不等于 \textit{val}val。当左右指针遍历完输入数组以后，\textit{left}left 的值就是输出数组的长度。
     *
     *  作者：LeetCode-Solution
     *  链接：https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode-solution-svxi/
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // 双指针
        // 左指针left用来记录删除元素后，数组还剩的元素个数
        // 右指针right用来遍历整个数组元素
        int len = nums.length;
        int left = 0;
        for (int right = 0; right < len; right++) {

            // 如果右指针指向的元素不等于val，它一定是输出数组的一个元素，我们就将右指针指向的元素复制到左指针位置，然后将左右指针同时右移；
            if(nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            //如果右指针指向的元素等于val，它不能在输出数组里，此时左指针不动，右指针右移一位。
        }
        return left;
    }
}
