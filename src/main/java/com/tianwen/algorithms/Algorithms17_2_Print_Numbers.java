package com.tianwen.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * wangjq
 * 2021年01月05日  12:00
 */
public class Algorithms17_2_Print_Numbers {

    public static void main(String[] args) {
        int n = 2;
        int[] ints = printNumbers(n);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] printNumbers(int n) {
        if (n == 0) {
            return new int[0];
        }
        int[] ret = new int[Double.valueOf(Math.pow(10, n) - 1).intValue()];
        recur("", ret, new int[1], 0, n);
        return ret;
    }

    private static void recur(String s, int[] ret, int[] retSub, int cur, int n) {
        if (cur == n) {
            int num = Integer.parseInt(s);
            if (num != 0) {
                ret[retSub[0]] = num;
                retSub[0] += 1;
            }
            return;
        }
        for (int i = 0; i <= 9 ; i ++) {
            recur(s + i, ret, retSub, cur + 1, n);
        }
    }
}
