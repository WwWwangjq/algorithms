package com.tianwen.algorithms;

/**
 * wangjq
 * 2021年01月01日  14:55
 */
public class Algorithms49_DP_Nth_Ugly_Number {

    public static void main(String[] args) {

    }

    public static int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] result = new int [n];
        result[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i ++) {
            int n2 = result[a] * 2;
            int n3 = result[b] * 3;
            int n5 = result[c] * 5;
            int min = Math.min(Math.min(n2, n3), n5);
            result[i] = min;
            if (min == n2) {
                a ++;
            }
            if (min == n3) {
                b ++;
            }
            if (min == n5) {
                c ++;
            }
        }
        return result[n - 1];
    }
}
