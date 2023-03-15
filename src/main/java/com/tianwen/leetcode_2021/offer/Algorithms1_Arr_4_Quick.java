package com.tianwen.leetcode_2021.offer;

import java.util.Arrays;

/**
 * wangjq
 * 2020年11月07日  11:17
 */
public class Algorithms1_Arr_4_Quick {
    public final static int[] ARR = new int[]{5, 1, 8, 32, 8, 2, 32, 7, 4, 34, 6, 8, 45, 2, 5, 34, 7, 48, 324, 5};

    static int[] AUX = new int[ARR.length];

    /**
     * 归并排序
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ARR));
        int hi = ARR.length - 1;
        quickSort(ARR, 0, hi);
        System.out.println(Arrays.toString(ARR));
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p);
        quickSort(arr, p + 1, hi);
    }

    // 分割
    private static Integer partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi;
        // 取起始下标 也可取随机下标
        int v = arr[lo];
        while (true) {
            // 控制左指针
            while (arr[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            // 控制右指针
            while (v < arr[--j]) {
                if (j == lo) {
                    break;
                }
            }
            // 如果左指针与右指针相遇
            if (i >= j) {
                break;
            }
            // 到这里分别找到了左 右 两个不相符的值 交换他们
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private static void swap(int[] arr, int sub1, int sub2) {
        int temp = arr[sub1];
        arr[sub1] = arr[sub2];
        arr[sub2] = temp;
    }
}
