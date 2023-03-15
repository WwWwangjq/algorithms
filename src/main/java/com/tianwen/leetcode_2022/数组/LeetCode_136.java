package com.tianwen.leetcode_2022.数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2022年03月04日 16:47
 */
public class LeetCode_136 {

    public static void main(String[] args) {
        int[] nums = new int[] {4,-1,2,-1,2};
        LeetCode_136 leetCode136 = new LeetCode_136();
        System.out.println(leetCode136.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) - num : num);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
