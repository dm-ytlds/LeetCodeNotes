package com.demi.strings;

import java.util.Scanner;

public class HJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            if (str.contains(".")) {
                System.out.println(ip2Num(str));
            } else {
                System.out.println(num2Ip(Long.parseLong(str)));
            }
        }
    }

    /**
     ip地址转成10进制数
     */
    private static Long ip2Num(String ip) {
        String[] strs = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int ipNum = Integer.valueOf(str);
            // 十进制数字转为二进制
            int flag = 1 << 7;
            for (int i = 0; i < 8; i++) {
                sb.append((flag & ipNum) == 0 ? 0 : 1);
                ipNum <<= 1;
            }
        }
        return Long.parseLong(sb.toString(), 2);
    }

    /**
     10进制IP地址转为ip字符串
     */
    private static String num2Ip(long num) {
        // 转换成2进制
        String newNum = Long.toBinaryString(num);
        // 处理一下二进制数长度问题
        while (newNum.length() < 32) {
            newNum = "0" + newNum;
        }
        StringBuilder sb = new StringBuilder();
        String[] ans = new String[4];
        for (int i = 0; i < 4; i++) {
            String s = newNum.substring(8 * i, 8 * i + 8); //将32位2进制拆分为4段
            s = Integer.toString(Integer.parseInt(s, 2));  //2进制转化为10进制
            ans[i] = s;
        }
        return String.join(".", ans);  //拼接
    }
}
