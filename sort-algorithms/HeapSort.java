package com.biienu.sorttest;

/**
 * @Author: biienu
 * @Date: 2022/3/30 15:13
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,-1,-2,-3};
        sort(nums);
        for(int i : nums){
            System.out.print(i + "   ");
        }
    }

   static void sort(int[] nums){
        int len = nums.length;
        //开始下沉建堆
       for(int i = len / 2 ; i >= 0; --i){
           sink(nums, i, len);
       }
       /**
        * 排序：最上面的和最后一个元素交换，然后最上面的元素再进行下沉
        */
       int k = len;
       while(k > 0){
           swap(nums, 0, k - 1);
           sink(nums, 0, --k);
       }

   }

   //下沉操作
    /**
     * 当前节点的左子节点 index * 2 + 1, 右子节点 index * 2 + 2
     * 当前节点的父节点 (index - 1) / 2
     */
    static void sink(int[] nums, int index, int len){

        while(index * 2 + 1 < len){
            //子节点
            int j = index * 2 + 1;
            if(j + 1 < len && nums[j] < nums[j + 1]){
                j++;
            }
            if(nums[index] < nums[j]){
                swap(nums, index, j);
            } else break;
            index = j;
        }
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
