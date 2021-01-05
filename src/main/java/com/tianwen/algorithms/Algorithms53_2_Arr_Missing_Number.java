package com.tianwen.algorithms;

/**
 * wangjq
 * 2021年01月01日  19:02
 */
public class Algorithms53_2_Arr_Missing_Number {

    public static void main(String[] args) {

    }

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (true) {
            int sub = getSub(start, end);
            if (sub != nums[sub]) {
                end = sub - 1;
                if (end >= 0 && nums[end] == end) {
                    return sub;
                }
            } else {
                start = sub + 1;
            }
            if (start > end) {
                return start;
            }
        }
    }

    private static int getSub(int start, int end) {
        return (start + end) >> 1;
    }


}
