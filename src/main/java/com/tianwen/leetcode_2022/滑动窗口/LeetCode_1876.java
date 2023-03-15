package com.tianwen.leetcode_2022.滑动窗口;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月20日  21:34
 */
public class LeetCode_1876 {

    /**
     *
     //输入：s = "xyzzaz"
     //输出：1


     //输入：s = "aababcabc"
     //输出：4
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_1876 leetCode_1876 = new LeetCode_1876();
//        String s = "xyzzaz";
        String s = "aababcabc";
        System.out.println(leetCode_1876.countGoodSubstrings(s));
    }

    public int countGoodSubstrings(String s) {
        if (Objects.isNull(s)) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(26);
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            char rightKey = s.charAt(right);
            map.put(rightKey, map.getOrDefault(rightKey, 0) + 1);
            if (right - left + 1 == 3) {
                if (map.size() == 3) {
                    count += 1;
                }
                char leftKey = s.charAt(left);
                Integer leftCount = map.get(leftKey);
                if (leftCount == 1) {
                    map.remove(leftKey);
                } else {
                    map.put(leftKey, leftCount - 1);
                }
                left ++;
            }
            right ++;
        }
        return count;
    }
}
