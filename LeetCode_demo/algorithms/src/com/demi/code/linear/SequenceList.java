package com.demi.code.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{
    // 存储元素的数组
    private T[] elements;
    // 记录当前线性表中的元素
    private int N;

    // 构造方法

    public SequenceList(int capacity) {
        // 初始化线性表
        this.elements = (T[]) new Object[capacity];
        // 初始化线性表长度
        this.N = 0;
    }
    // 将线性表置为空表
    public void clear() {
        this.N = 0;
    }
    // 判断当前线性表是否为空表
    public boolean isEmpty() {
        /*
        if(this.N == 0) {
            return true;
        }
        return false;
        */
        return N == 0;
    }
    // 获取线性表的长度
    public int length() {
        return N;
    }
    // 获取指定位置的元素
    public T getE(int i) {
        return elements[i];
    }
    // 向线性表中添加元素t
    public void insert(T t) {
        if(N == elements.length) {
            resize(2*elements.length);
        }
        elements[N++] = t;
    }
    // 在i元素处插入元素t
    public void insert(int i , T t) {
        if(N == elements.length) {
            resize(2*elements.length);
        }
        for (int j = N; j > i; j--) {
            elements[j] = elements[j - 1];
        }
        elements[i] = t;
        N++;
    }
    // 删除指定位置i处的元素，并返回该元素
    public T remove(int i) {
        // 记录索引i处当前的值
        T curr = elements[i];
        for (int j = i; j < N - 1; j++) {
            elements[j] = elements[j + 1];
        }
        // 删除一个元素后，记得让总长度 - 1
        N--;
        if(N < elements.length / 4) {
            resize(elements.length / 2);
        }
        return curr;
    }
    // 查找t元素第一次出现的位置
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if(elements[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    // 完成顺序表的自动扩容
    public void resize(int newSize) {
        // 定义一个临时数组，指向原数组
        T[] temp = elements;
        // 创建新数组
        elements = (T[]) new Object[newSize];
        // 把原数组拷贝到新数组
        for (int i = 0; i < N; i++) {
            elements[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RIterator();
    }

    // 提供内部类，实现Iterator接口
    private class RIterator implements Iterator {

        // 提供一个遍历顺序表的指针
        private int index;

        public RIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < N;
        }

        @Override
        public Object next() {
            return elements[index++];
        }
    }
}
