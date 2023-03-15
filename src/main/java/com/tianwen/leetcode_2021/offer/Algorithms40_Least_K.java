package com.tianwen.leetcode_2021.offer;

import java.util.Arrays;

/**
 * wangjq
 * 2020年12月26日  0:12
 */
public class Algorithms40_Least_K {

    public static void main(String[] args) {
//        int[] arr = new int[] {3, 2, 1};
//        int k = 2;
        int[] arr = new int[] {0, 0, 0, 2, 0, 5};
        int k = 5;
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }


    private static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[] {};
        }
        if (arr.length <= k) {
            return arr;
        }
        int[] result = new int[k];
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (i <= k - 1) {
                result[i] = arr[i];
                for (int j = 0; j < i; j ++) {
                    if (arr[i] < result[j]) {
                        for (int n = i; n >= j; n --) {
                            result[n] = n == j ? arr[i] : result[n - 1];
                        }
                        break;
                    }
                }
            } else if (cur < result[k - 1]) {
                for (int j = 0; j < result.length; j ++) {
                    if (arr[i] < result[j]) {
                        for (int n = result.length - 1; n >= j; n --) {
                            result[n] = n == j ? arr[i] : result[n - 1];
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }
}
