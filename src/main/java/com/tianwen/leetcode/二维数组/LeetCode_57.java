package com.tianwen.leetcode.二维数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2021年05月09日  18:34
 */
public class LeetCode_57 {

    public static void main(String[] args) {
/*        int[][] intervals = new int[][]{
                new int[]{1, 5},
        };
        int[] newInterval = new int[] {2,7};*/
/*        int[][] intervals = new int[][]{
                new int[]{1, 5},
        };
        int[] newInterval = new int[] {6,8};*/
/*        int[][] intervals = new int[0][];
        int[] newInterval = new int[] {5,7};*/
/*        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{6, 9},
        };
        int[] newInterval = new int[] {2,5};*/
/*        int[][] intervals = new int[][]{
                new int[]{1,5},
        };
        int[] newInterval = new int[] {0,0};*/
/*        int[][] intervals = new int[][]{
                new int[]{1, 2},
                new int[]{3, 5},
                new int[]{6, 7},
                new int[]{8, 10},
                new int[]{12, 16},
        };
        int[] newInterval = new int[] {4,8};*/
        int[][] intervals = new int[][]{
                new int[]{3, 5},
                new int[]{12, 15},
        };
        int[] newInterval = new int[] {17,18};
        LeetCode_57 leetCode_57 = new LeetCode_57();
        intervals = leetCode_57.insert(intervals, newInterval);
        for (int[] nums : intervals) {
            System.out.println("insert: " + Arrays.toString(nums));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (Objects.isNull(intervals) || intervals.length == 0 || intervals[0].length == 0) {
            return new int[][] {newInterval};
        }
        List<int[]> resultList = new ArrayList<>();
        int[] first = intervals[0];
        if (newInterval[1] < first[0]) {
            resultList.add(newInterval);
        }
        int[] mergeInt = new int[] {newInterval[0], newInterval[1]};
        boolean add = true;
        for (int i = 0; i < intervals.length; i++) {
            int[] curInt = intervals[i];
            if (curInt[1] < newInterval[0] || newInterval[1] < curInt[0]) {
                resultList.add(curInt);
                if (i + 1 < intervals.length) {
                    int[] post = intervals[i + 1];
                    if (curInt[1] < newInterval[0] && newInterval[1] < post[0]) {
                        resultList.add(newInterval);
                    }
                }
                if (i == intervals.length - 1) {
                    add = false;
                }
            } else {
                mergeInt[0] = Math.min(mergeInt[0], curInt[0]);
                mergeInt[1] = Math.max(mergeInt[1], curInt[1]);
                if (i + 1 < intervals.length) {
                    int[] post = intervals[i + 1];
                    if (newInterval[1] < post[0]) {
                        resultList.add(mergeInt);
                    }
                }
            }
        }
        if (add) {
            resultList.add(mergeInt);
        }
        int[] last = intervals[intervals.length - 1];
        if (newInterval[0] > last[1]) {
            resultList.add(newInterval);
        }
        return resultList.toArray(new int[][] {});
    }
}
