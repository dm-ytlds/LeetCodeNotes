package com.demi.code;

/**
 * 6.Z字形变换
 */
public class Q_06 {
    public static void main(String[] args) {
        Q_06 qus = new Q_06();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String new_s = qus.convert(s, numRows);
        System.out.println(new_s);
    }

    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        // 储存每一次按行读取的结果
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }

        // 遍历字符串时的指针
        int index = 0;
        //
        int row = 0;
        int len = s.length();
        while(index < len) {
            // 如果行数没达到规定行数
            while(index < len && row < numRows) {
                char ch = s.charAt(index++);
                res[row].append(ch);
                row++;
            }

            // 如果遍历结束
            if(index == len)
                break;

            row = numRows - 2;

            while (index < len && row >= 0) {
                char ch = s.charAt(index++);
                res[row].append(ch);
                row--;
            }

            row += 2;
        }

        // 遍历结束，输出结果
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ans.append(res[i]);
        }

        return ans.toString();
    }
}
