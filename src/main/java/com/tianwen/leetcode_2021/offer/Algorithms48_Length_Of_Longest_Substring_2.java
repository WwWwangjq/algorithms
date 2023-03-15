package com.tianwen.leetcode_2021.offer;

import java.util.*;

/**
 * wangjq
 * 2021年01月12日  21:43
 */
public class Algorithms48_Length_Of_Longest_Substring_2 {

    public static void main(String[] args) {
//        String str = "abcfgsadag";
//        String str = "aaaackdjgq";
//        String str = "";
        String str = "ab";
//        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int i = 0, j = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            // 更新滑动窗口右指针
            char cRight = s.charAt(j);
            map.put(cRight, map.getOrDefault(cRight, 0) + 1);
            j ++;

            // 如果现在的活动窗口不满足条件 更新滑动窗口左指针直至满足条件
            while (map.get(cRight) > 1) {
                char cLeft = s.charAt(i);
                map.put(cLeft, map.get(cLeft) - 1);
                i++;
            }
            result = Math.max(result, j - i);
        }
        return result;
    }
}
