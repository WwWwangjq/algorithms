package com.tianwen.leetcode.滑动窗口;

/**
 * wangjq
 * 2022年04月19日  23:26
 */
public class LeetCode_713 {
    /**
     //输入: nums = [10,5,2,6], k = 100
     //输出: 8
     //解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
     //需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
     //
     //输入: nums = [1,2,3], k = 0
     //输出: 0
     */
    public static void main(String[] args) {
        LeetCode_713 leetCode_713 = new LeetCode_713();
//        int[] nums = new int [] {10,5,2,6};
//        int k = 100;
//        int[] nums = new int [] {10,5,21,13,23,8,1,56,9,2,6,45,7,2,54,2};
//        int k = 20;
        int[] nums = new int [] {1,2,3};
        int k = 0;
        System.out.println(leetCode_713.numSubarrayProductLessThanK(nums, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int product = 1;
        int resultCount = 0;
        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left ++;
            }
            // 每次循环 计算本次可生成的子数组个数 不会与之前的重复
            resultCount += right - left + 1;
            right++;
        }
        return resultCount;
    }
}
