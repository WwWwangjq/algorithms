package com.tianwen.leetcode_2022.双指针;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月14日  22:45
 */
public class LeetCode_238 {

    /**
     //输入: nums = [1,2,3,4]
     //输出: [24,12,8,6]
     //
     //输入: nums = [-1,1,0,-3,3]
     //输出: [0,0,9,0,0]
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_238 leetCode_238 = new LeetCode_238();
//        int[] nums = new int[] {1,2,3,4};
//        int[] nums = new int[] {1,2,3,4,5};
        int[] nums = new int[] {2,3};
        System.out.println(Arrays.toString(leetCode_238.productExceptSelf(nums)));
    }


    public int[] productExceptSelf(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return nums;
        }
        int[] result = new int[nums.length];
        result[0] = 1;
        result[nums.length - 1] = 1;
        int left = 0;
        int right = nums.length - 1;
        int mid = nums.length >> 1;
        int positiveNum = 1;
        int negativeNum = 1;
        while (left < nums.length) {
            positiveNum = left == 0 ? 1 : positiveNum * nums[left - 1];
            negativeNum = right == nums.length - 1 ? 1 : negativeNum * nums[right + 1];
            if (left < mid) {
                result[left] = left == 0 ? nums[right] : result[left - 1] * nums[right];
                result[right] = right == nums.length - 1 ? nums[left] : result[right + 1] * nums[left];
            } else {
                result[left] =  left < nums.length - 1 ? positiveNum * result[nums.length - 2 - left] : positiveNum;
                result[right] = right > 0 ? negativeNum * result[nums.length - right] : negativeNum;
            }
            left ++;
            right --;
        }
        return result;
    }


    /*public int[] productExceptSelf(int[] nums) {
        if (Objects.isNull(nums)) {
            return new int[0];
        }
        int[] positiveArr = new int[nums.length];
        int[] negativeArr = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int positiveNum = 1;
        int negativeNum = 1;
        while (left < nums.length) {
            positiveNum *= nums[left];
            positiveArr[left] = positiveNum;
            left ++;

            negativeNum *= nums[right];
            negativeArr[right] = negativeNum;
            right --;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                result[i] = negativeArr[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = positiveArr[i - 1];
            } else {
                result[i] = positiveArr[i - 1] * negativeArr[i + 1];
            }
        }
        return result;
    }*/

}
