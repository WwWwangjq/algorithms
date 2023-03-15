package com.tianwen.leetcode_2022.滑动窗口;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月17日  11:58
 */
public class LeetCode_424 {

    /**
     * //输入：s = "ABAB", k = 2
     * //输出：4
     * //解释：用两个'A'替换为两个'B',反之亦然。
     * //
     * //输入：s = "AABABBA", k = 1
     * //输出：4
     */
    public static void main(String[] args) {
        LeetCode_424 leetCode_424 = new LeetCode_424();
//        String s = "ABAB";
//        int k = 2;
        String s = "ABAA";
        int k = 0;
//        String s = "AABABBA";
//        int k = 1;
        System.out.println(leetCode_424.characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {
        if (Objects.isNull(s)) {
            return 0;
        }
        int[] nums = new int[26];
        int left = 0;
        int right = 0;
        int hisMaxCount = 0;
        while (right < s.length()) {
            int sub = s.charAt(right) - 'A';
            nums[sub] += 1;
            hisMaxCount = Math.max(hisMaxCount, nums[sub]);
            if (right - left + 1 > hisMaxCount + k) {
                nums[s.charAt(left) - 'A'] -= 1;
                left ++;
            }
            right ++;
        }
        return right - left;
    }

}
