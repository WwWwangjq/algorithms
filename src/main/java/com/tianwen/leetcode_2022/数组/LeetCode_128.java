package com.tianwen.leetcode_2022.数组;

import java.util.*;

/**
 * wangjq
 * 2022年04月09日  11:25
 */
public class LeetCode_128 {
    public static void main(String[] args) {
//        int[] nums = new int [] {1,2,3,5,6,7,8,9};
//        int[] nums = new int[]{1, 3, 1};
//        int[] nums = new int[]{};
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
//        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        LeetCode_128 leetCode_128 = new LeetCode_128();
        System.out.println(leetCode_128.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 1;
            int nextNum = num + 1;
            while (set.contains(nextNum)) {
                nextNum ++;
                count ++;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    int result = 1;
}
