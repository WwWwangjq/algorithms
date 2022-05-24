package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月11日  21:09
 */
public class LeetCode_162 {
    /**
     * //输入：nums = [1,2,3,1]
     * //输出：2
     * //解释：3 是峰值元素，你的函数应该返回其索引 2。
     * //
     * //输入：nums = [1,2,1,3,5,6,4]
     * //输出：1 或 5
     */
    public static void main(String[] args) {
//        int[] nums = new int [] {1,2,3,1};
//        int[] nums = new int [] {1,2,1,3,5,6,4};
//        int[] nums = new int [] {3,2,1};
        int[] nums = new int [] {1,2,3};
        LeetCode_162 leetCode_162 = new LeetCode_162();
        System.out.println(leetCode_162.findPeakElement(nums));
    }


    public int findPeakElement(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid == 0) {
                return nums[mid] > nums[mid + 1] ? mid : -1;
            } else if (mid == nums.length - 1) {
                return nums[mid] > nums[mid - 1] ? mid : -1;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] > nums[mid]) {
                right = mid;
            } else if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
