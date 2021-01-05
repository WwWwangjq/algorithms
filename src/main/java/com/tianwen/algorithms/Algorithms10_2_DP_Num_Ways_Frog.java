package com.tianwen.algorithms;

/**
 * wangjq
 * 2021年01月05日  10:18
 */
public class Algorithms10_2_DP_Num_Ways_Frog {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(numWays(n));
    }

    private static int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return recur(2, 1, 2, n);
    }

    private static int recur(int fn1, int fn2, int i, int n) {
        int fn = (fn1 + fn2) % 1000000007;
        if (++i == n) {
            return fn;
        }
        return recur(fn, fn1, i, n);
    }
}
