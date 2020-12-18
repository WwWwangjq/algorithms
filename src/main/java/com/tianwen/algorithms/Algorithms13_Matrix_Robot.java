package com.tianwen.algorithms;

import lombok.NoArgsConstructor;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms13_Matrix_Robot {


    /**
     * 机器人运动范围
     * 输入一个矩阵 输入一个数字k 从0,0开始移动,每次可以上下左右运动一格
     * 例如k 18
     * 例如35,37| 3 + 5 + 3 + 7 =18 = k 所以该点满足 计数1。
     * 例如35,38| 3 + 5 + 3 + 7 =19 > k 所以该点不满足。
     * 问一共有多少点
     *
     * @param args
     */
    public static void main(String[] args) {
        int row = 28;
        int col = 39;
        int k = 6;
        System.out.println(movingCount(row, col, k));
        System.out.println("end...");
    }

    public static int movingCount(int m, int n, int k) {
        int[][] source = new int[m][n];
        boolean[][] flag = new boolean[m][n];
        ForCount count = new ForCount();
        System.out.println(count.get());
        find(source, 0, 0, flag, k, count);
        printArr(flag);
        return count.get();
    }

    private static void printArr(boolean[][] flag) {
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[i].length; j++) {
                System.out.print("(" + i + "," + j + ")" + " " + flag[i][j] + "| ");
            }
            System.out.println();
        }
    }

    private static boolean find(int[][] source, int row, int col, boolean[][] flag, int k, ForCount count) {
        boolean isSuitable = isSuitable(row, col, flag, k, count);
        if (!isSuitable) {
            return false;
        }
        if (!outOfLeft(col - 1) && notFirst(row, col - 1, flag)) {
            if (find(source, row, col - 1, flag, k, count)) {
                return true;
            }
        }
        if (!outOfRight(source, col + 1) && notFirst(row, col + 1, flag)) {
            if (find(source, row, col + 1, flag, k, count)) {
                return true;
            }
        }
        if (!outOfHigh(row - 1) && notFirst(row - 1, col, flag)) {
            if (find(source, row - 1, col, flag, k, count)) {
                return true;
            }
        }
        if (!outOfLow(source, row + 1) && notFirst(row + 1, col, flag)) {
            if (find(source, row + 1, col, flag, k, count)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSuitable(int row, int col, boolean[][] flag, int k, ForCount count) {
        if (checkOK(row, col, k)) {
            flag[row][col] = true;
            count.addAndGet(1);
            return true;
        }
        return false;
    }

    private static boolean checkOK(int row, int col, int k) {
        int all = 0;
        while (row > 0) {
            all += row % 10;
            row /= 10;
        }
        while (col > 0) {
            all += col % 10;
            col /= 10;
        }
        return all <= k;
    }

    private static boolean notFirst(int row, int col, boolean[][] flag) {
        return !flag[row][col];
    }

    private static boolean outOfLeft(int col) {
        return col < 0;
    }

    private static boolean outOfRight(int[][] source, int col) {
        return col > source[0].length - 1;
    }

    private static boolean outOfHigh(int row) {
        return row < 0;
    }

    private static boolean outOfLow(int[][] source, int row) {
        return row > source.length - 1;
    }

    static class ForCount {
        int value;

        public int addAndGet(int i) {
            return value += i;
        }

        public int get() {
            return value;
        }
    }
}
