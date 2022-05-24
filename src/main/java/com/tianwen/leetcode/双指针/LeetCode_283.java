package com.tianwen.leetcode.双指针;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月16日  20:31
 */
public class LeetCode_283 {
    /**
     *
     //输入: nums = [0,1,0,3,12]
     //输出: [1,3,12,0,0]
     */
    public static void main(String[] args) {
        LeetCode_283 leetCode_283 = new LeetCode_283();
//        int[] nums = new int [] {0,1,0};
//        int[] nums = new int [] {0,0,1};
//        int[] nums = new int [] {1,0,0};
//        int[] nums = new int [] {0,0};
//        int[] nums = new int [] {1,1};
        int[] nums = new int [] {0,1,0,3,12};
        leetCode_283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left ++;
            }
            right ++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
