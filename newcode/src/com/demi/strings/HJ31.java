package com.demi.strings;

import java.util.Scanner;

public class HJ31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] strs = s.split("[^A-Za-z]");
            int n = strs.length;
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(strs[i] + " ");
            }
        }
    }
}
