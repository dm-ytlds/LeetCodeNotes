package com.demi.code.test;

import com.demi.code.linear.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> list = new SequenceList<>(10);
        // insert
        list.insert("a");
        list.insert("b");
        list.insert("C");
        list.insert(1, "B");
        // 测试Iterator
        for(String s : list) {
            System.out.println(s);
        }

        // getE
        String getRes = list.getE(1);
        System.out.println("getRes: " + getRes);

        // remove
        String removeRes = list.remove(2);
        System.out.println("removeRes: " + removeRes);

        // clear
        list.clear();
        System.out.println("lists' length is: " + list.length());
    }
}
