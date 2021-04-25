package com.tianwen.leetcode.arr;

import java.util.Objects;

/**
 * wangjq
 * 2021年04月24日  18:14
 */
public class LeetCode_27 {

    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        if (Objects.isNull(nums)) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == val) {
                fast ++;
            } else {
                nums[slow ++] = nums[fast++];
            }
        }
        return slow;
    }
}
