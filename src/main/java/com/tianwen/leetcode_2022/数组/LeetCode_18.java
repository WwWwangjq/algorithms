package com.tianwen.leetcode_2022.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月04日  13:17
 */
public class LeetCode_18 {

    public static void main(String[] args) {
        LeetCode_18 leetCode_18 = new LeetCode_18();
        int[] nums = new int[] {1,0,-1,0,0,-2,2,3,2,-1,-2,-2,3,4,-4,-2,-1};
        int target = 0;
        List<List<Integer>> list = leetCode_18.fourSum(nums, target);
        System.out.println(list);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (Objects.isNull(nums) || nums.length < 4) {
            return resultList;
        }
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 3; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j ++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int leftSub = j + 1;
                int rightSub = nums.length - 1;
                while (leftSub < rightSub) {
                    int curSum = nums[i] + nums[j] + nums[leftSub] + nums[rightSub];
                    if (curSum < target) {
                        leftSub ++;
                    } else if (curSum > target) {
                        rightSub --;
                    } else{
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[leftSub], nums[rightSub]));
                        while (leftSub < rightSub && nums[rightSub] == nums[rightSub - 1]) {
                            rightSub --;
                        }
                        while (leftSub < rightSub && nums[leftSub] == nums[leftSub + 1]) {
                            leftSub ++;
                        }
                        leftSub ++;
                        rightSub --;
                    }
                }
            }
        }
        return resultList;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        if (partition > left) {
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
                if (i != mid) {
                    swap(nums, i, mid);
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

    private void addResult(int numsI, int numsJ, int numsLeft, int numsRight, List<List<Integer>> list) {
        // repetition
        for (List<Integer> l : list) {
            if (l.get(0) == numsI && l.get(1) == numsJ && l.get(2) == numsLeft && l.get(3) == numsRight) {
                return;
            }
        }
        list.add(Arrays.asList(numsI, numsJ, numsLeft, numsRight));
    }

    private int[] removeDuplicates(int[] nums) {
        int repetition = 0;
        int same = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1] && repetition < 1) {
                    repetition ++;
                } else if (nums[i] == nums[i + 1]) {
                    repetition ++;
                    same ++;
                } else {
                    repetition = 0;
                }
            }
        }

        repetition = 0;
        int j = 0;
        int[] result = new int [nums.length - same];
        for (int i = 0; i < nums.length; i ++) {
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1] && repetition < 1) {
                    result[j ++] = nums[i];
                    repetition ++;
                } else if (nums[i] == nums[i + 1]) {
                    repetition ++;
                } else {
                    result[j ++] = nums[i];
                    repetition = 0;
                }
            } else if (repetition == 0) {
                result[j ++] = nums[i];
            }
        }
        return result;
    }
}
