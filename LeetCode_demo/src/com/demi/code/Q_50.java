package com.demi.code;

public class Q_50 {
    public static void main(String[] args) {
        double x = 2.10000;
        int n = 3;
        System.out.println(myPow(x, n));
    }

    /**
     * 解题思路：
     *  大体上来说：分指数为正整数和负整数：
     *      (1) 如果初始指数为负整数，第一次将底数的倒数和负整数的正整数形式返回给myPow()方法。
     *          目的：将指数转换成正整数，统一后面的计算方式。
     *          原理：某数的负次方 = 某数的倒数的正次方。
     *      (2) 正整数的指数又分为奇数和偶数次方。
     *          处理方式：奇数次方 = 底数 * 偶数次方。比如：2^5 = 2 * 2^4。
     *                  偶数次方 = (上一个偶数次方)的平方。比如： 2^4 = (2^2)^2 = ((2)^2)^2
     *          迭代次数：奇数次方：(n - 1) / 2 + 1 (对应代码：myPow(x, n - 1) * x;)
     *                  偶数次方：n / 2 (对应代码：myPow(x * x, n / 2);)
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        // 递归实现
        // 排除一般的情况
        // 指数超出整数int的最小值
        if (n == Integer.MIN_VALUE) {
            return (x == 1 || x == -1) ? 1 : 0;
        } else if (n == 0)
            // 指数为0的情况
            return 1;
        // 指数小于0的情况：放进myPow()方法的是底数的倒数，指数的正数形式-n
        if (n < 0)
            return myPow(1/ x, -n);
        // 下面是指数为正整数的情况
        // 偶数的情况
        if (n % 2 == 0)
            return myPow(x * x, n / 2);
        else
            // 奇数的情况：提出一个底数，剩下的就按偶数的情况处理
            return myPow(x, n - 1) * x;
    }
}
