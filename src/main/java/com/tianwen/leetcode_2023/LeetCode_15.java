package com.tianwen.leetcode_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月12日 10:20
 */
public class LeetCode_15 {

    public static void main(String[] args) {
//        int[] nums = new int [] {-1,0,1,2,-1,-4};
        int[] nums = new int [] {-2,0,0,2,2};
        LeetCode_15 leetCode15 = new LeetCode_15();
        System.out.println(leetCode15.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 3) {
            return new ArrayList<>();
        }
        quickSort(nums, 0, nums.length - 1);
        return findResult(nums);
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
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }

    private List<List<Integer>> findResult(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i ++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int iNum = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int leftNum = nums[left], rightNum = nums[right];
                int tempSum = iNum + leftNum + rightNum;
                if (tempSum < 0) {
                    left ++;
                } else if (tempSum > 0) {
                    right --;
                } else {
                    resultList.add(Arrays.asList(iNum, leftNum, rightNum));
                    while (left < right) {
                        if (leftNum == nums[++left]) {
                            continue;
                        }
                        break;
                    }
                    while (left < right) {
                        if (rightNum == nums[--right]) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        return resultList;
    }
}
