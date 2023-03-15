package com.tianwen.leetcode_2021.offer;

/**
 * wangjq
 * 2021年01月02日  17:09
 */
public class Algorithms56_2_Bit_Operation {


    private static int singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] aux = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                aux[i] += num & 1;
                num >>>= 1;
            }
        }
        int result = 0;
        int m = 3;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= aux[31 - i] % m;
        }
        return result;
    }
}
