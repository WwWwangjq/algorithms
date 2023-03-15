package com.tianwen.leetcode_2022.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月09日  18:04
 */
public class LeetCode_209 {
    /**
     *
     //输入：target = 7, nums = [2,3,1,2,4,3]
     //输出：2

     //输入：target = 4, nums = [1,4,4]
     //输出：1
     */
    public static void main(String[] args) {
        LeetCode_209 leetCode209 = new LeetCode_209();
//        int target = 7;
//        int[] nums = new int [] {2,3,1,2,4,3};
        int target = 4;
        int[] nums = new int [] {1,1,1};
        System.out.println(leetCode209.minSubArrayLen(target, nums));
    }


    public int minSubArrayLen(int target, int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (nums[right] >= target) {
                return 1;
            }
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left ++;
            }
            right ++;
        }
        return Integer.MAX_VALUE == result ? 0 : result;
    }
}
