package com.biienu.sorttest;

/**
 * @Author: biienu
 * @Date: 2022/3/30 11:52
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] temp = {2,1,0,-1,-1,-1, 10};
        quickSort(temp, 0, temp.length-1 );
        for(int i : temp){
            System.out.print(i + "   ");
        }
    }
    static void quickSort(int[] nums, int left, int right){
        if(left < right){
            int index = partion1(nums, left,right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    private static int partion(int[] nums, int left, int right) {

        int pivot = nums[left];
        while(left < right){

            //移动右right
            while(left < right && nums[right] >= pivot){
                right--;
            }
            if(left < right) nums[left] = nums[right];
            while (left < right && nums[left] <= pivot){
                left++;
            }
            if(left < right) nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
    private static int partion1(int[] nums, int left, int right){
        int pivot = nums[left];
        int start = left;
        while (left < right){
            while(left < right && nums[right] >= pivot){
                right--;
            }
            while (left < right && nums[left] <= pivot){
                left++;
            }
            if(left >= right) break;
           swap(nums, left, right);
        }
        swap(nums, start, left);
        return left;
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
