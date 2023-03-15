package com.tianwen.leetcode_2021.company.tencent.b;

/**
 * wangjq
 * 2021年05月20日  20:30
 */
public class CCC {

    public static void main(String[] args) {
        CCC ccc = new CCC();
        int n = 2;
        System.out.println(ccc.count(n));

    }

    // 一次 1步 2步
    // n阶 多少种方法上楼顶
    // f(n) = f(n-1) + f(n-2)
    // f(2) = 2
    // f(1) = 1
    // f(0) = 0
    private int count(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return recur(n, 1, 2, 3);
    }

    private int recur(int n, int f1, int f2, int i) {
        int fn = f1 + f2;
        if (n == i) {
            return fn;
        }
        return recur(n, f2, fn, i + 1);
    }
}
