package com.tianwen.leetcode_2021.offer;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms14_Dynamic_Plan {


    /**
     * 剪绳子
     * 长度为n 剪成m段 问m段长度最大乘积是多少
     * 8 被剪成3段 2 3 3 最大乘积 2 X 3 X 3=18
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(get(8));
    }

    private static int get(int length) {
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }
        // 长度4时 0~4算4长度，product容量是5
        int[] product = new int[length + 1];

        // product一些必要的初始值
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
        // 4往后的可以算出来
        return splitGet(length, product);
    }

    private static int splitGet(int length, int[] product) {
        for (int i = 4; i < length + 1; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, product[j] * product[i - j]);
            }
            // 长为i时的最大乘积
            product[i] = max;
        }
        return product[length];
    }
}
