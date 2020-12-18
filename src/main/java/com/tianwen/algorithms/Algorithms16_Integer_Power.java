package com.tianwen.algorithms;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms16_Integer_Power {


    /**
     * 求一个整数a的n次方
     * 数学公式推导
     * 偶数 a^n = a^((n-1)/2) * a^((n-1)/2) * a * a
     * 奇数 a^n = a^((n-1)/2) * a^((n-1)/2) * a
     * @param args
     */
    public static void main(String[] args) {
        double a = 0.00001;
        int n = 2147483647;
        System.out.println(myPow(a, n));
    }

    private static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            // 对负指数的处理
            return 1 / x;
        }
        double result = myPow(x, n >> 1) * myPow(x, n >> 1);
        // 最后一位与1相与==1 说明是奇数
        if ((n & 1) == 1) {
            return result * x;
        }
        return result;
    }


}
