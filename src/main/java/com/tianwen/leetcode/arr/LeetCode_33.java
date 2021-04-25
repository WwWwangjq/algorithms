package com.tianwen.leetcode.arr;

import java.util.Objects;

/**
 * wangjq
 * 2021年04月24日  20:06
 */
public class LeetCode_33 {
    public static void main(String[] args) {
        LeetCode_33 leetCode_33 = new LeetCode_33();
//        int[] nums = new int [] {4,5,6,7,0,1,2};
        int[] nums = new int [] {3,4,5,7,0,1,2};
        int target = 3;
//        int[] nums = new int [] {1, 3};
//        int target = 0;
//        int target = 1;
        System.out.println(leetCode_33.search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] == target) {
                return mid;
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
        return -1;
    }
}
