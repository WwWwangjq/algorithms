package com.tianwen.leetcode_2021.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * wangjq
 * 2021年01月04日  23:54
 */
public class Algorithms61_Is_Straight {

    private static boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int min = 14;
        int max = 0;
        List<Integer> list = new ArrayList<>(5);
        for (int n : nums) {
            if (n == 0) {
                continue;
            }
            if (list.contains(n)) {
                return false;
            }
            list.add(n);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return max - min < 5;
    }
}
