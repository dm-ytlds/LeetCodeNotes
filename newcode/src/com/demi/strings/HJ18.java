package com.demi.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HJ18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 记录A类IP地址的个数
        int A = 0;
        // 记录B类IP地址的个数
        int B = 0;
        // 记录C类IP地址的个数
        int C = 0;
        // 记录D类IP地址的个数
        int D = 0;
        // 记录E类IP地址的个数
        int E = 0;
        // 记录A错误IP地址或错误掩码的个数
        int error = 0;
        // 记录私有IP的个数
        int privateIp = 0;
        while (in.hasNextLine()) {
            // 输入IP地址和掩码
            String str = in.nextLine();
            if (str == null || str.length() == 0) continue;
            // 分离出IP地址和掩码字符串
            String[] strs = str.split("~");  // strs[0]为ip，strs[1]为掩码
            String ip = strs[0];
            String mask = strs[1];
            // 判断 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
            if (ip.startsWith("0") || ip.startsWith("127")) {
                continue;
            }
            // 判断ip或掩码的段数是否为4  小于4直接在错误计数 + 1
            if (ip.split("\\.").length < 4 || mask.split("\\.").length < 4) {
                error += 1;
                continue;
            }

            // 将ip拆分
            int[] ipNums = string2int(ip);
            // 将掩码拆分
            int[] maskNums = string2int(mask);
            // 判断ip和mask中是否有数字大于255的，且掩码不符合规则的，有直接判断为error
            if (!isRightNum(ip) || !isRightMask(maskNums)) {
                error += 1;
                continue;
            }
            // 是否是A类
            if (ipNums[0] >= 1 && ipNums[0] <= 126) {
                A += 1;
            }
            // 是否是B类
            else if (ipNums[0] >= 128 && ipNums[0] <= 191) {

                B += 1;

            }
            // 是否是C类
            else if (ipNums[0] >= 192 && ipNums[0] <= 223) {

                C += 1;

            }
            // 是否是D类
            else if (ipNums[0] >= 224 && ipNums[0] <= 239) {

                D += 1;

            }
            // 是否是E类
            else if (ipNums[0] >= 240 && ipNums[0] <= 255) {

                E += 1;

            }
            // 是否是私有ip
            if (ipNums[0] == 10 || (ipNums[0] == 172 && (ipNums[1] >= 16 &&
                    ipNums[1] <= 31)) || (ipNums[0] == 192 && ipNums[1] == 168)) {

                privateIp += 1;

            }
        }
        in.close();
        System.out.println(A + " " + B + " " + C + " " + D + " " + E + " " + error + " "
                + privateIp);
    }

    /**
     * 判断整型数组中是否有不符合ip地址或者掩码数值规定的：数字必须是在 0~255 之间
     */
    private static boolean isRightNum(String s) {
        boolean res = true;
        if (s == null || "".equals(s))
            return false;
        Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            String[] nums = s.split("\\.");
            for (String num : nums) {
                int n = Integer.valueOf(num);
                if (n < 0 || n > 255) {
                    res = false;
                    break;
                }
            }
        } else {
            res = false;
        }

        return res;
    }

    // 只能用二进制来区分掩码是否正确 255.255.64.0  不然这种正确的掩码会误判
    private static boolean isRightMask(int[] mask) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : mask) {
            String s = binaryString(i);
            sb.append(s);
        }
        // 取出第一个0的位置，取出最后一个1的位置，如果第一个0在第一个1的前面，则不满足规则
        int first0 = sb.indexOf("0");
        int first1 = sb.lastIndexOf("1");
        if (first0 < first1) {
            return false;
        }
        return true;
    }

    /**
     * 将数字转换为二进制的字符串
     */
     private static String binaryString(int num) {
         StringBuilder sb = new StringBuilder();
         while (num != 0) {
             sb.append(num % 2);
             num = num / 2;
         }
         return sb.reverse().toString();
     }
//    private static String binaryString(int num) {
//        StringBuilder result = new StringBuilder();
//        int flag = 1 << 7;
//        for (int i = 0; i < 8; i++) {
//            int val = (flag & num) == 0 ? 0 : 1;
//            result.append(val);
//            num <<= 1;
//        }
//        return result.toString();
//    }

    /**
     * 用于拆分ip和mask的方法，并且将字符串数组转换成整型数组
     */
    private static int[] string2int(String s) {
        // 将ip拆分
        String[] ipNumStr = s.split("\\.");
        int[] ipNums = new int[ipNumStr.length];
        // 将拆分后的字符串数组转换成数字数组
        for (int i = 0; i < ipNumStr.length; i++) {
            ipNums[i] = Integer.parseInt(ipNumStr[i]);
        }
        return ipNums;
    }
}
