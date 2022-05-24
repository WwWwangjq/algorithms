package com.tianwen.leetcode.数组;

import java.util.*;

/**
 * wangjq
 * 2022年04月07日  23:17
 */
public class LeetCode_90 {

    /**
     *
     //输入：nums = [1,2,2]
     //输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     */
    public static void main(String[] args) {
        LeetCode_90 leetCode_90 = new LeetCode_90();
//        int[] nums = new int [] {1, 2, 3};
        int[] nums = new int [] {1, 2, 2};
//        int[] nums = new int [] {1, 2, 2, 3, 3};
        System.out.println(leetCode_90.subsetsWithDup(nums));
    }

//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (Objects.isNull(nums)) {
            return resultList;
        }
        Arrays.sort(nums);
        recur(false, 0, nums);
        return resultList;
    }

    private List<List<Integer>> resultList = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();

    private void recur(boolean preUse, int sub, int[] nums) {
        if (sub == nums.length) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        recur(false, sub + 1, nums);
        if (!preUse && sub > 0 && nums[sub] == nums[sub - 1]) {
            return;
        }
        result.add(nums[sub]);
        recur(true, sub + 1, nums);
        result.remove(result.size() - 1);
    }
}
