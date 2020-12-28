package com.tianwen.algorithms;

/**
 * wangjq
 * 2020年12月29日  0:16
 */
public class Algorithms42_Arr_Max_Sub {

    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = nums[0];
        int max = sum;
        boolean resume = nums[0] <= 0;

        for (int i = 1; i < nums.length; i ++) {
            if (resume) {
                resume = false;
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum <= 0) {
                resume = true;
            }
        }
        return max;
    }
}
