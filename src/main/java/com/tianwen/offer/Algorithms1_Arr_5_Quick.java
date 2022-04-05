package com.tianwen.offer;

import java.util.Arrays;
import java.util.Random;

/**
 * wangjq
 * 2020年12月25日  22:35
 */
public class Algorithms1_Arr_5_Quick {


    public static void main(String[] args) {
//        int[] nums = new int[]{5, 1, 8, 32, 8, 2, 32, 7, 4, 34, 6, 8, 45, 2, 5, 34, 7, 48, 324, 5};
//        int[] nums = new int[]{1, -1};
//        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
//        int[] nums = new int [] {5,2,3,1};
        int[] nums = new int [] {5,1,1,2,0,0};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        Integer small = partition(nums, start, end);
        if (small > start) {
            quickSort(nums, start, small);
        }
        if (small < end) {
            quickSort(nums, small + 1, end);
        }
    }

    private static Integer partition(int[] nums, int start, int end) {
        int small = start;
        // 将选中的数字放到最后
        swap(nums, start, end);
        for (int i = start; i < end; i ++) {
            if (nums[i] < nums[end]) {
                if (small != i) {
                    swap(nums, small, i);
                }
                small++;
            }
        }
        // 大于随机数的那一部分数组 第一位和最后一位交换
        swap(nums, small, end);
        return small;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
