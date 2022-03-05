package com.tianwen.leetcode.双指针;

import java.util.*;

/**
 * wangjq
 * 2021年05月22日  17:49
 */
public class LeetCode_15 {

    //输入：nums = [-1,0,1,2,-1,-4]
    //输出：[[-1,-1,2],[-1,0,1]]

    public static void main(String[] args) {
        LeetCode_15 leetCode_15 = new LeetCode_15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -1};
        System.out.println(leetCode_15.threeSum(nums));
    }

    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return result;
        }
        quickSort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int iNum = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                int curSum = iNum + leftNum + rightNum;
                if (curSum > 0) {
                    right --;
                } else if (curSum < 0) {
                    left ++;
                } else {
                    result.add(Arrays.asList(iNum, leftNum, rightNum));
                    while (left < right && leftNum == nums[++ left]);
                    while (left < right && rightNum == nums[-- right]);
                }
            }
        }
        return result;
    }

    private void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        int partition = partition(nums, left, right);
        if (partition > left) {
            quickSort(nums, left, partition);
        }
        if (partition < right) {
            quickSort(nums, partition + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int partition = left;
        swap(nums, left, right);
        for (int i = left; i < right; i ++) {
            if (nums[i] < nums[right]) {
                if (partition != i) {
                    swap(nums, partition, i);
                }
                partition ++;
            }
        }
        swap(nums, partition, right);
        return partition;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
