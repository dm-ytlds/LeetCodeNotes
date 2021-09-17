package com.demi.code.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目；格雷编码
 */
public class Q_89 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.toString(grayCode(n).toArray()));
    }

    /**
     * 镜像反射法
     * 思路：
     *  设n阶格雷码集合为G(n)，则G(n+1)阶格雷码为：
     *      给G(n)阶格雷码每个元素二进制形式前面添加0，得到G`(n)；
     *      设G(n)集合的倒序（上下镜像）为R(n)，给R(n)每个元素二进制形式前面添加1，得到R`(n)；
     *      G(n+1)=G`(n) ∪ R`(n)拼接两个结合即可得到下一阶格雷码。
     * 代码分析：
     *  由于最高位默认为0，因此G`(n)=G(n)，只需要在res后添加R`(n)即可；
     *  计算R`(n)：执行head = 1 << i 计算得出对应位数，便于给R(n)前添加1得到对应的R`(n)；
     *  倒序遍历res（即G(n)）：一次求得R`(n)各元素，添加至res尾端，遍历完成后res即为所求。
     * @param n
     * @return
     */
    public static List<Integer> grayCode(int n) {
        // 存储最终结果集。必须以0开头，所以先加一个0
        List<Integer> res = new ArrayList<>(){{add(0);}};
        // 初始增加值。最开始在最右边，随着结果集的遍历结束，向左移一位，直到n为止。
        int head = 1;
         for (int i = 0; i < n; i++) {
             for (int j = res.size() - 1; j >= 0; j--) {
                 // 内层遍历倒序，且终止条件是结果集的长度为0为止
                 res.add(head + res.get(j));
             }
             // 内层遍历完一次，该头指针左移一位。
             head <<= 1;   // 左移一位，相当于乘2
             System.out.println(head);
         }
         return res;
    }
}
