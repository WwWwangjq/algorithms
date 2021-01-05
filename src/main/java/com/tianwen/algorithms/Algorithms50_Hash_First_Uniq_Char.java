package com.tianwen.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * wangjq
 * 2021年01月01日  15:06
 */
public class Algorithms50_Hash_First_Uniq_Char {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(chars.length);
        for (char c : chars) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }

        for (char c : chars) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
