package com.tianwen.leetcode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * wangjq
 * 2022年04月01日  16:03
 */
public class LeetCode_119 {

    public static void main(String[] args) {
        LeetCode_119 leetCode_119 = new LeetCode_119();
        int numRows = 3;
        List<Integer> list = leetCode_119.getRow(numRows);
        System.out.println(list);
    }

    public List<Integer> getRow(int rowIndex) {
        rowIndex += 1;
        List<Integer> firstLevel = Arrays.asList(1);
        List<Integer> secondLevel = Arrays.asList(1, 1);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int level = 1; level <= rowIndex; level ++) {
            if (level == 1) {
                resultList.add(firstLevel);
            } else if (level == 2) {
                resultList.add(secondLevel);
            } else {
                generate(resultList.get(level - 2), level, resultList);
            }
        }
        return resultList.get(rowIndex - 1);
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
