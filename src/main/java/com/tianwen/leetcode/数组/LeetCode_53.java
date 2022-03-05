package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2021年05月09日  11:36
 */
public class LeetCode_53 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = new int[]{-1};
        LeetCode_53 leetCode_53 = new LeetCode_53();
        System.out.println(leetCode_53.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int sub = 0, curSum = 0, maxSum = nums[0];
        while (sub < nums.length) {
            curSum += nums[sub];
            sub ++;
            maxSum = Math.max(curSum, maxSum);
            if (curSum <= 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

}
