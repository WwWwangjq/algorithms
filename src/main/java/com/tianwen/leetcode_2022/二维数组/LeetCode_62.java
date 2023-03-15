package com.tianwen.leetcode_2022.二维数组;

/**
 * wangjq
 * 2021年05月11日  0:00
 */
public class LeetCode_62 {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
/*
        int m = 19;
        int n = 13;
*/
        LeetCode_62 leetCode_62 = new LeetCode_62();
        System.out.println(leetCode_62.uniquePaths(m, n));
    }


    public int uniquePaths(int m, int n) {
        int[][] matrix = new int [m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 1;
                    continue;
                }
                matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
            }
        }
        return matrix[m - 1][n - 1];
    }


    /*public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return total;
        }
        move(new int[m][n], 0, 0);
        return total;
    }

    private int total;

    private void move(int[][] matrix, int right, int bottom) {
        if (bottom == matrix.length -1 && right == matrix[0].length - 1) {
            total += 1;
            return;
        }
        if (!isArriveBottom(matrix, bottom + 1)) {
            move(matrix, right, bottom + 1);
        }
        if (!isArriveRight(matrix, right + 1)) {
            move(matrix, right + 1, bottom);
        }
    }

    private boolean isArriveBottom(int[][] matrix, int bottom) {
        return bottom == matrix.length;
    }

    private boolean isArriveRight(int[][] matrix, int  right) {
        return right == matrix[0].length;
    }*/

}
