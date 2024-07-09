package com.tianwen.leetcode_2023_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年11月23日 14:46
 */
public class LeetCode_3 {

    public int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s)) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            Character c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                max = Math.max(max, right - left);
                left = map.remove(c) + 1;
            }
            map.put(c, right);
            right++;
        }
        max = Math.max(max, right - left);
        return max;
    }
}
