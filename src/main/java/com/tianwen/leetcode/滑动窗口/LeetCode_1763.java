package com.tianwen.leetcode.滑动窗口;

/**
 * wangjq
 * 2022年04月20日  21:10
 */
public class LeetCode_1763 {
    /**
     *
     //输入：s = "YazaAay"
     //输出："aAa"

     //输入：s = "dDzeE"
     //输出："dD"
     * @param args
     */
    public static void main(String[] args) {
        System.out.println('a' + 0);
        System.out.println('A' + 0);
        System.out.println(26 + 6);
    }

    public String longestNiceSubstring(String s) {
        boolean[] existArr = new boolean[58];
        for (int i = 0; i < s.length(); i ++) {
            existArr[s.charAt(i) - 'A'] = true;
        }
        int left = 0;
        int right = 0;
//        while ()
        return "";

    }
}
