package com.tianwen.leetcode_2023;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月20日 8:56
 */
public class LeetCode_704 {
    /**
     * 输入: nums = [-1,0,3,5,9,12], target = 9 输出: 4
     */
    public int search(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
