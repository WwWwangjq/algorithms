package com.tianwen.leetcode.双指针;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月14日  21:03
 */
public class LeetCode_125 {
    public static void main(String[] args) {
        LeetCode_125 leetCode_125 = new LeetCode_125();
//        String s = "";
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
        String s = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
        System.out.println(leetCode_125.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if (Objects.isNull(s)) {
            return false;
        }
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        if (s.length() <= 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
