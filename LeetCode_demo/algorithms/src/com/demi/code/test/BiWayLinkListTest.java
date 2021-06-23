package com.demi.code.test;

import com.demi.code.linear.BiWayLinkList;

public class BiWayLinkListTest {
    public static void main(String[] args) {
        BiWayLinkList<String> list = new BiWayLinkList<>();
        // insert
        list.insert("a");
        list.insert("b");
        list.insert("C");
        list.insert(1, "B");
        // 测试Iterator
        for(String s : list) {
            System.out.println(s);
        }
        System.out.println("firstElement = " + list.getFirst());
        System.out.println("lastElement = " + list.getLast());

        // getE
        String getRes = list.get(1);
        System.out.println("getRes: " + getRes);

        // remove
        String removeRes = list.remove(2);
        System.out.println("removeRes: " + removeRes);

        // clear
        list.clear();
        System.out.println("lists' length is: " + list.length());
    }
}
