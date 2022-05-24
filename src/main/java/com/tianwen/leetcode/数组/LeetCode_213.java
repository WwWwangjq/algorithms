package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月09日  19:39
 */
public class LeetCode_213 {

    /**
     //输入：nums = [2,3,2]
     //输出：3

     //输入：nums = [1,2,3,1]
     //输出：4

     //输入：nums = [1,2,3]
     //输出：3
     */
    public static void main(String[] args) {
        LeetCode_213 leetCode_213 = new LeetCode_213();
        int[] nums = new int [] {1};
        System.out.println(leetCode_213.rob(nums));
    }

    public int rob(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        max = 0;
        recur(nums, 2, Math.max(nums[0], nums[1]), nums[0], nums.length - 1);
        int max1 = max;
        max = 0;
        recur(nums, 3, Math.max(nums[1], nums[2]), nums[1], nums.length);
        int max2 = max;
        return Math.max(max1, max2);
    }

    int max;

    private void recur(int[] nums, int sub, int fn1, int fn2, int endSub) {
        if (sub == endSub) {
            max = Math.max(fn1, fn2);
            return;
        }
        max = Math.max(nums[sub] + fn2, fn1);
        recur(nums, sub + 1, max, fn1, endSub);
    }
}
