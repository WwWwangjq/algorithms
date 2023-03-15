package com.tianwen.leetcode_2023;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月11日 21:03
 */
public class LeetCode_215 {

    public static void main(String[] args) {
//        int[] nums = new int [] {3,2,1,5,6,4};
        int[] nums = new int [] {-1,0,1,2,-1,-4};
        LeetCode_215 leetCode215 = new LeetCode_215();
        System.out.println(leetCode215.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length < k) {
            return 0;
        }
        quickSort(nums, 0, nums.length - 1);
        return getK(nums, k);
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
        int partition = left;
        swap(nums, left, right);
        for (int i = left; i < right; i ++) {
            if (nums[i] < nums[right]) {
                if (partition != i) {
                    swap(nums, i, partition);
                }
                partition ++;
            }
        }
        swap(nums, partition, right);
        return partition;
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }

    private int getK(int[] nums, int k) {
        return nums[nums.length - k];
    }
}
