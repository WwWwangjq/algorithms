package com.tianwen.leetcode_2022.数组;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2021年05月09日  12:09
 */
public class LeetCode_66 {

    public static void main(String[] args) {
//        int[] digits = new int [] {1,2,3};
//        int[] digits = new int [] {4,3,2,1};
        int[] digits = new int [] {7,9,9,9};
//        int[] digits = new int [] {9,9,9,9};
        LeetCode_66 leetCode_66 = new LeetCode_66();
        System.out.println(Arrays.toString(leetCode_66.plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        if (Objects.isNull(digits) || digits.length == 0) {
            return new int[0];
        }
        return plusOne(digits, digits.length - 1);
    }

    private int[] plusOne(int[] digits, int sub) {
        if (digits[sub] != 9) {
            digits[sub] += 1;
            return digits;
        } else if (sub == 0) {
            digits[sub] = 0;
            return reCreate(digits);
        } else {
            digits[sub] = 0;
            return plusOne(digits, sub - 1);
        }
    }

    private int[] reCreate(int[] digits) {
        int[] newArr = new int[digits.length + 1];
        newArr[0] = 1;
        System.arraycopy(digits, 0, newArr, 1, newArr.length - 1);
        return newArr;
    }
}
