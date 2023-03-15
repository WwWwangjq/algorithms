package com.tianwen.leetcode_2021.offer;

import java.util.Random;

/**
 * wangjq
 * 2020年12月25日  0:14
 */
public class Algorithms39_Arr_Majority_Element {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 3, 2, 2};
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
//        int[] nums = new int[]{2, 2};
        System.out.println(majorityElement(nums));
    }

// 摩尔投票 互相抵消 超过一半的胜出
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = nums[0];
        int curCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
                curCount++;
            } else if (curCount == 0) {
                cur = nums[i];
                curCount++;
            } else {
                curCount--;
            }
        }
        return cur;
    }

// 哈希表
/*    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int num : nums) {
            hashMap.put(num,  hashMap.getOrDefault(num, 0) + 1);
            if (hashMap.get(num) > nums.length >> 1) {
                return num;
            }
        }
        return 0;
    }*/

// 先快排 再取中间数字
/*    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length >> 1];
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        Integer small = partition(nums, start, end);
        if (small > start) {
            quickSort(nums, start, small);
        }
        if (small < end) {
            quickSort(nums, small + 1, end);
        }
    }*/

// 超时
/*    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        quickSort(nums, 0, nums.length - 1, nums.length >> 1);
        return nums[nums.length >> 1];
    }*/

    private static void quickSort(int[] nums, int start, int end, int mid) {
        if (start >= end) {
            return;
        }
        int randomIndex = partition(nums, start, end);
        while (randomIndex != mid) {
            if (randomIndex > mid) {
                randomIndex = partition(nums, start, randomIndex - 1);
            } else {
                randomIndex = partition(nums, randomIndex + 1, end);
            }
        }
    }

    private static Integer partition(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int small = start;
        int randomIndex = new Random().nextInt(end - start) + start;
        // 将选中的数字放到最后
        swap(nums, randomIndex, end);
        for (int i = start; i < end; i ++) {
            if (nums[i] < nums[end]) {
                if (small != i) {
                    swap(nums, small, i);
                }
                small++;
            }
        }
        // 大于随机数的那一部分数组 第一位和最后一位交换
        swap(nums, small, end);
        return small;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
