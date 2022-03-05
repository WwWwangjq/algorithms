package com.tianwen.leetcode.双指针;

import java.util.HashSet;

/**
 * wangjq
 * 2021年05月22日  16:57
 */
public class LeetCode_3 {

    public static void main(String[] args) {
        LeetCode_3 leetCode_3 = new LeetCode_3();
        String s = "pwwkew";
        System.out.println(leetCode_3.lengthOfLongestSubstring(s));
    }


    //输入: s = "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> windowSet = new HashSet<>();
        int left = 0, right = 0, max = 0;
        while (right < chars.length) {
            Character c1 = chars[right];
            if (!windowSet.contains(c1)) {
                windowSet.add(c1);
                max = Math.max(max, right - left + 1);
                right ++;
            } else {
                windowSet.remove(chars[left ++]);
            }
        }
        return max;
    }
}
