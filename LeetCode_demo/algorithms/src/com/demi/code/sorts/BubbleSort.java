package com.demi.code.sorts;


import java.util.Arrays;

/**
 * 冒泡排序
 * 每次将序列中的两两元素进行比较，找出较小的值放在前面。比如：arr[0, 1, ..., n], 双层循环，外层循环控制的是比较从哪里停止（即只比较哪些位置的元素），
 * 倒着比较。第一遍比较：arr[n]和arr[n - 1]比较，将较小的数放在前面，接着和arr[n - 2]作比较，
 * 重复上述操作，最后将第一遍比较得到的最小元素放在第一个位置，第二遍比较：从arr[1, ..., n]作比较即可。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 6, 5, 7};
        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Integer.MAX_VALUE*2);
        System.out.print(Integer.MIN_VALUE*2);
    }
    public static void bubbleSort(int[] arr) {
        int N = arr.length;
        int temp;
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= i + 1; j--) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}


/*
public class BubbleSort {
    public static void BubbleSort(int[] arr) {
        int temp;//定义一个临时变量
        for(int i=0;i<arr.length-1;i++){//冒泡趟数
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,6,2,2,5};
        BubbleSort.BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}*/
