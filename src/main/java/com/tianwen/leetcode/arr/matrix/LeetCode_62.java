package com.tianwen.leetcode.arr.matrix;

/**
 * wangjq
 * 2021年05月11日  0:00
 */
public class LeetCode_62 {

    public static void main(String[] args) {
        int m = 19;
        int n = 13;
        LeetCode_62 leetCode_62 = new LeetCode_62();
        System.out.println(leetCode_62.uniquePaths(m, n));
    }


    public int uniquePaths(int m, int n) {
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
    }

}
