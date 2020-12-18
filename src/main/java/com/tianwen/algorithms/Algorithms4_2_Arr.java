package com.tianwen.algorithms;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms4_2_Arr {

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
        int[][] matrix = new int[][] {
                new int[]{1, 1},
        };
        int target = 2;
/*
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{1, 2, 8, 9};
        matrix[1] = new int[]{2, 4, 9, 12};
        matrix[2] = new int[]{4, 7, 10, 13};
        matrix[3] = new int[]{6, 8, 11, 15};
        int target = 17;
*/
        System.out.println(find(matrix, target));
    }

    static boolean find(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        boolean result = false;
        // 行
        int rowSub = 0;
        int endSub = matrix[rowSub].length - 1;
        // 列
        int columnSub = matrix[rowSub].length - 1;
        while (rowSub <= endSub && columnSub >= 0) {
            if (matrix[rowSub][columnSub] == target) {
                result = true;
                System.out.println(rowSub + ", " + columnSub);
                break;
            } else if (matrix[rowSub][columnSub] > target) {
                // 如果右上角数字比要查找的数字大 剔除当前列（下标-1） 当为-1时 不再更新下标
                columnSub--;
            } else {
                // 如果右上角数字比要查找的数字小 剔除当前行（下标-1）
                rowSub++;
            }
        }
        return result;
    }
}
