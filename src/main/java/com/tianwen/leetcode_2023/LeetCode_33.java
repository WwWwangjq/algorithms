package com.tianwen.leetcode_2023;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月13日 8:24
 */
public class LeetCode_33 {
    // 输入：nums = [4,5,6,7,0,1,2], target = 0 输出：4
    // 输入：nums = [4,5,6,7,0,1,2], target = 3 输出：-1
    public int search(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
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
}
