package com.tianwen.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangjq
 * @Date: 2022年03月07日 11:15
 */
public class LeetCode_77 {

    // 1, 2, 3, 4, 5
    // 3

    public static void main(String[] args) {
        LeetCode_77 leetCode_77 = new LeetCode_77();
        int n = 5;
        int k = 3;
        System.out.println(leetCode_77.combine(n, k));
    }

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1) {
            return new ArrayList<>();
        }
        collect(1, n - k + 1, k, new ArrayList<>());
        return resultList;
    }

    private void collect(int s, int e, int k, List<Integer> list) {
        if (list.size() == k) {
            resultList.add(list);
            return;
        }
        for (int i = s; i <= e; i ++) {
            List<Integer> curList = new ArrayList<>(list);
            curList.add(i);
            collect(i + 1, e + 1, k, curList);
        }
    }


}
