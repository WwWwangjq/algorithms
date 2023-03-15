package com.tianwen.leetcode_2021.offer;

/**
 * wangjq
 * 2020年12月08日  23:45
 */
public class Algorithms19_Pattern {

    private final static char DIT = '.';
    private final static char ASTERISK = '*';

    /**
     * . 任意字符
     * * 前一个字符0或者多次
     *
     * @param args
     */
    public static void main(String[] args) {
//        String pattern = "a*a";
//        String pattern = "a.ab*";
//        String pattern = "ab*ac*a";
//        String pattern = "aa.a";
//        String pattern = "ab*a";
//        String pattern = "ab*aab*";
//        String pattern = ".*a*a";
//        String pattern = ".*";
        String pattern = "ab*";

//        String str = "aaa";
//        String str = "bbbba";
//        String str = "";
        String str = "a";
        System.out.println(regex(str, pattern));
    }

    private static boolean regex(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        return regex(str, 0, pattern, 0);
    }

    private static boolean regex(char[] str, int i, char[] pattern, int j) {
        int sLength = str.length;
        int pLength = pattern.length;
        // 字符串走完
        if (i == sLength) {
            // 正则走完 true
            if (j == pLength) {
                return true;
            }
            if (j + 1 < pLength && pattern[j + 1] == ASTERISK) {
                return regex(str, i, pattern, j + 2);
            }
            return false;
        }
        // 字符串未走完 正则走完 false
        if (j == pLength) {
            return false;
        }
        char s = str[i];
        char p = pattern[j];
        if (j + 1 == pLength || pattern[j + 1] != ASTERISK) {
            // 单字符
            // 不匹配
            if (p != DIT && p != s) {
                return false;
            } else {
                return regex(str, i + 1, pattern, j + 1);
            }
        } else {
            // 长匹配模式
            // 不匹配
            if (p != DIT && p != s) {
                return regex(str, i, pattern, j + 2);
            } else {
                // 匹配的话正则有三种情况
                // 1 正则位置不变
                // 2 正则往后推两位
                // 3 字符串指针不变 正则往后推两位
                return regex(str, i + 1, pattern, j) || regex(str, i + 1, pattern, j + 2) || regex(str, i, pattern, j + 2);
            }
        }
    }

}
