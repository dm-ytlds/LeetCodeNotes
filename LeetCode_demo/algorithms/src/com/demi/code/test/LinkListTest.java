package com.demi.code.test;

import com.demi.code.linear.LinkList;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();
        // insert
        list.insert("a");
        list.insert("b");
        list.insert("C");
        list.insert(1, "B");
        // 测试Iterator
        for(String s : list) {
            System.out.println(s);
        }

        System.out.println("---------------------------------------");
        // 测试反转链表的操作
        list.reverse();
        for (String s : list) {
            System.out.println(s);
        }

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
