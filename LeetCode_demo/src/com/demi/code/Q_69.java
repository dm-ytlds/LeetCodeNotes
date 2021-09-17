package com.demi.code;

/**
 * 题目：x的平方根
 *  其中，x为非负整数。返回整数部分即可。
 *
 */
public class Q_69 {
    public static void main(String[] args) {
        int x =  16;
        System.out.println(mySqrt02(x));
    }

    /**
     * 自己的方法。太low了。
     * @param x
     * @return
     */
    public static int mySqrt01(int x) {
        int res = 0;
        if (x == 0) return res;
        if (x > 0 && x < 4) return res + 1;
        if (x > Integer.MAX_VALUE) return 46340;
        for (int i = 2;; i++) {
            int temp = i * i;
            if (temp < x) {
                continue;
            } else if (temp == x){
                res = i;
                break;
            } else {
                res = i - 1;
                break;
            }
        }
        return res;
    }

    /**
     * 尝试二分查找
     *
     * l + (r - l + 1) / 2; 保证每一次都是在靠右的区间值，并且返回的left就是所求平方根
     */
    public static int mySqrt02(int x) {
        if (x == 0)
            return 0;
        int l = 1, r = x / 2;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}
