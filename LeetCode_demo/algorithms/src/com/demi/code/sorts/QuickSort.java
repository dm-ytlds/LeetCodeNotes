package com.demi.code.sorts;

/**
 * 快速排序
 * 一篇讲的很好的博客：
 * https://blog.csdn.net/shujuelin/article/details/82423852
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 快速排序之所比较快，因为相比冒泡排序，每次交换是跳跃式的。每次排序的时候设置一个基准点，
     * 将小于等于基准点的数全部放到基准点的左边，将大于等于基准点的数全部放到基准点的右边。
     * 这样在每次交换的时候就不会像冒泡排序一样每次只能在相邻的数之间进行交换，交换的距离就大的多了。
     * 因此总的比较和交换次数就少了，速度自然就提高了。当然在最坏的情况下，仍可能是相邻的两个数进行了交换。
     * 因此快速排序的最差时间复杂度和冒泡排序是一样的都是O(N^2)，它的平均时间复杂度为O(NlogN)。
     * 其实快速排序是基于一种叫做“二分”的思想。
     * @param nums
     * @param low
     * @param high
     */
    public static void quickSort(int[] nums, int low, int high) {

        // 创建数组下标i ,j
        // temp表示基准数
        // t在每一次交换元素时起作用，作为元素交换的临时位置
        int i, j, temp , t;
        // 如果出现这种情况，直接返回
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        // 初始化基准元素为当前数组的第一个元素
        temp = nums[low];
        // 一轮交换
        while (i < j) {
            // 从当前数组的尾元素开始，直到找到小于等于基准数的元素，才停止尾元素下标指针的移动
            while (temp <= nums[j] && i < j) {
                // 尾元素下标指针向前移动
                j--;
            }
            // 尾元素指针停止后，从当前数组的首元素开始，直到找到大于等于基准数的元素，才停止首元素下标指针的移动
            while (temp >= nums[i] && i < j) {
                i++;
            }
            // 如果满足置换条件，则交换
            // 结束一次移动元素，就需要进行元素交换
            if (i < j) {

                // 先将哨兵j对应的数字赋给临时变量t
                t = nums[j];
                // 然后将哨兵j对应的值与哨兵i对应的值交换
                nums[j] = nums[i];
                // 最后将临时变量t保存的值赋给哨兵i，达到交换的效果
                nums[i] = t;
            }
        }
        // 交换一轮后，需要对基准数字的位置做改变
        // 将基准数与遍历到的最后一个元素交换（即i，j相遇处）
        nums[low] = nums[i];
        nums[i] = temp;
        // 递归基准数的左半边数组。右边界之所以是j - 1和左边界之所以是j + 1，
        // 是因为第j个元素的左边数字都比它小，右边数字都比它大，所以排序不再需要带上它
        quickSort(nums, low, j - 1);
        // 递归基准数的右半边数组
        quickSort(nums, j + 1, high);
    }
}
