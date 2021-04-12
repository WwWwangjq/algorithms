package com.tianwen.offer;

import java.util.Arrays;

/**
 * wangjq
 * 2020年12月13日  21:19
 */
public class Algorithms21_Arr_Sort_Odd_Even_Quick {


    /**
     * 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使的所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int [] {1,2,3,5,759,6,92,4,3,6,2,4,7,3,25,345,71165,17289};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int length = nums.length;
        int odd = 0;
        int even = length - 1;
        while (odd < even) {
            while (isOdd(nums[odd]) && odd < even) {
                odd++;
            }
            while (!isOdd(nums[even]) && odd < even) {
                even --;
            }
            if ((odd < even) ) {
                swap(nums, odd, even);
            }
        }
        return nums;
    }

    private static boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    private static void swap(int[] nums, int odd, int even) {
        int temp = nums[odd];
        nums[odd] = nums[even];
        nums[even] = temp;
    }
}
