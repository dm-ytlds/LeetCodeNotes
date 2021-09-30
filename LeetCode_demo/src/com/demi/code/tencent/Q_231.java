package com.demi.code.tencent;

/**
 * 题目：2的幂
 */
public class Q_231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    static final int MAX = 1 << 30;
    public static boolean isPowerOfTwo(int n) {
        /*boolean flag = false;

        int x = 0;
        while (x++ <= n / 2) {
            if (Math.pow(x, 2) == n) {
                flag = true;
                break;
            }
        }
        return flag;*/

        // 二进制与运算的使用
        // return n > 0 && (n & (n - 1)) == 0;
        // return n > 0 && (n & (-n)) == n;
        // 是否为最大整数的约数
        return n > 0 && MAX % n == 0;


    }
}



