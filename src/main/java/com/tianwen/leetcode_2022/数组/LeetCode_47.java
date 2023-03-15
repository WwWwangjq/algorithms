package com.tianwen.leetcode_2022.数组;

import java.util.*;

/**
 * wangjq
 * 2022年04月05日  16:52
 */
public class LeetCode_47 {
    /**
     *
     //输入：nums = [1,1,2]
     //输出：
     //[[1,1,2],
     // [1,2,1],
     // [2,1,1]]
     */
    public static void main(String[] args) {
        LeetCode_47 leetCode_47 = new LeetCode_47();
//        int[] nums = new int[]{1, 2, 3};
        int[] nums = new int[]{1, 2, 1, 1};
//        int[] nums = new int[]{1};
        List<List<Integer>> list = leetCode_47.permuteUnique(nums);
        System.out.println(list);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (Objects.isNull(nums)) {
            return new ArrayList<>();
        }
        quickSort(nums, 0, nums.length - 1);
        recur(new LinkedList<>(), nums, new boolean[nums.length], 0);
        return resultList;
    }

    private List<List<Integer>> resultList = new ArrayList<>();

    private void recur(LinkedList<Integer> result, int[] nums, boolean[] used, int length) {
        if (length == nums.length) {
            resultList.add(new LinkedList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i -1])) {
                continue;
            }
            used[i] = true;
            result.addLast(nums[i]);
            recur(result, nums, used, length + 1);
            used[i] = false;
            result.removeLast();
        }
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
}
