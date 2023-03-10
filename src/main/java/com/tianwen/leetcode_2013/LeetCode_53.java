package com.tianwen.leetcode_2013;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月10日 8:04
 */
public class LeetCode_53 {

    // [-2,1,-3,4,-1,2,1,-5,4]

    public int maxSubArray(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0, i = 0;
        while (i < nums.length) {
            sum += nums[i];
            sumMax = Math.max(sum, sumMax);
            if (sum < 0) {
                sum = 0;
            }
            i ++;
        }
        return sumMax;
    }

    int sumMax = Integer.MIN_VALUE;
}
