package com.tianwen.algorithms;

/**
 * wangjq
 * 2021年01月02日  18:14
 */
public class Algorithms57_1_Arr_Two_Sum {

    public static void main(String[] args) {

    }

    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] >= target) {
            return new int[0];
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i ++;
            } else if (sum > target) {
                j --;
            } else {
                return new int[] {nums[i], nums[j]};
            }
        }
        return new int[0];
    }
}
