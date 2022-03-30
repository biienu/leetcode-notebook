package com.biienu.sorttest;

/**
 * @Author: biienu
 * @Date: 2022/3/30 9:43
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] temp = {2,1,0,-1, 10,-10};
        sort(temp);
        for(int i : temp){
            System.out.print(i + "   ");
        }
    }
    static void sort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for(int j = 0; j < len - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                }
            }
        }
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
