package com.tianwen.leetcode_2022.数组;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月02日  12:31
 */
public class LeetCode_120 {
    /**
     * //输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * //输出：11
     *
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_120 leetCode_120 = new LeetCode_120();
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(-1),
                Arrays.asList(2, 3),
                Arrays.asList(1, -1, -3)
/*                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)*/
        );
        System.out.println(leetCode_120.minimumTotal(triangle));
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        if (Objects.isNull(triangle) || triangle.isEmpty()) {
            return 0;
        }
        int size = triangle.size();
        // 记录最小和的二维数据
        int[][] arr = new int[size][size];
        arr[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            arr[i][0] = arr[i - 1][0] + triangle.get(i).get(0);
            arr[i][i] = arr[i - 1][i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                arr[i][j] = Math.min(arr[i - 1][j - 1], arr[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i ++) {
            min = Math.min(min, arr[size - 1][i]);
        }
        return min;
    }

/*    public int minimumTotal(List<List<Integer>> triangle) {
        if (Objects.isNull(triangle) || triangle.isEmpty()) {
            return 0;
        }
        int level = triangle.size();
        int size = triangle.get(level - 1).size();
        for (int i = 0; i < size; i ++) {
            min = Math.min(min, minimumTotal(level - 1, i, triangle));
        }
        return min;
    }

    private int min = Integer.MAX_VALUE;

    public int minimumTotal(int level, int i, List<List<Integer>> triangle) {
        if (level == 0) {
            return triangle.get(0).get(0);
        }
        Integer curNum = triangle.get(level).get(i);
        int upperSubNum;
        if (i == 0) {
            upperSubNum = minimumTotal(level - 1, 0, triangle);
        } else if (i == level) {
            upperSubNum = minimumTotal(level - 1, i - 1, triangle);
        } else {
            upperSubNum = Math.min(minimumTotal(level - 1, i - 1, triangle), minimumTotal(level - 1, i, triangle));
        }
        return curNum + upperSubNum;
    }*/
}
