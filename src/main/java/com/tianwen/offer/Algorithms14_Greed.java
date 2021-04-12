package com.tianwen.offer;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms14_Greed {


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
        } else if (length == 4) {
            return 4;
        }

        // 长度4时 0~4算4长度，product容量是5
        int[] init = new int[5];
        // product一些必要的初始值
        init[0] = 0;
        init[1] = 1;
        init[2] = 2;
        init[3] = 3;
        init[4] = 4;
        // 5往后的可以用贪心算出来
        return greedGet(length, init);
    }

    /**
     * 0 = 0
     * 1 = 0
     * 2 = 1 1
     * 3 = 1 2
     * 4 = 2 2
     * 5 = 3 2
     * 6 = 3 3
     * 7 = 3 4
     * 8 = 3 5
     * 9 = 3 6
     * 根据规律 n >= 5 时，f(n) = 3(n-3)时可以获得最大乘积
     *
     * @param length
     * @return
     */
    private static int greedGet(int length, int[] init) {
        int i = 1;
        int l = length;
        while (l >= 5) {
            l -= 3;
            i++;
        }
        return i * 3 * init[l];
    }
}
