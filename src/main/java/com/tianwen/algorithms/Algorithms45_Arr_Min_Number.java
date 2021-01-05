package com.tianwen.algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * wangjq
 * 2020年12月30日  22:14
 */
public class Algorithms45_Arr_Min_Number {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
//        int[] nums = new int[]{325, 32};
        int[] nums = new int[]{1, 1, 1};
//        System.out.println(minNumber(nums));
/*        System.out.println(Arrays.toString(nums));
        String s = minNumber(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(s);*/
String  a = "111";
String  b = "111";
        System.out.println(a.compareTo(b));
    }

    public static String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        quickSort(nums, 0, nums.length - 1);
        return combineResult(nums);
    }

    private static String combineResult(int[] nums) {
        StringBuilder result = new StringBuilder();
        for (int i : nums) {
            result.append(i);
        }
        return result.toString();
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int small = partation(nums, start, end);
        if (small > start) {
            quickSort(nums, start, small);
        }
        if (small < end) {
            quickSort(nums, small + 1, end);
        }
    }

    private static int partation(int[] nums, int start, int end) {
        int rIndex = new Random().nextInt(end - start) + start;
        swap(nums, rIndex, end);
        int small = start;
        for (int i = start; i < end; i++) {
            if (isLessThen(nums[i], nums[end])) {
                if (i != small) {
                    swap(nums, small, i);
                }
                small ++;
            }
        }
        swap(nums, small, end);
        return small;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static boolean isLessThen(int a, int b) {
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        return (aStr + bStr).compareTo(bStr + aStr) < 0;
    }


}
