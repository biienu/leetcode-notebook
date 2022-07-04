package com.biienu.testapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: biienu
 * 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] nums = {20,2,8,49,10,6};
        bucketSort(nums);
        for(int i: nums){
            System.out.print(i + ", ");
        }
    }
    public static void bucketSort(int[] nums){
        int n = nums.length;
        if(n < 2) return;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int d = Math.max(1, (max - min) /(n - 1));
        int size = (max - min) / d + 1;
        List<ArrayList<Integer>> bucket = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            bucket.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            int idx = (nums[i] - min) / d;
//            if(idx < 0 || idx >= size) continue;
            bucket.get(idx).add(nums[i]);
        }
        int idx = 0;
        for(int i = 0; i < size; i++){
            Collections.sort(bucket.get(i), (o1,o2)->{return o1 - o2;});
            for(int j: bucket.get(i)){
                nums[idx++] = j;
            }
        }
    }
}
