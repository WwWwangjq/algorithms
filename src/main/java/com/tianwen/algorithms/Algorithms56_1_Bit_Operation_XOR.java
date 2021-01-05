package com.tianwen.algorithms;

import java.util.Arrays;

/**
 * wangjq
 * 2021年01月02日  16:05
 */
public class Algorithms56_1_Bit_Operation_XOR {

    public static void main(String[] args) {
//        int[] nums = new int [] {4,1,4,6};
        int[] nums = new int[]{1, 2, 5, 2};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

    private static int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        int flag = 1;
        while ((flag & result) == 0) {
            flag <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & flag) == flag) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }

}
