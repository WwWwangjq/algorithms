package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月06日  21:46
 */
public class LeetCode_64 {
    /**
     *
     //输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     //输出：7
     //解释：因为路径 1→3→1→1→1 的总和最小。
     //
     //输入：grid = [[1,2,3],[4,5,6]]
     //输出：12
     */
    public static void main(String[] args) {
        int[][] grid = new int [][] {
                /*new int[] {1,2,3},
                new int[] {4,5,6},*/

                /*new int[] {1,3,1},
                new int[] {1,5,1},
                new int[] {4,2,1},*/

                /*new int[] {4},
                new int[] {3},
                new int[] {2},*/

        };
        LeetCode_64 leetCode_64 = new LeetCode_64();
        System.out.println(leetCode_64.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        if (Objects.isNull(grid) || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int [m + 1][n + 1];
        for (int i = 1; i < m + 1; i ++) {
            for (int j = 1; j < n + 1; j ++) {
                if (i == 1 && j == 1) {
                    matrix[i][j] = grid[i - 1][j - 1];
                } else if (i == 1) {
                    matrix[i][j] = matrix[i][j - 1] + grid[i - 1][j - 1];
                } else if (j == 1) {
                    matrix[i][j] = matrix[i - 1][j] + grid[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.min(matrix[i][j - 1], matrix[i - 1][j]) + grid[i - 1][j - 1];
                }

            }
        }
        return matrix[m][n];
    }
}
