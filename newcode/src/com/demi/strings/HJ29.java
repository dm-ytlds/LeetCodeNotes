package com.demi.strings;


import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (in.hasNext()) {
            String str01 = in.nextLine();
            String str02 = in.nextLine();
            System.out.println(encode(str01));
            System.out.println(decode(str02));
        }

    }

    /**
     加密
     */
    private static String encode (String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c < '9') {
                res.append((char) (c + 1));
            } else if (c == '9') {
                res.append(0);
            } else if (c >= 'A' && c < 'Z') {
                res.append((char) (c + 33));
            } else if (c == 'Z') {
                res.append('a');
            } else if (c >= 'a' && c < 'z') {
                res.append((char) (c - 31));
            } else if (c == 'z') {
                res.append('A');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    /**
     解密
     */
    private static String decode (String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // '0' -> '9'  '1' -> '0'  '2' -> '1'
            if (c > '0' && c <= '9') {
                res.append((char)(c - 1));
            } else if (c == '0') {
                res.append(9);
            } else if (c > 'A' && c <= 'Z') {
                // 'A' -> 'z'  'B' -> 'a'
                res.append((char)(c + 31));
            } else if (c == 'A') {
                res.append('z');
            } else if (c > 'a' && c <= 'z') {
                // 'a' -> 'Z'  'b' -> 'A'
                res.append((char)(c - 33));
            } else if (c == 'a') {
                res.append('Z');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
