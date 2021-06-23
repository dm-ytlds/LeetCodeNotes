package com.demi.code.test;

import com.demi.code.symbol.SymbolTable;

public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> st = new SymbolTable<>();
        // 插入
        st.put(1, "a");
        st.put(2, "b");
        st.put(3, "d");
        // size
        System.out.println("插入后元素的个数：" + st.size());
        System.out.println("_______________");
        // 获取
        System.out.println(st.get(2));

    }
}
