package com.tianwen.leetcode_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月18日 10:55
 */
public class LeetCode_54 {

    public static void main(String[] args) {
        int[][] martix = new int[][] {
                new int[]{1},
                new int[]{2},
                new int[]{3}
        };
        LeetCode_54 leetCode54 = new LeetCode_54();
        System.out.println(leetCode54.spiralOrder(martix));
    }

    // 123
    // 456
    // 789
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        if (Objects.isNull(matrix)) {
            return resultList;
        }
        int columnLength = matrix.length;
        int rowLength = matrix[0].length;
        boolean[][] visited = new boolean[columnLength][rowLength];
        int i = 0, j = 0;
        while (!visited[i][j]) {

            while (j < rowLength && !visited[i][j]) {
                resultList.add(matrix[i][j]);
                visited[i][j] = true;
                if (j + 1 == rowLength || visited[i][j + 1]) {
                    break;
                }
                j++;
            }
            if (i < columnLength - 1) {
                i++;
            }

            while (i < columnLength && !visited[i][j]) {
                resultList.add(matrix[i][j]);
                visited[i][j] = true;
                if (i + 1 == columnLength || visited[i + 1][j]) {
                    break;
                }
                i++;
            }
            if (j > 0) {
                j--;
            }

            while (j > -1 && !visited[i][j]) {
                resultList.add(matrix[i][j]);
                visited[i][j] = true;
                if (j == 0 || visited[i][j - 1]) {
                    break;
                }
                j--;
            }
            if (i > 0) {
                i--;
            }

            while (i > -1 && !visited[i][j]) {
                resultList.add(matrix[i][j]);
                visited[i][j] = true;
                if (i == 0 || visited[i - 1][j]) {
                    break;
                }
                i--;
            }
            if (j < rowLength - 1) {
                j++;
            }

        }
        return resultList;
    }



}
