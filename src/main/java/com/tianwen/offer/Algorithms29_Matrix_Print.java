package com.tianwen.offer;

import java.util.Arrays;

/**
 * wangjq
 * 2020年12月18日  21:12
 */
public class Algorithms29_Matrix_Print {

    public static void main(String[] args) {
/*        int[] row1 = new int[]{1, 2, 3, 4};
        int[] row2 = new int[]{5, 6, 7, 8};
        int[] row3 = new int[]{9, 10, 11, 12};
        int[] row4 = new int[]{13, 14, 15, 16};
        int[][] matrix = new int[][]{row1, row2, row3, row4};*/
//        int[][] matrix = new int[][]{row1, row2, row3};


        int[] row1 = new int[]{1, 2, 3};
        int[] row2 = new int[]{5, 6, 7};
        int[] row3 = new int[]{9, 10, 11};
        int[][] matrix = new int[][]{row1, row2, row3};
        int[] result = spiralOrder(matrix);
        System.out.println(Arrays.toString(result));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int count = 0;
        int rowStart = 0;
        int rowEnd = matrix[0].length - 1;
        int columnStart = 0;
        int columnEnd = matrix.length - 1;
        collectNum(matrix, result, count, rowStart, rowEnd, columnStart, columnEnd);
        return result;
    }

    private static void collectNum(int[][] matrix, int[] result, int count, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        if (rowStart <= rowEnd) {
            count = right(matrix, result, count, rowStart, rowEnd, columnStart, columnEnd);
            columnStart++;
            if (count == result.length) {
                return;
            }
        }
        if (columnStart <= columnEnd) {
            count = down(matrix, result, count, rowStart, rowEnd, columnStart, columnEnd);
            rowEnd--;
            if (count == result.length) {
                return;
            }
        }
        if (rowStart <= rowEnd) {
            count = left(matrix, result, count, rowStart, rowEnd, columnStart, columnEnd);
            columnEnd--;
            if (count == result.length) {
                return;
            }
        }
        if (columnStart <= columnEnd) {
            count = up(matrix, result, count, rowStart, rowEnd, columnStart, columnEnd);
            rowStart++;
            if (count == result.length) {
                return;
            }
        }
        collectNum(matrix, result, count, rowStart, rowEnd, columnStart, columnEnd);
    }

    private static int right(int[][] matrix, int[] result, int count, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        for (int i = rowStart; i <= rowEnd; i++) {
            result[count++] = matrix[columnStart][i];
        }
        return count;
    }

    private static int down(int[][] matrix, int[] result, int count, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        for (int i = columnStart; i <= columnEnd; i++) {
            result[count++] = matrix[i][rowEnd];
        }
        return count;
    }

    private static int left(int[][] matrix, int[] result, int count, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        for (int i = rowEnd; i >= rowStart; i--) {
            result[count++] = matrix[columnEnd][i];
        }
        return count;
    }

    private static int up(int[][] matrix, int[] result, int count, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        for (int i = columnEnd; i >= columnStart; i--) {
            result[count++] = matrix[i][rowStart];
        }
        return count;
    }

}
