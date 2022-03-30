package com.biienu.sorttest;

/**
 * @Author: biienu
 * @Date: 2022/3/30 10:39
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {

        int[] temp = {2,1,0,-1, 10};
        sort(temp);
        for(int i : temp){
            System.out.print(i + "   ");
        }
    }
    static void sort(int[] nums){
        int len = nums.length;
        int increment = len;
        while(increment > 1){
            increment = increment / 2;
            //插入排序
            for(int i = increment; i < len; i++){
                int j, temp = nums[i];
                for(j = i - increment; j >= 0 && nums[j] > temp; j -= increment){
                    nums[j + increment ] = nums[j ];
                }
                nums[j + increment] = temp;
            }
        }
    }
}
