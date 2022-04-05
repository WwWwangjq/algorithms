package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月01日  20:00
 */
public class LeetCode_121_1 {

    public static void main(String[] args) {
        LeetCode_121_1 leetCode_121 = new LeetCode_121_1();
//        int[] prices = new int[]{7,1,5,3,6,4};
//        int[] prices = new int[]{7,6,4,3,1};
//        int[] prices = new int[]{1, 3};
        int[] prices = new int[]{1};
//        int[] prices = new int[]{0};
        System.out.println(leetCode_121.maxProfit(prices));
    }


    private int maxProfit = 0;

    public int maxProfit(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int preProfit = 0;
        for (int i = 1; i < prices.length; i ++) {
            int curProfit = Math.max(preProfit + (prices[i] - prices[i - 1]), 0);
            maxProfit = Math.max(maxProfit, curProfit);
            preProfit = curProfit;
        }
        return maxProfit;
    }
}
