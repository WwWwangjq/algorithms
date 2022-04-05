package com.tianwen.leetcode.数组;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月03日  11:40
 */
public class LeetCode_912 {


    public static void main(String[] args) {
//        int[] nums = new int [] {-1,2,1,-4};
        int[] nums = new int [] {5,1,1,2,0,0};
//        int[] nums = new int [] {5,2,3,1};
        LeetCode_912 leetCode_912 = new LeetCode_912();
        int[] ints = leetCode_912.sortArray(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortArray(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        if (left < partition) {
            quickSort(nums, left, partition);
        }
        if (partition < right) {
            quickSort(nums, partition + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int mid = left;
        swap(nums, left, right);
        for (int i = left; i < right; i ++) {
            if (nums[i] < nums[right]) {
                if (mid != i) {
                    swap(nums, mid, i);
                }
                mid ++;
            }
        }
        swap(nums, mid, right);
        return mid;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
