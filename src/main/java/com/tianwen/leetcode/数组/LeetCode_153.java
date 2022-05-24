package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月10日  16:49
 */
public class LeetCode_153 {
    /**
     * //输入：nums = [3,4,5,1,2]
     * //输出：1
     * //解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [4,5,6,7,0,1,2]
     * //输出：0
     * //解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [11,13,15,17]
     * //输出：11
     * //解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_153 leetCode_153 = new LeetCode_153();
//        int[] nums = new int[] {3,4,5,1,2};
//        int[] nums = new int[] {4,5,6,7,0,1,2};
        int[] nums = new int[] {11,13,15,17};
//        int[] nums = new int[] {11,13};
        System.out.println(leetCode_153.findMin(nums));
    }

    public int findMin(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
