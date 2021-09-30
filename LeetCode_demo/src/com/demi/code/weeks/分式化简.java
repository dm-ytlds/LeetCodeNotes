package com.demi.code.weeks;

import java.util.Arrays;

public class 分式化简 {
    public static void main(String[] args) {
        int nums[] = {3, 2, 1};
//        reverse(nums);
        System.out.println(Arrays.toString(nums));
        //System.out.println(gcd(4, 8));
        System.out.println(Arrays.toString(fraction(nums)));
    }

    /**
     * 题解：
     *  将原数组逆序过后发现，第i轮实际上是对a[i] + c / d的式子进行通分、化简、取倒数。得到的结果将作为第 i + 1 轮的 c / d。
     * @param nums
     * @return
     */

    private static int[] fraction(int[] nums) {
        reverse(nums);
        // 初始化c和d（c为分子，d为分母）
        int c = 1, d = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            /* 通分：a[i] + c / d = (a[i] * d + c) / d
                所以new_c = a[i] * d + c;
                   new_d = d;
            */
            int new_c = nums[i] * d + c;
            int new_d = d;

            // 将c / d化简成最简分数
            // 首先找出最大公约数g
            int g = gcd(new_c, new_d);
            // 将分子分母同除以最大公约数g，得到最简分数
            new_c /= g;
            new_d /= g;

            // 取倒数，赋值给新的 c/d
            c = new_d;
            d = new_c;

        }
        // 按照上面的方式，多进行了一次取倒数操作，所以还需要交换回来。交换c d
        c = c ^ d;
        d = d ^ c;
        c = c ^ d;

        return new int[]{c, d};
    }

    /**
     * 求两数的最大公约数
     * @param m
     * @param n
     * @return
     */
    private static int gcd(int m, int n) {
        if(n==0){
            return m;
        }else{
            return gcd(n,m%n);
        }
    }

    private static void reverse(int[] nums) {
        // 双指针
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[j] ^ nums[i];
            nums[i] = nums[i] ^ nums[j];
        }

    }
}
