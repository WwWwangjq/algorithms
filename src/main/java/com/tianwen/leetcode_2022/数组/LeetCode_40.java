package com.tianwen.leetcode_2022.数组;

import java.util.*;

/**
 * wangjq
 * 2021年04月25日  23:50
 */
public class LeetCode_40 {

    public static void main(String[] args) {
        LeetCode_40 leetCode_40 = new LeetCode_40();
//        int[] candidates =  new int[] {10,1,2,7,6,1,5};
//        int target = 8;
        int[] candidates =  new int[] {2,5,2,1,2};
        int target = 5;
        leetCode_40.combinationSum2(candidates, target).forEach(System.out::println);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (Objects.isNull(candidates) || candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        recur(candidates, target, 0, 0, new LinkedList<>());
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    private void recur(int[] candidates, int target, int sub, int curSum, LinkedList<Integer> list) {
        if (curSum == target) {
            result.add(new ArrayList<>(list));
        } else if (curSum < target) {
            for (int i = sub; i < candidates.length; i++) {
                if (i > sub && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                recur(candidates, target, i + 1, curSum + candidates[i], list);
                list.removeLast();
            }
        }
    }
}
