package com.demi.strings;

import java.util.*;

public class HJ30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character, Integer> charMatchNum = new HashMap<>();
        charMatchNum.put('A', 10);
        charMatchNum.put('a', 10);
        charMatchNum.put('B', 11);
        charMatchNum.put('b', 11);
        charMatchNum.put('C', 12);
        charMatchNum.put('c', 12);
        charMatchNum.put('D', 13);
        charMatchNum.put('d', 13);
        charMatchNum.put('E', 14);
        charMatchNum.put('e', 14);
        charMatchNum.put('F', 15);
        charMatchNum.put('f', 15);

        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            // 将链各个字符串合并成一个字符串
            String s = strs[0].concat(strs[1]);
            // 对字符串进行排序
            // 取出奇偶位置处的字符
            ArrayList<Character> odeChars = new ArrayList<>();
            ArrayList<Character> eveChars = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    // 奇
                    odeChars.add(s.charAt(i));
                } else {
                    // 偶
                    eveChars.add(s.charAt(i));
                }
            }
            // 分别对奇偶做排序
            Collections.sort(odeChars);
            Collections.sort(eveChars);
            // 排序后重新组合  先偶后奇
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < eveChars.size(); i++) {
                sb.append(eveChars.get(i));
                if (i < odeChars.size()) {
                    sb.append(odeChars.get(i));
                }
            }
            char[] chars = sb.toString().toCharArray();
            // System.out.println(chars);
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    // 数字型 直接转换成2进制 再翻转
                    res.append(num2Reverse( chars[i] - '0'));
                } else if ((chars[i] >= 'A' && chars[i] <= 'F') || (chars[i] >= 'a' && chars[i] <= 'f')) {
                    // A~F a~f 之间的字符
                    int num = charMatchNum.get(chars[i]);
                    res.append(num2Reverse(num));
                } else {
                    res.append(chars[i]);
                }
            }
            System.out.println(res.toString());
        }
    }

    /**
     将十进制的数字转换成二进制
     */
    private static char num2Reverse (int num) {

        HashMap<Integer, Character> numMatchChar = new HashMap<>();
        numMatchChar.put(0, '0');
        numMatchChar.put(1, '1');
        numMatchChar.put(2, '2');
        numMatchChar.put(3, '3');
        numMatchChar.put(4, '4');
        numMatchChar.put(5, '5');
        numMatchChar.put(6, '6');
        numMatchChar.put(7, '7');
        numMatchChar.put(8, '8');
        numMatchChar.put(9, '9');
        numMatchChar.put(10, 'A');
        numMatchChar.put(11, 'B');
        numMatchChar.put(12, 'C');
        numMatchChar.put(13, 'D');
        numMatchChar.put(14, 'E');
        numMatchChar.put(15, 'F');
        // 数字 0~15 换算成2进制最多只占4个bit
        StringBuilder sb = new StringBuilder();
        int flag = 1 << 3;
        for (int i = 0; i < 4; i++) {
            sb.append((flag & num) == 0 ? 0 : 1);
            num <<= 1;
        }
        // 将二进制字符串翻转
        String s = sb.reverse().toString();
        // 将翻转后的二进制转换成新的十进制字符
        int n = 0;
        for (int i = 0; i < 4; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                n += Math.pow(2, 3 - i);
            }
        }
        return numMatchChar.get(n);
    }
}
