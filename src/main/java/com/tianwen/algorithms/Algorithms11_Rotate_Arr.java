package com.tianwen.algorithms;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms11_Rotate_Arr {

//    private final static int[] ARR = new int []{3, 4, 5, 7, 2};
    private final static int[] ARR = new int []{1, 1, 1, 1, 1, 0};

    /**
     * 旋转数组的最小数字
     * 把一个数组的最开始若干个元素搬到数组的末尾
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
     * 例如 {3, 4, 5, 1, 2} -> {1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getMin(ARR));
    }

    private static int getMin(int[] arr) {
        return contraction(arr, 0, arr.length - 1);

    }

    private static int contraction(int[] arr, int lo, int hi) {
        if (lo == hi -1) {
            return arr[hi];
        }
        int mid = (lo + hi) / 2;
        if (arr[mid] > arr[lo]) {
            return contraction(arr, mid, hi);
        } else if ((arr[mid] < arr[lo])) {
            return contraction(arr, lo, mid);
        } else {
            // 没有考虑存在重复数据的情况
            return 0;
        }
    }
    
}
