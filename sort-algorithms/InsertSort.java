package com.biienu.sorttest;

/**
 * @Author: biienu
 * @Date: 2022/3/30 10:10
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] temp = {2,1,0,-1, 10};
        sort(temp);
        for(int i : temp){
            System.out.print(i + "   ");
        }
    }
    static void sort(int nums[]){
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int j;
            int temp = nums[i];
            for (j = i; j > 0; j--) {
                if(nums[j - 1] > temp){
                    nums[j] = nums[j - 1];
                    continue;
                } else break;
            }
            nums[j] = temp;
        }
    }
}
