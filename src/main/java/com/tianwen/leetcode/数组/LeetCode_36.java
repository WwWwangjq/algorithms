package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月05日  12:08
 */
public class LeetCode_36 {

    public boolean isValidSudoku(char[][] board) {
        if (Objects.isNull(board) || board.length == 0 || board[0].length == 0) {
            return false;
        }
        // 行 数字出现次数
        int[][] rows = new int[9][9];
        // 列 数字出现次数
        int[][] columns = new int[9][9];
        // 3X3小矩阵 数字出现次数
        int[][][] subBoard = new int[3][3][9];

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                char c = board[i][j];
                if (c != '.') {
                    int val = c - '0' - 1;
                    rows[i][val] += 1;
                    columns[j][val] += 1;
                    subBoard[i / 3][j / 3][val] += 1;
                    if (rows[i][val] > 1 || columns[j][val] > 1 || subBoard[i / 3][j / 3][val] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
