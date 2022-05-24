package com.tianwen.leetcode.数组;

/**
 * wangjq
 * 2022年04月11日  23:02
 */
public class LeetCode_169 {

    /**
     * //输入：[3,2,3]
     * //输出：3
     * //
     * // 示例 2：
     * //
     * //
     * //输入：[2,2,1,1,1,2,2]
     * //输出：2
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_169 leetCode_169 = new LeetCode_169();
//        int[] nums = new int [] {3,2,3};
        int[] nums = new int [] {3,2,3,2,3};
//        int[] nums = new int [] {3,3};
        System.out.println(leetCode_169.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int count = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (result != nums[i]) {
                if (count > 1) {
                    count --;
                } else {
                    result = nums[i];
                }
            } else {
                count ++;
            }
        }
        return result;
    }

/*    public int majorityElement(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return Integer.MAX_VALUE;
        } else if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1]) {
                count ++;
                if (count > nums.length >> 1) {
                    return nums[i];
                }
            } else {
                count = 1;
            }
        }
        return Integer.MAX_VALUE;
    }*/
}
