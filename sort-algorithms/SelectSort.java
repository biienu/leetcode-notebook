package com.biienu.sorttest;

/**
 * @Author: biienu
 * @Date: 2022/3/30 9:52
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] temp = {2,1,0,-1, 10, -1};
        sort(temp);
        for(int i : temp){
            System.out.print(i + "   ");
        }
    }
    static void sort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i; j < len ; j++) {
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            if(min != i){
                swap(nums, i, min);
            }
        }
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
