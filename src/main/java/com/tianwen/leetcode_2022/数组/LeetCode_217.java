package com.tianwen.leetcode_2022.数组;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * wangjq
 * 2021年05月10日  23:49
 */
public class LeetCode_217 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,3,3,4,3,2,4,2};
        LeetCode_217 leetCode_217 = new LeetCode_217();
        System.out.println(leetCode_217.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            set.add(nums[i]);
            if (set.size() < i + 1) {
                return true;
            }
        }
        return false;
    }
}
