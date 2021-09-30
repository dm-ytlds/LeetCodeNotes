package com.demi.code.tencent;

import java.util.*;
public class Test {
    public static void main(String []args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[] = new int[n];
        int max=0;
        int min=n-1;
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
            if(nums[i]>nums[max]){
                max=i;
            }
            if(nums[i]<nums[min]){
                min=i;
            }
        }
        nums[0]=nums[max];
        nums[n-1]=nums[min];
        System.out.println(Arrays.toString(nums));
    }
}
