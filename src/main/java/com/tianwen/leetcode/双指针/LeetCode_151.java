package com.tianwen.leetcode.双指针;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月16日  11:56
 */
public class LeetCode_151 {

    /**
     *
     //输入：s = "the sky is blue"
     //输出："blue is sky the"
     //
     //
     // 示例 2：
     //
     //
     //输入：s = "  hello world  "
     //输出："world hello"
     //解释：颠倒后的字符串中不能存在前导空格和尾随空格。
     //
     //
     // 示例 3：
     //
     //
     //输入：s = "a good   example"
     //输出："example good a"
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_151 leetCode_151 = new LeetCode_151();
//        String s =   "the sky is   blue  ";
        String s = "  hello   world  ";
        System.out.println(leetCode_151.reverseWords(s));
//        System.out.println(leetCode_151.trimSpaces(s));
    }

    /**
     *   hello world  
     *   dlrow olleh
     *   world hello
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return s;
        }
        StringBuilder builder = trimSpaces(s);
        revertWord(builder, 0, builder.length() - 1);
        revertSentence(builder);
        return builder.toString();
    }

    private StringBuilder trimSpaces(String s) {
        int length = s.length();
        int left = 0;
        int right = length - 1;
        StringBuilder builder = new StringBuilder();
        while (' ' == s.charAt(left)) {
            left ++;
        }
        while (' ' == s.charAt(right)) {
            right--;
        }
        while (left <= right) {
            char c = s.charAt(left);
            if (' ' != c || ' ' != s.charAt(left - 1)) {
                builder.append(s.charAt(left));
            }
            left++;
        }
        return builder;
    }

    private void revertSentence(StringBuilder s) {
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            while (end < s.length() && ' ' != s.charAt(end)) {
                end ++;
            }
            revertWord(s, start, end - 1);
            end ++;
            start = end;
        }
    }

    private void revertWord(StringBuilder s, int left, int right) {
        while (left < right) {
            char sLeft = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, sLeft);
            left ++;
            right --;
        }
    }

/*    public String reverseWords(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return s;
        }
        s = s.trim();
        System.out.println(s);
        String[] sArr = s.split("\\s+");
        List<String> list = Arrays.asList(sArr);
        Collections.reverse(list);
        return String.join(" ", list);

    }*/
}
