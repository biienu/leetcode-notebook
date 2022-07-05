package com.biienu.testapi;

import java.util.Arrays;

/**
 * @Author: biienu
 * 计数排序
 */
public class CountSort {
    public static void main(String[] args) {
        int[] nums = {10,20,20,9,100,99,83,29,98};
        countSort(nums);
        for(int i: nums){
            System.out.print(i + " , ");
        }
    }

    public static void countSort(int[] nums){
        int len = nums.length;
        if(len < 2) return;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int[] countArr = new int[max - min + 1];
        for(int i : nums){
            countArr[i - min] ++;
        }
        for(int i = 1; i < max - min + 1; i++){
            countArr[i] += countArr[i - 1];
        }

        int[] newArr = new int[len];
        for(int i = len - 1; i >= 0; i--){
            int idx = --countArr[nums[i] - min];
            newArr[idx] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, len);
    }
}

