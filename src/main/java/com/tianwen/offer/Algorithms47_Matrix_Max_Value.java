package com.tianwen.offer;

/**
 * wangjq
 * 2020年12月31日  23:00
 */
public class Algorithms47_Matrix_Max_Value {

    public static void main(String[] args) {
//        int[][] grid = new int[][]{new int[]{1, 2, 3, 5}, new int[]{4, 5, 7, 2}, new int[]{7, 8, 9, 3}, new int[]{1, 8, 4, 5}};
//        int[][] grid = new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{1, 2, 1}};
        int[][] grid = new int[][]{new int[]{1, 2, 5}, new int[]{3, 2, 1}};
/*        int[][] grid = new int[][]{
                new int[]{3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3},
                new int[]{0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2},
                new int[]{8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9},
                new int[]{1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7},
                new int[]{8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8},
                new int[]{4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9},
                new int[]{6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1},
                new int[]{8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3},
                new int[]{9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3},
                new int[]{0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8},
                new int[]{4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3},
                new int[]{2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3},
                new int[]{0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3},
                new int[]{0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5},
                new int[]{6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2},
                new int[]{7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0},
                new int[]{3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0},
                new int[]{5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}
        };*/
        System.out.println(maxValue(grid));
    }

    private static int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j++) {
                result[i][j] = grid[i-1][j-1] + Math.max(result[i-1][j], result[i][j -1]);
            }
        }
        return result[m][n];
    }

/*    private static int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 && j == 0) {
                    result[i][j] = grid[i][j];
                } else if (i == 0) {
                    result[i][j] = grid[i][j] + result[i][j-1];
                } else if (j == 0) {
                    result[i][j] = grid[i][j] + result[i-1][j];
                } else {
                    result[i][j] = grid[i][j] + Math.max(result[i-1][j], result[i][j -1]);
                }
            }
        }
        return result[m - 1][n - 1];
    }*/

/*    private static int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] maxVal = new int[1];
        collect(grid, 0, 0, 0, maxVal);
        return maxVal[0];
    }

    private static void collect(int[][] grid, int i, int j, int curVal, int[] maxVal) {
        curVal += grid[i][j];
        if (isEnd(grid, i, j)) {
            maxVal[0] = Math.max(curVal, maxVal[0]);
            return;
        }
        if (!outOfLow(grid, i + 1)) {
            collect(grid, i + 1, j, curVal, maxVal);
        }
        if (!outOfRight(grid, j + 1)) {
            collect(grid, i, j + 1, curVal, maxVal);
        }
    }

    private static boolean outOfLow(int[][] grid, int i) {
        return grid.length == i;
    }

    private static boolean outOfRight(int[][] grid, int j) {
        return grid[0].length == j;
    }

    private static boolean isEnd(int[][] grid, int i, int j) {
        return grid.length - 1 == i && grid[0].length - 1 == j;
    }*/
}
