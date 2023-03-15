package com.tianwen.leetcode_2021.offer;

/**
 * wangjq
 * 2021年01月03日  11:44
 */
public class Algorithms64_Sum_Nums {

    public static void main(String[] args) {
        int n = 9;
        System.out.println(sumNums(n));
    }

/*    private static int sumNums(int n) {
        return ((1 + n) * n) >> 1;
    }*/

/*    private static int sumNums(int n) {
        int[] aux = new int[n];
        return recur(1, 0, aux);
    }

    private static int recur(int cur, Integer sum, int[] aux) {
        sum += cur;
        try {
            aux[cur] = 0;
        } catch (Exception e) {
            return sum;
        }
        return recur(cur + 1, sum, aux);
    }*/


    private static int sumNums(int n) {
        int[] aux = new int[1];
        recur(1, aux, n);
        return aux[0];
    }

    private static boolean recur(int cur, int[] aux, int n) {
        aux[0] += cur;
        return ((cur) ^ n) != 0 && recur(cur + 1, aux, n);
    }
}
