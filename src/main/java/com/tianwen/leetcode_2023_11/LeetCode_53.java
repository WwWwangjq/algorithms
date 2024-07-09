package com.tianwen.leetcode_2023_11;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年11月22日 14:08
 */
public class LeetCode_53 {

    public int maxSubArray(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int i = 0; i < nums.length; i ++) {
            tempSum += nums[i];
            result = Math.max(result, tempSum);
            if (tempSum < 0) {
                tempSum = 0;
            }
        }
        return result;
    }
}
