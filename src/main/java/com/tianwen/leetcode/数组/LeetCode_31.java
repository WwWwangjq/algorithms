package com.tianwen.leetcode.数组;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2021年04月24日  19:01
 */
public class LeetCode_31 {

    public static void main(String[] args) {
        int[] nums = new int [] {2, 3, 1};
        LeetCode_31 leetCode_31 = new LeetCode_31();
        leetCode_31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void nextPermutation(int[] nums) {
        if (Objects.isNull(nums)) {
            return;
        }
        int left, right;
        left = findLeft(nums);
        if (left != -1) {
            right = findRight(nums, nums[left]);
            swap(nums, left, right);
        }
        reversal(nums, left + 1, nums.length - 1);
    }

    private int findLeft(int[] nums) {
        int sub = nums.length - 1;
        while (sub > 0) {
            if (nums[sub - 1] < nums[sub]) {
                return sub - 1;
            }
            sub --;
        }
        return -1;
    }

    private int findRight(int[] nums, int val) {
        int sub = nums.length - 1;
        while (sub > 0) {
           if (nums[sub] > val) {
               return sub;
           }
           sub --;
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reversal(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left ++, right--);
        }
    }
}
