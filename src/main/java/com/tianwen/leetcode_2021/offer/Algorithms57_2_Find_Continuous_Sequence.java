package com.tianwen.leetcode_2021.offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * wangjq
 * 2021年01月02日  18:41
 */
public class Algorithms57_2_Find_Continuous_Sequence {

    public static void main(String[] args) {
//        int target = 15;
        int target = 9;
        int[][] continuousSequence = findContinuousSequence(target);
        for (int[] nums : continuousSequence) {
            System.out.println(Arrays.toString(nums));
        }
    }

    private static int[][] findContinuousSequence(int target) {
        if (target == 0) {
            return new int[0][];
        }
        int endNum = ((target & 1) == 1 ? target + 1 : target) >> 1;
        LinkedList<int[]> result = new LinkedList<>();

        int j = endNum;
        int i = endNum - 1;
        int sum = j;
        while (i > 0) {
            sum = i + sum;
            if (sum >= target) {
                if (sum == target) {
                    int[] ret = new int[j - i + 1];
                    int temp = i;
                    for (int start = 0; start < ret.length; start++) {
                        ret[start] = temp ++;
                    }
                    result.addFirst(ret);
                }
                sum -= j;
                j--;
            }
            i--;
        }
        return result.toArray(new int [][] {});
    }
}
