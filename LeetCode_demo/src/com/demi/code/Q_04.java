package com.demi.code;
import java.lang.*;

public class Q_04 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        Q_04 find = new Q_04();
        double mid = find.findMedianSortedArrays(nums1, nums2);
        System.out.println(mid);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double mid = 0.0;

        // 如果nums1为空
        if(m == 0) {
            if(n % 2 == 0) {
                int temp = n / 2;
                mid = (double) ((nums2[temp - 1] + nums2[temp]) / 2.0);
            }else {
                int temp = n / 2;
                mid = (double) nums2[temp];
            }
        }
        // 如果nums2为空
        if(n == 0) {
            if(m % 2 == 0) {
                int temp = m / 2;
                mid = (double) ((nums1[temp - 1] + nums1[temp]) / 2.0);
            }else {
                int temp = m / 2;
                mid = (double) nums1[temp];
            }
        }
        // 如果两个数组都不为空。
        int[] nums = new int[m + n];
        int i = 0, j = 0, count = 0;
        while(count != (m + n)) {
            if(i == m) {
                while(j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if(j == n) {
                while(i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if(nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            }else {
                nums[count++] = nums2[j++];
            }
        }
        // 遍历找中位数
        if(count % 2 == 0) {
            int temp = count / 2;
            mid = (double) ((nums[temp - 1] + nums[temp]) / 2.0);
        }else {
            int temp = count / 2;
            mid = (double) nums[temp];
        }
        return mid;
    }
}
