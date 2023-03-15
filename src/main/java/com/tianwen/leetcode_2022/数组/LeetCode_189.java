package com.tianwen.leetcode_2022.数组;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月09日  16:44
 */
public class LeetCode_189 {
    /**
     *
     //输入: nums = [1,2,3,4,5,6,7], k = 3
     //输出: [5,6,7,1,2,3,4]

     //输入：nums = [-1,-100,3,99], k = 2
     //输出：[3,99,-1,-100]
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 8;
        LeetCode_189 leetCode_189 = new LeetCode_189();
        leetCode_189.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (Objects.isNull(nums) || k < 0) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start ++, end --);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
