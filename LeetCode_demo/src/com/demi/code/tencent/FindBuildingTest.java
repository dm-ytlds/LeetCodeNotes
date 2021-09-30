package com.demi.code.tencent;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？
 * （当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 */

public class FindBuildingTest {
    public static void main(String[] args) {
        // 自定义参数输入
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] heightss = s.split(",");

        int heights[] = new int[heightss.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(heightss[i]);
        }
        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(findBuilding(heights)));
    }


    public static int[] findBuilding(int[] heights) {
        // 从左边看
        // 用栈来存储楼的高度。如果当前楼的高度大于栈顶楼的高度，则删除栈顶元素
        // 如果当前楼的高度小于栈顶楼的高度，则将高高度添加到栈中，形成新的栈顶元素
        Stack<Integer> stackL = new Stack<>();
        // 用一个数组存储每个位置能够看到的楼的个数
        int res[] = new int[heights.length];
        // 从每个位置。至少能看到一栋楼。初始化每个位置的值为1
        Arrays.fill(res, 1);
        for (int i = 0; i < heights.length - 1; i++) {
            while (!stackL.isEmpty() && heights[i] >= stackL.peek()) {
                stackL.pop();
            }
            stackL.push(heights[i]);
            // 通过while循环把比当前楼低的都去掉，所以栈里剩下的都比当前楼高
            // 也就是说，当我站在该楼(i)的右边一栋楼(i+1)，栈里的楼我都能看到
            res[i + 1] += stackL.size();
        }

        // 从右边看
        Stack<Integer> stackR = new Stack<>();
        for (int i = heights.length - 1; i > 0; i--) {
            while (!stackR.isEmpty() && heights[i] >= stackR.peek()) {
                stackR.pop();
            }
            stackR.push(heights[i]);
            res[i - 1] += stackR.size();
        }
        return res;
    }
}
