package com.tianwen.algorithms;

import java.util.Arrays;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms12_Matrix_Path {


    /**
     *
     * 输入一个二位数组 再输入一个数字串 写一个方法以确定是否能在数组中匹配到这个字符串 并确定顺序 同一点只能使用一次
     *
     * 遍历数组 每一个点作为开头的点开始匹配
     * 匹配不中下一次循环
     * 匹配中 开始以该点上下左右发散 同时注意边界 如果发散的点都匹配不中 该路径失败
     * 如果有一个发散点命中 再以该发散点为当前点开始发散 匹配字符串中的下一个点 一旦有全部命中的情况 返回true以表示找到
     * 用boolean二位数组表示命中的点 避免重复使用
     *
     * 1 2 3 5
     * 4 5 7 2
     * 7 8 9 3
     * 1 8 4 5
     *
     * @param args
     */
    public static void main(String[] args) {
//        char[][] board = new char[][]{new char[]{'1', '2', '3', '5'}, new char[]{'4', '5', '7', '2'}, new char[]{'7', '8', '9', '3'}, new char[]{'1', '8', '4', '5'}};
//        String word = "527935481";
//        char[][] board = new char[][]{new char[]{'3', '1', '1'}, new char[]{'1', '1', '1'}, new char[]{'2', '3', '4'}};
//        String word = "112";
        char[][] board = new char[][]{new char[]{'A', 'B', 'C', 'E'}, new char[]{'S', 'F', 'E', 'S'}, new char[]{'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        printArr(board);
        System.out.println(exist(board, word));
        System.out.println("end...");
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] flag = new boolean[row][col];
                if (find(board, i, j, flag, word.toCharArray(), 0)) {
                    printArr(flag);
                    return true;
                }
            }
        }
        return false;
    }

    private static void printArr(char[][] flag) {
        for (char[] c : flag) {
            System.out.println(Arrays.toString(c));
        }
    }

    private static void printArr(boolean[][] flag) {
        for (boolean[] b : flag) {
            System.out.println(Arrays.toString(b));
        }
    }

    private static boolean find(char[][] source, int row, int col, boolean[][] flag, char[] wantInts, int i) {
        boolean find = isFind(source, row, col, flag, wantInts, i);
        if (!find) {
            return false;
        }
        // 说明已经找到路径
        if (wantInts.length == ++i) {
            return true;
        }
        if (!outOfLeft(col - 1)) {
            if (find(source, row, col - 1, flag, wantInts, i)) {
                return true;
            }
        }
        if (!outOfRight(source, col + 1)) {
            if (find(source, row, col + 1, flag, wantInts, i)) {
                return true;
            }
        }
        if (!outOfHigh(row - 1)) {
            if (find(source, row - 1, col, flag, wantInts, i)) {
                return true;
            }
        }
        if (!outOfLow(source, row + 1)) {
            if (find(source, row + 1, col, flag, wantInts, i)) {
                return true;
            }
        }
        flag[row][col] = false;
        return false;
    }

    private static boolean isFind(char[][] source, int row, int col, boolean[][] flag, char[] wantInts, int i) {
        boolean find = !flag[row][col] && source[row][col] == wantInts[i];
        if (find) {
            flag[row][col] = true;
        }
        return find;
    }

    private static boolean outOfLeft(int col) {
        return col < 0;
    }

    private static boolean outOfRight(char[][] source, int col) {
        return col > source[0].length - 1;
    }

    private static boolean outOfHigh(int row) {
        return row < 0;
    }

    private static boolean outOfLow(char[][] source, int row) {
        return row > source.length - 1;
    }

}
