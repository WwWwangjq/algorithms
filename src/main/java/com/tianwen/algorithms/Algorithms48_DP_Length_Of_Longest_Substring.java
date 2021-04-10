package com.tianwen.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * wangjq
 * 2021年01月01日  13:47
 */
public class Algorithms48_DP_Length_Of_Longest_Substring {

    public static void main(String[] args) {
        String str = "abcfgsadag";
        System.out.println(lengthOfLongestSubstring(str));
    }

/*    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int temp = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i ++) {
            char s = str.charAt(i);
            int j = i - 1;
            while (j >= 0 && s != str.charAt(j)) {
                j --;
            }
            temp = temp < i - j ? temp + 1 : i - j;
            result = Math.max(temp, result);
        }
        return result;
    }*/

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int temp = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            Integer j = map.getOrDefault(c, -1);
            map.put(c, i);
            temp = temp < i - j ? temp + 1 : i - j;
            result = Math.max(temp, result);
        }
        return result;
    }
}
