package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月02日  11:41
 */
public class LeetCode_122 {

    /**
     *
     //输入: prices = [7,1,5,3,6,4]
     //输出: 7

     //输入: prices = [1,2,3,4,5]
     //输出: 4

     */
    public static void main(String[] args) {
        LeetCode_122 leetCode_122 = new LeetCode_122();
//        int[] prices = new int[]{7,1,5,3,6,4};
//        int[] prices = new int[]{1,2,3,4,5};
//        int[] prices = new int[]{7,6,4,5};
//        int[] prices = new int[]{7,6,4,3,1};
//        int[] prices = new int[]{1, 3};
        int[] prices = new int[]{1};
//        int[] prices = new int[]{0};
        System.out.println(leetCode_122.maxProfit(prices));
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
            maxProfit += preProfit;
            return;
        }
        int dayProfit = prices[i] - prices[i - 1];
        if (dayProfit > 0) {
            preProfit += dayProfit;
        } else {
            maxProfit += preProfit;
            preProfit = 0;
        }
        calculate(preProfit, prices, i + 1);
    }
}
