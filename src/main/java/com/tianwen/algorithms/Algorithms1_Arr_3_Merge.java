package com.tianwen.algorithms;

import java.util.Arrays;

/**
 * wangjq
 * 2020年11月07日  11:17
 */
public class Algorithms1_Arr_3_Merge {
    public final static int[] ARR = new int[]{5, 1, 8, 32, 8, 2, 32, 7, 4, 34, 6, 8, 45, 2, 5, 34, 7, 48, 324, 5};

    static int[] AUX = new int [ARR.length];

    /**
     * 归并排序
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ARR));
        int hi = ARR.length - 1;
        sortMerge(ARR, 0, hi);
        System.out.println(Arrays.toString(ARR));
    }

    private static void sortMerge(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sortMerge(arr, lo, mid);
        sortMerge(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        if (arr.length == 0) {
            return;
        }
        for (int k = lo; k <= hi; k++) {
            AUX[k] = arr[k];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = AUX[j++];
            } else if (j > hi) {
                arr[k] = AUX[i++];
            } else if (AUX[i] > AUX[j]) {
                arr[k] = AUX[j++];
            } else {
                arr[k] = AUX[i++];
            }
        }
    }
}
