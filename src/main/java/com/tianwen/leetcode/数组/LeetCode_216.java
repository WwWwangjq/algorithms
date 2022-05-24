package com.tianwen.leetcode.数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * wangjq
 * 2022年04月12日  22:07
 */
public class LeetCode_216 {
    /**
     * //输入: k = 3, n = 7
     * //输出: [[1,2,4]]
     * //解释:
     * //1 + 2 + 4 = 7
     * //没有其他符合的组合了。
     * //
     * // 示例 2:
     * //
     * //
     * //输入: k = 3, n = 9
     * //输出: [[1,2,6], [1,3,5], [2,3,4]]
     * //解释:
     * //1 + 2 + 6 = 9
     * //1 + 3 + 5 = 9
     * //2 + 3 + 4 = 9
     * //没有其他符合的组合了。
     * //
     * // 示例 3:
     * //
     * //
     * //输入: k = 4, n = 1
     * //输出: []
     */
    public static void main(String[] args) {
        LeetCode_216 leetCode_216 = new LeetCode_216();
//        int k = 3;
//        int n = 7;
//        int k = 3;
//        int n = 9;
//        int k = 4;
//        int n = 1;
        int k = 1;
        int n = 0;
        System.out.println(leetCode_216.combinationSum3(k, n));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        recur(0, 1, 0, new LinkedList<>(), k, n);
        return resultList;
    }

    List<List<Integer>> resultList = new ArrayList<>();

    private void recur(int sum, int sub, int count, LinkedList<Integer> result, int k, int n) {
        if (count == k && sum == n) {
            resultList.add(new ArrayList<>(result));
        } else if (count >= k || sum >= n) {
            return;
        }
        for (int num = sub; num < 10; num ++) {
            int curSum = sum + num;
            result.add(num);
            recur(curSum, num + 1, count + 1, result, k, n);
            result.removeLast();
        }
    }
}
