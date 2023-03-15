package com.tianwen.leetcode_2022.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月03日  11:15
 */
public class LeetCode_16 {

    public static void main(String[] args) {
//        int[] nums = new int [] {2, 1, -4, 6, 8, -3, -10};
//        int target = 3;
        int[] nums = new int [] {-1,2,1,-4};
        int target = 1;
//        int[] nums = new int [] {0,0,0};
//        int target = 1;
        LeetCode_16 leetCode_16 = new LeetCode_16();
        int result = leetCode_16.threeSumClosest(nums, target);
        System.out.println(result);
    }


    private int result = 0;
    private int abs = Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        quickSort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                suitVal(sum, target);
                if (sum < target) {
                    left ++;
                } else if (sum > target) {
                    right --;
                } else {
                    return result;
                }
            }
        }
        return result;
    }

    private void suitVal(int sum, int target) {
        int curAbs = Math.abs(sum - target);
        if (curAbs < abs) {
            abs = curAbs;
            result = sum;
        }
    }

    private void quickSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        if (left < partition) {
            quickSort(nums, left, partition);
        }
        if (partition < right) {
            quickSort(nums, partition + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int mid = left;
        swap(nums, left, right);
        for (int i = left; i < right; i ++) {
            if (nums[i] < nums[right]) {
                if (mid != i) {
                    swap(nums, mid, i);
                }
                mid ++;
            }
        }
        swap(nums, mid, right);
        return mid;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
