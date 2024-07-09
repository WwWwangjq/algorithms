package com.tianwen.leetcode_2022.数组;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: wangjq
 * @Date: 2024年07月09日 22:14
 */
public class LeetCode_150 {

    private final static Set<String> SET = new HashSet<>();

    static {
        SET.add("+");
        SET.add("-");
        SET.add("*");
        SET.add("/");
    }

    public static void main(String[] args) {
        String[] tokens = new String[] {"4","13","5","/","+"};
        LeetCode_150 leetCode150 = new LeetCode_150();
        System.out.println(leetCode150.evalRPN(tokens));
    }


    /** ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] */
    public int evalRPN(String[] tokens) {
        if (Objects.isNull(tokens) || tokens.length == 0) {
            return 0;
        } else if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if ("+".equals(token)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 + num1);
            } else if ("-".equals(token)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 - num1);
            } else if ("*".equals(token)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 * num1);
            } else if ("/".equals(token)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
