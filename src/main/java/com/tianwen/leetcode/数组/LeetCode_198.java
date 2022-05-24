package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月09日  17:28
 */
public class LeetCode_198 {

    /**
     *
     //输入：[1,2,3,1]
     //输出：4

     //输入：[2,7,9,3,1]
     //输出：12
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_198 leetCode_198 = new LeetCode_198();
//        int[] nums = new int [] {1,2,3,1};
        int[] nums = new int [] {2,1,1,2};
//        int[] nums = new int [] {};
        System.out.println(leetCode_198.rob(nums));;
    }


    /**
     * f(1) = nums[0];
     * f(2) = nums[1];
     * f(n) = Math.max(n + f(n-2), f(n-1))
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        max = Math.max(nums[0], nums[1]);
        recur(nums, 2, max, nums[0]);
        return max;
    }

    int max = 0;

    private void recur(int[] nums, int sub, int fn1, int fn2) {
        if (sub == nums.length) {
            return;
        }
        max = Math.max(nums[sub] + fn2, fn1);
        recur(nums, sub + 1, max, fn1);
    }

}
