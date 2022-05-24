package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月07日  23:12
 */
public class LeetCode_81 {

    public static void main(String[] args) {
        int[] nums = new int [] {3,1,2,3,3,3,3};
        int target = 0;
        LeetCode_81 leetCode_81 = new LeetCode_81();
        System.out.println(leetCode_81.search(nums, target));
    }
    public boolean search(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left ++;
                right --;
                continue;
            }
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
