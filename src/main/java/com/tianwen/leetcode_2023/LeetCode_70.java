package com.tianwen.leetcode_2023;

/**
 * @Author: wangjq
 * @Date: 2023年03月20日 21:14
 */
public class LeetCode_70 {

    // f(1) = 1
    // f(2) = 2
    // f(3) = 2
    // f(4) = f(3) + f(2)
    // f(n-1) = f(n-2) + f(n-3)
    // f(n) = f(n-1) + f(n-2)
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs(2, 1, 3, n);
    }

    private int climbStairs(int fn1, int fn2, int i, int n) {
        int fn = fn1 + fn2;
        if (i == n) {
            return fn;
        }
        return climbStairs(fn, fn1, i + 1, n);
    }
}
