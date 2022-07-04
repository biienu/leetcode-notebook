package com.biienu.testapi;

import java.util.Arrays;

/**
 * @Author: biienu
 */
public class BaseSort {
    public static void main(String[] args) {
        int[] nums = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100,5,1,1,2,0,0};
        baseSort(nums, 3);
        for (int i: nums) {System.out.print(i + ", ");
        }
    }
    public static void baseSort(int[] nums, int d){
        int len = nums.length;
        int[][] temp = new int[10][len];
        for(int i = 0; i < 10; i++) Arrays.fill(temp[i], -1);
        int m = 1;
        int n = 1;
        int[] order = new int[10];  // 表示 order[i]  余数为i的个数
        while(m <= d){
            for(int i = 0; i < len; i++){
                int cur = nums[i];
                int r = (cur / n) % 10;
                temp[r][order[r]] = nums[i];
                order[r]++;
            }
            int idx = 0;
            for(int i = 0; i < 10; i++){
                if(order[i] == 0) continue;
                for(int j = 0; j < order[i]; j++){
                    nums[idx++] = temp[i][j];
                }
            }
            n *= 10;
            m++;
        }
    }
}
