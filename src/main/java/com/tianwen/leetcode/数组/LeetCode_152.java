package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月10日  11:17
 */
public class LeetCode_152 {
    /**
     *
     //输入: nums = [2,3,-2,4]
     //输出: 6

     //输入: nums = [-2,0,-1]
     //输出: 0
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_152 leetCode_152 = new LeetCode_152();
//        int[] nums = new int [] {};
//        int[] nums = new int [] {2, 2};
//        int[] nums = new int [] {2,3,-2,4};
//        int[] nums = new int [] {-2,0,-1};
        int[] nums = new int [] {-2,3,-4};
        System.out.println(leetCode_152.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        max = nums[0];
        recur(nums, 1, nums[0], nums[0]);
        return max;
    }

    int max = Integer.MIN_VALUE;

    private void recur(int[] nums, int sub, int fnmax, int fnmin) {
        if (sub == nums.length) {
            return;
        }
        int n = nums[sub];
        int curMax = Math.max(n * fnmax, Math.max(n * fnmin, n));
        int curMin = Math.min(n * fnmax, Math.min(n * fnmin, n));
        max = Math.max(max, curMax);
        recur(nums, sub + 1, curMax, curMin);
    }
}
