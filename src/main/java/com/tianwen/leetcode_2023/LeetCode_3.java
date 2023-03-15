package com.tianwen.leetcode_2023;

import java.util.*;

/**
 * @Author: wangjq
 * @Date: 2023年03月10日 8:30
 */
public class LeetCode_3 {
    // abcabcbb
    // pwwkew
    public int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s)) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char key = s.charAt(right);
            if (set.contains(key)) {
                set.remove(s.charAt(left));
                left ++;
            } else {
                set.add(key);
                maxSize = Math.max(maxSize, set.size());
                right ++;
            }
        }
        return maxSize;
    }
    private int maxSize;
}
