package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2022年03月07日 15:11
 */
public class LeetCode_80 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
//        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
//        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        LeetCode_80 leetCode_80 = new LeetCode_80();
        System.out.println(leetCode_80.removeDuplicates(nums));;
    }

    private int count = 0;

    public int removeDuplicates(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        count(nums, 0, 1);
        return count;
    }

    private void count(int[] nums, int left, int right) {
        if (left > nums.length - 1) {
            return;
        }
        int curCount = 1;
        while (right < nums.length && nums[left] == nums[right]) {
            right += 1;
            if (curCount < 2) {
                curCount += 1;
            }
        }
        count += curCount;
        count(nums, right, right + 1);
    }
}
