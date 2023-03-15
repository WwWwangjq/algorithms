package com.tianwen.leetcode_2022.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月05日  21:19
 */
public class LeetCode_55 {

    /**
     *
     //输入：nums = [2,3,1,1,4]
     //输出：true
     *
     //输入：nums = [3,2,1,0,4]
     //输出：false
     */
    public static void main(String[] args) {
        LeetCode_55 leetCode_55 = new LeetCode_55();
//        int[] nums = new int[] {3,0,0,3,1,1,4};
//        int[] nums = new int[] {3,2,1,0,4};
        int[] nums = new int[] {2, 0, 0};
        System.out.println(leetCode_55.canJump(nums));
    }

    int farthest = 0;

    public boolean canJump(int[] nums) {
        if (Objects.isNull(nums)) {
            return false;
        }
        for (int i = 0; i < nums.length; i ++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (farthest == i && nums[i] == 0 && i + 1 < nums.length) {
                return false;
            }
        }
        return farthest >= nums.length - 1;
    }
}
