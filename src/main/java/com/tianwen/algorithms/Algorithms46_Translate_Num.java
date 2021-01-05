package com.tianwen.algorithms;

/**
 * wangjq
 * 2020年12月30日  23:38
 */
public class Algorithms46_Translate_Num {

    public static void main(String[] args) {
//        int num = 129;
        int num = 0;
        System.out.println(translateNum(num));
    }

    private static int translateNum(int num) {
        int[] count = new int[1];
        char[] chars = String.valueOf(num).toCharArray();
        collect(chars, chars.length - 1, count);
        return count[0];
    }

    private static void collect(char[] chars, int cur, int[] count) {
        if (cur <= 0) {
            count[0] += 1;
            return;
        }
        collect(chars, cur - 1, count);
        if (isInScope(chars[cur - 1], chars[cur])) {
            collect(chars, cur - 2, count);
        }
    }

    private static boolean isInScope(char char1, char char2) {
        String s = new String(new char[]{char1, char2});
        return s.compareTo("10") >= 0 && s.compareTo("25") <= 0;
    }

}
