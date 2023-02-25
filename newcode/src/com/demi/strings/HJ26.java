package com.demi.strings;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class HJ26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String str = in.nextLine();
            String res = sort(str);
            System.out.println(res);
        }
    }

    private static String sort(String s) {
        // 先取出字符串中的字母
        ArrayList<Character> letters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // 判断当前字符是否是字母
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                letters.add(c);
            }
        }
        // 对字母做排序
        letters.sort(Comparator.comparingInt(Character::toLowerCase));
        // 重新遍历字符串，遇到字母时，从letters中取值，遇到非字母时，直接存下来
        StringBuilder res = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                res.append(letters.get(j++));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
