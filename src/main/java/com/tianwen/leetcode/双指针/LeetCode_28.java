package com.tianwen.leetcode.双指针;

import java.util.Objects;

/**
 * wangjq
 * 2021年05月22日  20:35
 */
public class LeetCode_28 {

    //输入：haystack = "hello", needle = "ll"
    //输出：2
    //
    //输入：haystack = "aaaaa", needle = "bba"
    //输出：-1
    //
    //输入：haystack = "", needle = ""
    //输出：0

    public static void main(String[] args) {
/*        String haystack = "";
        String needle = "a";*/
/*
        String haystack = "aaaaa";
        String needle = "bba";
*/
/*
        String haystack = "aaaaa";
        String needle = "bba";
*/
        String haystack = "mississippi";
        String needle = "issip";
/*
        String haystack = "hello";
        String needle = "ll";
*/
        LeetCode_28 leetCode_28 =  new LeetCode_28();
        System.out.println(leetCode_28.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (Objects.isNull(needle) || needle.length() == 0) {
            return 0;
        }
        char[] hayArr = haystack.toCharArray();
        char[] needArr = needle.toCharArray();
        int leftH = 0;
        while (leftH < haystack.length()) {
            if (hayArr[leftH] == needArr[0]) {
                int i = leftH;
                int leftN = 0;
                while (i < haystack.length() && leftN < needle.length() && hayArr[i] == needArr[leftN]) {
                    if (leftN == needle.length() - 1) {
                        return leftH;
                    }
                    i ++;
                    leftN ++;
                }
            }
            leftH ++;
        }
        return -1;
    }
}
