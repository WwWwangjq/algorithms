package com.tianwen.algorithms;

import java.util.Arrays;

/**
 * wangjq
 * 2020年11月07日  11:17
 */
public class Algorithms1_Arr_1_Select {
    public final static int[] ARR = new int[]{5, 1, 8, 32, 8, 2, 32, 7, 4, 34, 6, 8, 45, 2, 5, 34, 7, 48, 324, 5};

    /**
     * 选择排序
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ARR));
        sortSelect(ARR);
        System.out.println(Arrays.toString(ARR));
    }

    private static void sortSelect(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length ; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            exchange(arr, i, min);
        }
    }

    private static void exchange(int[] arr, int sub1, int sub2) {
        int temp = arr[sub1];
        arr[sub1] = arr[sub2];
        arr[sub2] = temp;
    }
}
