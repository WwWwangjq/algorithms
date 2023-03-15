package com.tianwen.leetcode_2022.数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月05日  16:00
 */
public class LeetCode_46 {

    /**
     * //输入：nums = [1,2,3]
     * //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static void main(String[] args) {
        LeetCode_46 leetCode_46 = new LeetCode_46();
        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{1};
        List<List<Integer>> list = leetCode_46.permute(nums);
        System.out.println(list);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (Objects.isNull(nums)) {
            return new ArrayList<>();
        }
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
            if (used[i]) {
                continue;
            }
            used[i] = true;
            result.addLast(nums[i]);
            recur(result, nums, used, length + 1);
            used[i] = false;
            result.removeLast();
        }
    }
}
