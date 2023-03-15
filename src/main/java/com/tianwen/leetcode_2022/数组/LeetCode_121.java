package com.tianwen.leetcode_2022.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月01日  20:00
 */
public class LeetCode_121 {

    public static void main(String[] args) {
        LeetCode_121 leetCode_121 = new LeetCode_121();
//        int[] prices = new int[]{7,1,5,3,6,4};
//        int[] prices = new int[]{7,6,4,3,1};
//        int[] prices = new int[]{1, 3};
//        int[] prices = new int[]{1};
        int[] prices = new int[]{0};
        System.out.println(leetCode_121.maxProfit(prices));
    }


    public int maxProfit(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0) {
            return 0;
        }
        calculate(0, prices, 1);
        return maxProfit;
    }

    private int maxProfit = 0;

    private void calculate(int preProfit, int[] prices, int i) {
        if (i == prices.length) {
            return;
        }
        int curProfit = Math.max(preProfit + (prices[i] - prices[i - 1]), 0);
        maxProfit = Math.max(maxProfit, curProfit);
        calculate(curProfit, prices, i + 1);
    }
}
