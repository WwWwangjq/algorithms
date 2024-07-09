package com.tianwen.leetcode_2023_11;

import java.util.Random;

/**
 * @Author: wangjq
 * @Date: 2023年11月24日 12:20
 */
public class LeetCode_Supplement_4 {
    public int[] sortArray(int[] nums) {
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

    Random random = new Random();

    private int partition(int[] nums, int left, int right) {
        int randomSub = random.nextInt(right - left) + left;
        int compareValue = nums[randomSub];
        swap(nums, randomSub, right);
        int partition = left;
        for (int i = left; i < right; i ++) {
            if (nums[i] < compareValue) {
                if (i != partition) {
                    swap(nums, partition, i);
                }
                partition ++;
            }
        }
        swap(nums, partition, right);
        return partition;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
