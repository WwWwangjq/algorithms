package com.tianwen.leetcode_2021.offer;

import java.util.Arrays;

/**
 * wangjq
 * 2020年11月07日  11:17
 */
public class Algorithms1_Arr_2_Insert {
    public final static int[] ARR = new int[]{5, 1, 8, 32, 8, 2, 32, 7, 4, 34, 6, 8, 45, 2, 5, 34, 7, 48, 324, 5};

    /**
     * 插入排序
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ARR));
        sortInsert(ARR);
        System.out.println(Arrays.toString(ARR));
    }

    private static void sortInsert(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    exchange(arr, j, j - 1);
                }
            }
        }
    }

    private static void exchange(int[] arr, int sub1, int sub2) {
        int temp = arr[sub1];
        arr[sub1] = arr[sub2];
        arr[sub2] = temp;
    }
}
