package com.tianwen.leetcode_2022.二维数组;

import java.util.Objects;

/**
 * wangjq
 * 2021年05月08日  22:56
 */
public class LeetCode_48 {

    public static void main(String[] args) {
//        int[][] matrix = new int [][] {new int [] {1,2,3},new int [] {4,5,6},new int [] {7,8,9}};
        int[][] matrix = new int [][] {new int [] {5,1,9,11},new int [] {2,4,8,10},new int [] {13,3,6,7},new int [] {15,14,12,16}};
        LeetCode_48 leetCode_48 = new LeetCode_48();
        leetCode_48.rotate(matrix);
    }


    public void rotate(int[][] matrix) {
        if (Objects.isNull(matrix) || matrix.length == 0) {
            return;
        }
        swap(matrix, 0, matrix.length - 1);
    }

    private void swap(int[][] matrix, int start, int end) {
        if (start >= end) {
            return;
        }
        int s = start;
        int e = end;
        while (s < end) {
            int temp = matrix[start][s];
            matrix[start][s] = matrix[e][start];
            matrix[e][start] = matrix[end][e];
            matrix[end][e] = matrix[s][end];
            matrix[s][end] = temp;
            s ++;
            e --;
        }
        swap(matrix, start + 1, end - 1);
    }
}
