package com.tianwen.leetcode_2023;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月12日 18:28
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                break;
            }
        }
        return result;
    }
}
