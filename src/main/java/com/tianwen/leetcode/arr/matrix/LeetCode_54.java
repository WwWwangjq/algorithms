package com.tianwen.leetcode.arr.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2021年05月09日  14:27
 */
public class LeetCode_54 {

    public static void main(String[] args) {
        int[][] matrix = new  int [][] {
               new int[] {1,2,3,4},
               new int[] {5,6,7,8},
               new int[] {9,10,11,12},
        };
        LeetCode_54 leetCode_54 = new LeetCode_54();
        System.out.println(leetCode_54.spiralOrder(matrix));;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (Objects.isNull(matrix) || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        collect(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1);
        return result;
    }

    private List<Integer> result = new ArrayList<>();

    private void collect(int[][] matrix, int left, int right, int top, int bottom) {
        if (left <= right) {
            for (int i = left; i <= right; i ++) {
                result.add(matrix[top][i]);
            }
            if (result.size() == matrix.length * matrix[0].length) {
                return;
            }
            top ++;
        }
        if (top <= bottom) {
            for (int i = top; i <= bottom; i ++) {
                result.add(matrix[i][right]);
            }
            if (result.size() == matrix.length * matrix[0].length) {
                return;
            }
            right --;
        }
        if (right >= left) {
            for (int i = right; i >= left; i --) {
                result.add(matrix[bottom][i]);
            }
            if (result.size() == matrix.length * matrix[0].length) {
                return;
            }
            bottom --;
        }
        if (bottom >= top) {
            for (int i = bottom; i >= top; i --) {
                result.add(matrix[i][left]);
            }
            if (result.size() == matrix.length * matrix[0].length) {
                return;
            }
            left ++;
        }
        collect(matrix, left, right, top, bottom);
    }

}
