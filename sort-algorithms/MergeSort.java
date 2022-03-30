package com.biienu.sorttest;

/**
 * @Author: biienu
 * @Date: 2022/3/30 11:20
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] temp = {2,1,0,-1, 10};
        mergeSort(temp, 0, temp.length-1 );
        for(int i : temp){
            System.out.print(i + "   ");
        }
    }
    static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    static void merge(int[] arr, int left, int mid, int right){

        //定义一个新的数组
        int[] tempArray = new int[right - left + 1];
        int l1 = left, l2 = mid + 1;
        int index = 0;
        while(l1 <= mid && l2 <= right){
            if(arr[l1] < arr[l2]){
                tempArray[index ++] = arr[l1++];
            } else{
                tempArray[index ++] = arr[l2++];
            }
        }
        //
        if(l1 <= mid){
            System.arraycopy(arr, l1, tempArray, index, mid - l1 + 1);
        }
        if(l2 <= mid) {
            System.arraycopy(arr, l2, tempArray, index, right - l2 + 1);
        }
        System.arraycopy(tempArray, 0,arr, left, right - left + 1);
    }
}
