package com.demi.code.sorts;

import java.util.Arrays;

/**
 * 堆排序的实现
 * https://www.bilibili.com/video/BV1UU4y1a7Vm?from=search&seid=4313761744810137991
 */
public class HeapSortTest {
    public static void heapSort(int[] arr) {
        // 1.先将数组转换成堆结构
        // 数组的初始状态实际上就对应了堆的初始状态，不需要使用代码进行转换

        // 4.实现一个循环，每一次都表示一个元素有序，每一次都将参与堆排序的数组最大下标向前移动一个
        for (int end = arr.length - 1; end > 0; end--) {
            // 2.将堆结构不断的调整为大根堆
            maxHeap(arr, end);
            // 3.将堆顶元素arr[0]和堆的最后一个叶子节点arr[end]进行交换，表示这个元素已经有序
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
        }
    }

    /**
     * 构建大根堆的方法
     * @param array 构建大根堆的数组
     * @param end   参与构建大根堆数组元素的最大下标
     *              相当于堆中最后一个节点（叶子节点）在数组中对应的下标。节省了空间
     */
    private static void maxHeap(int[] array, int end) {
        // 1.根据公式计算出堆结构中最后一个父节点的下标
        // 公式：lastFather = [(start + end) / 2]↑ - 1
        // 参与计算的奇偶不同，返回结果不同，用三目运算符实现奇偶情况下父节点的下标寻找
        int lastFather = (0 + end) % 2 != 0 ? (0 + end) / 2 : (0 + end) / 2 - 1;
        // 5.从最后一个父节点开始向前不断移动(-1)，使得每一个父节点都能够实现左右比较，以下犯上的步骤
        for (int father = lastFather; father >= 0; father--) {
            // 2.根据父节点的下标推算出左右孩子的数组下标
            //  左孩子：2n + 1
            //  右孩子：2n + 2
            int lChild = father * 2 + 1;
            int rChild = father * 2 + 2;
            // 3.在保证右孩子下标没有越界的情况下，使用右孩子和父节点进行比较
            // 如果右孩子 > 父节点，则交换
            if (rChild <= end && array[rChild] > array[father]) {
                int tmp = array[rChild];
                array[rChild] = array[father];
                array[father] = tmp;
            }
            // 4.使用左孩子进行比较（左孩子不需要判断是否越界，因为既然有父节点，那么肯定至少有一个孩子才配叫做父节点）
            // 如果左孩子 > 父节点，则交换。步骤3和步骤4间接的进行了左右孩子的比较
            if (array[lChild] > array[father]) {
                int tmp = array[lChild];
                array[lChild] = array[father];
                array[father] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 0, 8, 6, 5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
