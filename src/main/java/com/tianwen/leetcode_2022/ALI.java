package com.tianwen.leetcode_2022;

import java.util.Objects;

/**
 * wangjq
 * 2021年04月22日  21:48
 */

/*输入:
        [
        [1,3,1],
        [1,5,1],
        [4,2,1]
        ]
        输出: 12
        解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

class Solution {
    public int maxValue(int[][] grid) {

    }
}*/
public class ALI {

    public static void main(String[] args) {
        ALI aaa = new ALI();
        int[][] grid = new int[3][3];
        int[] arr1 = new int[] {1,3,1};
        int[] arr2 = new int[] {1,5,1};
        int[] arr3 = new int[] {4,2,1};
        grid[0] = arr1;
        grid[1] = arr2;
        grid[2] = arr3;
/*        int[][] grid = new int[2][3];
        int[] arr1 = new int[] {1,3,6};
        int[] arr2 = new int[] {1,5,2};
        grid[0] = arr1;
        grid[1] = arr2;*/
        System.out.println(aaa.maxValue(grid));
    }


    private int sum;

    public int maxValue(int[][] grid) {
        if (Objects.isNull(grid) || grid[0].length == 0) {
            return sum;
        }
        int i = grid.length;
        int j = grid[0].length;
        recur(grid, new boolean[i][j], 0, 0, 0);
        return sum;
    }

    private void recur(int[][] grid, boolean[][] visited, int i, int j, int curSum) {
        if (visited[i][j]) {
            return;
        }
        curSum += grid[i][j];
        visited[i][j] = true;
        if (isEnd(grid, i, j)) {
            sum = Math.max(sum, curSum);
            visited[i][j] = false;
            return;
        }
/*        if (!outTop(i - 1)) {
            recur(grid, visited, i - 1, j, curSum);
            visited[i][j] = false;
        }*/
        if (!outBottom(i + 1, grid)) {
            recur(grid, visited, i + 1, j, curSum);
            visited[i][j] = false;
        }
/*        if (!outLeft(j - 1)) {
            recur(grid, visited, i, j - 1, curSum);
        }*/
        if (!outRight(j + 1, grid)) {
            recur(grid, visited, i, j + 1, curSum);
            visited[i][j] = false;
        }
    }

    private boolean isEnd(int[][] grid, int i, int j) {
        return i == grid.length - 1 && j == grid[0].length - 1;
    }


    private boolean outTop(int i) {
        return i < 0;
    }

    private boolean outBottom(int i, int[][] grid) {
        return i > grid.length - 1;
    }

    private boolean outLeft(int j) {
        return j < 0;
    }

    private boolean outRight(int j, int[][] grid) {
        return j > grid[0].length - 1;
    }
}
