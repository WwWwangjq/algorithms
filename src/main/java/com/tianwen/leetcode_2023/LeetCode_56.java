package com.tianwen.leetcode_2023;

import java.util.*;

/**
 * @Author: wangjq
 * @Date: 2023年03月24日 8:06
 */
public class LeetCode_56 {
    public static void main(String[] args) {
        LeetCode_56 leetCode56 = new LeetCode_56();
        // [[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
        int[][] intervals = new int[][] {
                new int [] {2,3},
                new int [] {2,2},
                new int [] {3,3},
                new int [] {1,3},
                new int [] {5,7},
                new int [] {2,2},
                new int [] {4,6},
        };
        System.out.println(Arrays.toString(leetCode56.merge(intervals)));
    }

    // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]] 输出：[[1,6],[8,10],[15,18]]
    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        if (Objects.isNull(intervals) || intervals.length == 0) {
            return resultList.toArray(new int[0][0]);
        }
        quickSort(intervals, 0, intervals.length - 1);
        int[] pre = intervals[0];
        int preLeft = pre[0];
        int preRight = pre[1];
        for (int i = 1; i < intervals.length; i ++) {
            int[] interval = intervals[i];
            int curLeft = interval[0];
            int curRight = interval[1];
            if (preRight >= curLeft) {
                preRight = Math.max(preRight, curRight);
            } else {
                resultList.add(new int[] {preLeft, preRight});
                preLeft = curLeft;
                preRight = curRight;
            }
        }
        resultList.add(new int[] {preLeft, preRight});
        return resultList.toArray(new int[][] {});
    }

    private void quickSort(int[][] intervals, int left, int right) {
        int partition = partition(intervals, left, right);
        if (partition > left) {
            quickSort(intervals, left, partition);
        }
        if (partition < right) {
            quickSort(intervals, partition + 1, right);
        }
    }

    private int partition(int[][] intervals, int left, int right) {
        int partition = left;
        swap(intervals, left, right);
        for (int i = left; i < right; i ++) {
            int[] temp = intervals[i];
            if (temp[0] < intervals[right][0] ||
                    (temp[0] == intervals[right][0] && temp[1] < intervals[right][1])) {
                if (partition != i) {
                    swap(intervals, partition, i);
                }
                partition ++;
            }
        }
        swap(intervals, partition, right);
        return partition;
    }

    private void swap(int[][] nums, int left, int right) {
        int[] temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
