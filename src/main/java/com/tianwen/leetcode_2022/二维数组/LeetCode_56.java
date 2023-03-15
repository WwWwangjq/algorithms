package com.tianwen.leetcode_2022.二维数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2021年05月09日  15:29
 */
public class LeetCode_56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                new int[]{1, 4},
                new int[]{2, 3},
/*
                new int[]{1, 4},
                new int[]{4, 5},
*/
/*
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{8, 9},
                new int[]{9, 9},
                new int[]{1, 3},
                new int[]{15, 18},
*/
        };

        LeetCode_56 leetCode_56 = new LeetCode_56();
        intervals = leetCode_56.merge(intervals);
        for (int[] nums : intervals) {
            System.out.println("sort: " + Arrays.toString(nums));
        }
        int[][] ints = leetCode_56.mergeSortArr(intervals);
        for (int[] nums : ints) {
            System.out.println("merge:" + Arrays.toString(nums));
        }
    }

    public int[][] merge(int[][] intervals) {
        if (Objects.isNull(intervals) || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][];
        }
        quickSort(intervals, 0, intervals.length - 1);
        return mergeSortArr(intervals);
    }

    private void quickSort(int[][] intervals, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(intervals, left, right);
        if (left < partition) {
            quickSort(intervals, left, partition);
        }
        if (partition < right) {
            quickSort(intervals, partition + 1, right);
        }
    }

    private int partition(int[][] intervals, int left, int right) {
        int small = left;
        int[] compare = intervals[left];
        swap(intervals, left, right);
        for (int i = left; i < right; i ++) {
            int[] temp = intervals[i];
            if (temp[0] < compare[0] ||
                    temp[0] == compare[0] && temp[1] < compare[1]) {
                swap(intervals, small, i);
                small ++;
            }
        }
        swap(intervals, small, right);
        return small;
    }

    private void swap(int[][] intervals, int i, int j) {
        int[] temp = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = temp;
    }
    
    private int[][] mergeSortArr(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        int[] curInt = new int[] {intervals[0][0], intervals[0][1]};
        for (int i = 0; i < intervals.length; i++) {
            if (i + 1 < intervals.length) {
                int[] pre = curInt;
                int[] post = intervals[i + 1];
                if (pre[0] == post[0] && pre[1] == post[1]) {
                    continue;
                } else if ((pre[0] == post[0] && pre[1] < post[1])) {
                    curInt[1] = post[1];
                } else if ((pre[0] != post[0] && pre[1] >= post[0])) {
                    curInt[1] = Math.max(pre[1], post[1]);
                } else if (pre[0] != post[0] && pre[1] < post[1]) {
                    resultList.add(curInt);
                    curInt = new int[] {post[0], post[1]};
                }
            } else {
                resultList.add(curInt);
            }
        }
        return resultList.toArray(new int[][] {});
    }
}
