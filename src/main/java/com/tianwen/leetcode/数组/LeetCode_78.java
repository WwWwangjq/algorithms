package com.tianwen.leetcode.数组;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2022年03月05日  21:24
 */
public class LeetCode_78 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3/*, 4, 5*/};
        LeetCode_78 leetCode_78 = new LeetCode_78();
        System.out.println(leetCode_78.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (Objects.isNull(nums)) {
            return null;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());
        for (int i = nums.length - 1; i > -1; i --) {
            int size = resultList.size();
            for (int j = 0; j < size; j ++) {
                List<Integer> tempList = new ArrayList<>(resultList.get(j));
                tempList.add(nums[i]);
                resultList.add(tempList);
            }
        }
        return resultList;

    }
}
