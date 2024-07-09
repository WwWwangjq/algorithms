package com.tianwen.leetcode_2023_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年11月24日 12:56
 */
public class LeetCode_1 {
    public int[] twoSum(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                int[] result = new int[2];
                result[0] = Math.min(i, map.get(target - num));
                result[1] = Math.max(i, map.get(target - num));
                return result;
            }
            map.put(num, i);
        }
        return new int[2];
    }
}
