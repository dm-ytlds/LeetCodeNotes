package com.demi.code;

import java.util.Arrays;

public class Q_48 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int[] nums : matrix) {
            System.out.println(Arrays.toString(nums));
        }
    }

    /**
     * 几个注意的地方：
     *  (1) 水平翻转只需要对折即可，即行只需要遍历一半；
     *  (2) 沿着主对角线翻转，列数col的终止条件是行数row；
     *  (3) 每一次遍历，先将row或col加1会大大提升执行结果的效果，减少内存消耗。
     *     *****调优考虑的方向之一。*****
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        // 先将二维矩阵水平翻转
        for (int row = 0; row < matrix.length / 2; ++row) {
            for (int col = 0; col < matrix[0].length; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - 1 - row][col];
                matrix[matrix.length - 1 - row][col] = temp;
            }

        }
        /*// test
        for (int[] nums : matrix) {
            System.out.println(Arrays.toString(nums));
        }*/
        // 在沿着主对角线翻转
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < row; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}
