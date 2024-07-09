package com.tianwen.leetcode_2023_11;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年11月24日 13:42
 */
public class LeetCode_33 {
    public int search(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right --;
                } else {
                    left ++;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char a = 'A';
        System.out.println(Integer.parseInt(String.valueOf(a), 16));
    }
}
