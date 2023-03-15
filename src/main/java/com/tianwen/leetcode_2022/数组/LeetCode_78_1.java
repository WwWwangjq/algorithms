package com.tianwen.leetcode_2022.数组;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月08日  0:16
 */
public class LeetCode_78_1 {

    public static void main(String[] args) {
        int[] nums = new int [] {1, 2, 3};
        LeetCode_78_1 leetCode_78_1 = new LeetCode_78_1();
        System.out.println(leetCode_78_1.subsets(nums));
    }

    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (Objects.isNull(nums)) {
            return null;
        }
        recur(nums, 0);
        return resultList;
    }

    private void recur(int[] nums, int sub) {
        if (sub == nums.length) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        result.add(nums[sub]);
        recur(nums, sub + 1);
        result.remove(result.size() - 1);
        recur(nums, sub + 1);
    }
}
