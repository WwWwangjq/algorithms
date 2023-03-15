package com.tianwen.leetcode_2022.数组;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2021年04月24日  16:40
 */
public class LeetCode_26 {
    public static void main(String[] args) {
//        int[] nums = new int [] {0,0,1,1,1,2,2,3,3,4};
//        int[] nums = new int [] {1,1,2,3};
        int[] nums = new int [] {1,1,3};
//        int[] nums = new int [] {1,1};
        LeetCode_26 leetCode_26 = new LeetCode_26();
        System.out.println(leetCode_26.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast ++;
        }
        return slow + 1;
    }
}
