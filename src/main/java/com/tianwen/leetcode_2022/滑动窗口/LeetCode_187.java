package com.tianwen.leetcode_2022.滑动窗口;

import java.util.*;

/**
 * wangjq
 * 2022年04月18日  21:05
 */
public class LeetCode_187 {

    public static void main(String[] args) {
        LeetCode_187 leetCode_187 = new LeetCode_187();
//        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s = "AAAAAAAAAAAAA";
        System.out.println(leetCode_187.findRepeatedDnaSequences(s));;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (Objects.isNull(s) || s.length() < 10) {
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        int sub = 0;
        StringBuilder builder = new StringBuilder();
        while (sub < s.length()) {
            char c = s.charAt(sub);
            builder.append(c);
            if (builder.length() == 10) {
                String key = builder.toString();
                map.put(key, map.getOrDefault(key, 0) + 1);
                builder.deleteCharAt(0);
            }
            sub ++;
        }
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                resultList.add(entry.getKey());
            }
        }
        return resultList;
    }
}
