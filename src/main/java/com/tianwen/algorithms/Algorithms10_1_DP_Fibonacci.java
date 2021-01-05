package com.tianwen.algorithms;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms10_1_DP_Fibonacci {


    /**
     * 斐波那契数列
     * f0 = 0
     * f1 = 1
     * fn = f(n-1) + f(n-2)
     *
     * 拆解题目 所有能转化成fn = f(n-1) + f(n-2)都是斐波那契数列问题
     * @param args
     */
    public static void main(String[] args) {
        int n = 45;
        if (n == F0) {
            System.out.println(0);
        } else if (n == F1) {
            System.out.println(1);
        } else {
            System.out.println(calculate(F0, F1, SUB, n));
        }
    }

    private final static int F0 = 0;
    private final static int F1 = 1;
    private final static int SUB = 2;

    public static int fib(int n) {
        if (n == F0) {
            return F0;
        } else if (n == F1) {
            return F1;
        } else {
            return calculate(F0, F1, SUB, n);
        }
    }

    // f0 + f1 = f2
    // f1 + f2 = f3
    // f2 + f3 = f4
    private static Integer calculate(Integer fa, Integer fb, int i, int n) {
        Integer fc = (fa + fb) % 1000000007;
        if (i++ == n) {
            return fc;
        }
        return calculate(fb, fc, i, n);
    }
}
