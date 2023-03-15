package com.tianwen.leetcode_2021.offer;

import java.util.Objects;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms5_String {

    final static char space = ' ';
    final static char[] replaceArr = new char[]{'%', '2', '0'};

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *  
     *
     * 限制：
     *
     * 0 <= s 的长度 <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == ' ') {
                count++;
            }
        }
        char[] resultArr = new char[s.length() + count * 2];
        int sub = 0;
        for (char c : chars) {
            if (c == ' ') {
                resultArr[sub++] = '%';
                resultArr[sub++] = '2';
                resultArr[sub++] = '0';
            } else {
                resultArr[sub++] = c;
            }
        }
        return new String(resultArr);
    }

}
