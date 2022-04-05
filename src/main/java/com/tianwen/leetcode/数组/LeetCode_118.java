package com.tianwen.leetcode.数组;

import com.tianwen.leetcode.LeetCode_;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * wangjq
 * 2022年04月01日  16:03
 */
public class LeetCode_118 {

    public static void main(String[] args) {
        LeetCode_118 leetCode_118 = new LeetCode_118();
        int numRows = 3;
        List<List<Integer>> list = leetCode_118.generate(numRows);
        System.out.println(list);
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<Integer> firstLevel = Arrays.asList(1);
        List<Integer> secondLevel = Arrays.asList(1, 1);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int level = 1; level <= numRows; level ++) {
            if (level == 1) {
                resultList.add(firstLevel);
            } else if (level == 2) {
                resultList.add(secondLevel);
            } else {
                generate(resultList.get(level - 2), level, resultList);
            }
        }
        return resultList;
    }

    private void generate(List<Integer> upperList, int level, List<List<Integer>> resultList) {
        List<Integer> result = new ArrayList<>(level);
        for (int n = 1; n <= level; n ++) {
            if (n == 1 || n == level) {
                result.add(1);
            } else {
                result.add(upperList.get(n - 2) + upperList.get(n - 1));
            }
        }
        resultList.add(result);
    }
}
