package com.tianwen.leetcode_2023_11;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年11月23日 16:28
 */
public class LeetCode_215 {
    public int findKthLargest(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = findPartition(nums, left, right);
        if (left < partition) {
            quickSort(nums, left, partition);
        }
        if (partition < right) {
            quickSort(nums, partition + 1, right);
        }
    }

    private int findPartition(int[] nums, int left, int right) {
        int compareValue = nums[left];
        swap(nums, left, right);
        int partition = left;
        for (int i = left; i < right; i ++) {
            if (nums[i] < compareValue) {
                if (partition != i) {
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
