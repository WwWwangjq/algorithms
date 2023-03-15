package com.tianwen.leetcode_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @Author: wangjq
 * @Date: 2023年03月13日 22:16
 */
public class LeetCode_20 {

    // "()"
    //"()[]{}"
    //"(]"
    //"[["
    //"}"
    //"{{}}"
    public boolean isValid(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character pop = stack.pop();
                if (c != map.get(pop)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
