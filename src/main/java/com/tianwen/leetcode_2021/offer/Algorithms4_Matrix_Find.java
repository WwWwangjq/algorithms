package com.tianwen.leetcode_2021.offer;

import java.util.Objects;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms4_Matrix_Find {

    /**
     * 已知输入的 二维数组 自左向右 自上向下递增
     * 请写一个方法 输入一个二维数组 和 一个整数 判断整数是否存在在二维数组中
     * 1  2  8  9
     * 2  4  9  12
     * 4  7  10 13
     * 6  10 11 15
     * 9  13 15 17
     */
    public static void main(String[] args) {
/*        int[][] matrix = new int[][]{
                new int[]{1, 1},
        };
        int target = 2;*/

        int[][] matrix = new int[5][5];
//        matrix[0] = new int[]{1, 2, 8, 9};
//        matrix[1] = new int[]{2, 4, 9, 12};
//        matrix[2] = new int[]{4, 7, 10, 13};
//        matrix[3] = new int[]{6, 8, 11, 15};
//        int target = 17;
        matrix[0] = new int[]{1, 4, 7, 11, 5};
        matrix[1] = new int[]{2, 5, 8, 12, 19};
        matrix[2] = new int[]{3, 6, 9, 16, 22};
        matrix[3] = new int[]{10, 13, 14, 17, 24};
        matrix[4] = new int[]{18, 21, 23, 26, 30};
        int target = 5;

        System.out.println(findNumberIn2DArray(matrix, target));
    }

    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (Objects.isNull(matrix) || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int columnStart = 0;
        int columnEnd = matrix.length - 1;
        int rowStart = 0;
        int rowEnd = matrix[0].length - 1;
        int use = 0;
        int length = matrix.length * matrix[0].length;
        return find(matrix, target, rowStart, rowEnd, columnStart, columnEnd, use, length);
    }

    private static boolean find(int[][] matrix, int target, int rowStart, int rowEnd, int columnStart, int columnEnd, int use, int length) {
        if (use == length) {
            return false;
        }
        int num = matrix[columnStart][rowEnd];
        if (num < target) {
            return find(matrix, target, rowStart, rowEnd, columnStart + 1, columnEnd, use + (rowEnd - rowStart) + 1, length);
        } else if (num > target) {
            return find(matrix, target, rowStart, rowEnd - 1, columnStart, columnEnd, use + (columnEnd - columnStart) + 1, length);
        } else {
            return true;
        }
    }


}
