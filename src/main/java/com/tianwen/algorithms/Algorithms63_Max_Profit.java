package com.tianwen.algorithms;

/**
 * wangjq
 * 2021年01月03日  12:28
 */
public class Algorithms63_Max_Profit {

    public static void main(String[] args) {
        int[] prices = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
//        int[] prices = new int[]{8, 5};
//        int[] prices = new int[]{6, 8};
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int i = 0, j = 1;
        int ret = 0;
        while (j < prices.length) {
            ret = Math.max(ret, prices[j] - prices[i]);
            i = prices[i] < prices[j] ? i : j;
            j ++;
        }
        return ret;
    }
}
