package com.tianwen.offer;

/**
 * wangjq
 * 2021年01月01日  17:01
 */
public class Algorithms53_1_Arr_Search {

    public static void main(String[] args) {
//        int[] nums = new int[] {2, 2};
//        int target = 2;
//        int[] nums = new int[] {5, 7, 7, 8, 8, 10};
//        int target = 8;
//        int[] nums = new int[] {1, 3};
//        int target = 1;
//        int[] nums = new int[] {1, 4};
//        int target = 4;
//        int[] nums = new int[] {1};
//        int target = 0;
//        int[] nums = new int[] {2, 2};
//        int target = 1;
        int[] nums = new int[] {1, 2, 3};
        int target = 2;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int sub = getSub(start, end);
        while (nums[sub] != target) {
            if (nums[sub] > target) {
                end = sub - 1;
            } else {
                start = sub + 1;
            }
            if (start > end) {
                return 0;
            }
            sub = getSub(start, end);
        }
        int s = getStart(nums, start, sub, target);
        int e = getEnd(nums, sub, end, target);
        return e - s + 1;
    }

    private static int getSub(int start, int end) {
        return (start + end) >> 1;
    }

    private static int getStart(int[] nums, int start, int end, int target) {
        int sub = end;
        while (!isStart(nums, sub, target)) {
            if (nums[sub] == target) {
                end = sub - 1;
            } else {
                start = sub + 1;
            }
            sub = getSub(start, end);
        }
        return sub;
    }

    private static int getEnd(int[] nums, int start, int end, int target) {
        int sub = start;
        while (!isEnd(nums, sub, target)) {
            if (nums[sub] == target) {
                start = sub + 1;
            } else {
                end = sub - 1;
            }
            sub = getSub(start, end);
        }
        return sub;
    }

    private static boolean isStart(int[] nums, int sub, int target) {
        return sub == 0 || (nums[sub] == target && nums[sub - 1] != nums [sub]);
    }

    private static boolean isEnd(int[] nums, int sub, int target) {
        return sub == nums.length - 1 || (nums[sub] == target && nums[sub] != nums [sub + 1]);
    }
}
