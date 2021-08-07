package com.demi.code;

/**
 * 归类：数组
 * 寻找两个正序数组的中位数
 */
public class Q_04_me {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        double mid = midNum(a, b);
        System.out.println(mid);
    }

    public static double midNum(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 考虑有一个数组为空的情况
        if (len1 == 0) {
            return getMid(nums2);
        }
        if (len2 == 0) {
            return getMid(nums1);
        }

        int[] nums = new int[len1 + len2];
        while (k != (len1 + len2)) {
            // 如果nums1遍历结束，nums2没遍历结束
            if (i == len1) {

                while (j != len2) {
                    nums[k++] = nums2[j++];
                }
                break;
            }
            // 如果nums2遍历结束，nums1没遍历结束
            if (i == len1) {

                while (j != len2) {
                    nums[k++] = nums2[j++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        // 找中位数
        return getMid(nums);
    }

    public static double getMid(int[] nums) {
        int len = nums.length;
        double mid;
        if (len % 2 == 0) {
            int temp = len / 2;
            mid = (double) (nums[temp - 1] + nums[temp]) / 2;
        } else {
            int temp = len / 2;
            mid = nums[temp];
        }
        return mid;
    }
}
