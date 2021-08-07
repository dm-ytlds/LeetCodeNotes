package com.demi.code;

import java.util.HashMap;

/**
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例：
 *  输入：board =
 * [['5','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * 输出：true
 */
public class Q_36 {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    /**
     * 一是判断board中，每隔三行三列二维数组中是否有重复的数字字符；
     * 一是判断整个board中，每行每列是否有重复的数字字符。
     * 怎么找到属于哪个小格子呢？
     *      公式：(row / 3) * 3 + col / 3;
     * 怎么实现判断是否有数字出现在哪个位置？
     *      用HashMap集合实现。key: value键值对的形式，key存储的是每个出现的数字，value存储每个位置上元素是否出现过，若出现过，value为1，如果下次再出现，则value + 1。
     * 怎么知道key对应的value是否有值？
     *      maps.getOrDefault(num, 0)。该函数实现在集合中寻找key为num的value值，如果找到则返回值，如果找不到，返回 0 。
     * @param board 数独板（二维数组）
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        // 行为外层循环
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        // 先进行初始化每个HashMap集合
        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        // 遍历board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                // 每一个格子里的字符
                char num = board[row][col];
                if (num != '.') {
                    // 字符不为点，就必为数字
                    // 将数字字符强转为int数字
                    int n = (int)num;
                    // 这一步是重点，确定该数字是属于哪个格子
                    // 以第0行，第5列为例：(0 / 3) * 3 + 5 / 3 = 1。所以该位置上的数字属于第1个格子。
                    int box_index = (row / 3) * 3 + col / 3;
                    // 将格子上对应的数字存入HashMap集合中
                    rows[row].put(n, rows[row].getOrDefault(n, 0) + 1);
                    cols[col].put(n, cols[col].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
                    // 验证该数字是否已经存在某一列，或某一行，或某一个小格子里
                    if (rows[row].get(n) > 1 || cols[col].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return  false;
                    }
                }
            }
        }

        return true;
    }
}
