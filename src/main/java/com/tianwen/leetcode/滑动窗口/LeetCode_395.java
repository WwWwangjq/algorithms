package com.tianwen.leetcode.滑动窗口;

import java.util.*;

/**
 * wangjq
 * 2022年04月17日  11:00
 */
public class LeetCode_395 {
    /**
     *
     //输入：s = "aaabb", k = 3
     //输出：3
     //解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     //
     //输入：s = "ababbc", k = 2
     //输出：5
     */
    public static void main(String[] args) {
        LeetCode_395 leetCode_395 = new LeetCode_395();
//        String s = "aaabb";
//        int k = 3;
//        String s = "ababbc";
//        int k = 2;
//        String s = "";
//        int k = 0;
        String s = "ababacb";
        int k = 3;
        System.out.println(leetCode_395.longestSubstring(s, k));
//        System.out.println('a');
//        System.out.println('0');
    }

    public int longestSubstring(String s, int k) {
        if (Objects.isNull(s) || s.length() < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k) {
                String[] strArr = s.split(String.valueOf(entry.getKey()));
                int result = 0;
                for (String str : strArr) {
                    result = Math.max(result, longestSubstring(str, k));
                }
                return result;
            }
        }
        return s.length();
    }

}
