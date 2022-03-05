package com.tianwen.leetcode.数组;

import java.util.*;

/**
 * wangjq
 * 2021年04月25日  23:28
 */
public class LeetCode_39 {

    public static void main(String[] args) {
        LeetCode_39 leetCode_39 = new LeetCode_39();
        int[] candidates = new int[] {2,3,6,7};
        int target = 7;
        leetCode_39.combinationSum(candidates, target).forEach(System.out::println);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (Objects.isNull(candidates) || candidates.length == 0) {
            return Collections.emptyList();
        }
        recur(candidates, target, 0, 0, new LinkedList<>());
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    private void recur(int[] candidates, int target, int sub, int curSum, LinkedList<Integer> list) {
        if (curSum == target) {
            result.add(new ArrayList<>(list));
        } else if (curSum < target) {
            for (int i = sub; i < candidates.length; i++) {
                list.add(candidates[i]);
                recur(candidates, target, i, curSum + candidates[i], list);
                list.removeLast();
            }
        }
    }
}
