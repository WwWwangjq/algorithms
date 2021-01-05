package com.tianwen.algorithms;

/**
 * wangjq
 * 2021年01月02日  20:03
 */
public class Algorithms58_2_Reverse_Left_Words {

    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        System.out.println(reverseLeftWords(s, n));
    }

    private static String reverseLeftWords(String s, int n) {
        String pre = s.substring(0, n);
        String post = s.substring(n);
        return post + pre;
    }

/*    private static String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0 || n == 0) {
            return "";
        }
        char[] preArr = new char[n];
        int pre = 0;
        char[] postArr = new char[s.length() - n];
        int post = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            char c = s.charAt(i);
            if (i < n) {
                preArr[pre ++] = c;
            } else {
                postArr[post ++] = c;
            }
        }
        return new String(postArr) + new String(preArr);
    }*/
}
