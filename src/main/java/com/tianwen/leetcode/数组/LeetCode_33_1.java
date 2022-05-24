package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月07日  21:38
 */
public class LeetCode_33_1 {
    /**
     * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *
     *
     * //输入：nums = [4,5,6,7,0,1,2], target = 0
     * //输出：4
     * //
     * //输入：nums = [4,5,6,7,0,1,2], target = 3
     * //输出：-1
     *
     * //输入：nums = [1], target = 0
     * //输出：-1
     */
    public static void main(String[] args) {
//        int[] nums = new int [] {4,5,6,7,0,1,2};
//        int target = 3;
//        int[] nums = new int [] {4,5,6,7,0,1,2};
//        int target = 3;
//        int[] nums = new int [] {1};
//        int target = 1;
//        int[] nums = new int [] {1};
        int[] nums = new int [] {};
        int target = 1;
        LeetCode_33_1 leetCode_33_1 = new LeetCode_33_1();
        System.out.println(leetCode_33_1.search(nums, target));
    }

    //输入：nums = [2,5,6,0,0,1,2], target = 0
    public int search(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
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
