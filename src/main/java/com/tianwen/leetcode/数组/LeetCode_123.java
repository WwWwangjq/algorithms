package com.tianwen.leetcode.数组;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月02日  12:04
 */
public class LeetCode_123 {

    /**
     *
     //输入：prices = [3,3,5,0,0,3,1,4]
     //输出：6

     //输入：prices = [1,2,3,4,5]
     //输出：4
     */
    public static void main(String[] args) {
        LeetCode_123 leetCode_123 = new LeetCode_123();
//        int[] prices = new int[]{3,3,5,0,0,3,1,4};
//        int[] prices = new int[]{6,1,3,2,4,7};
        int[] prices = new int[]{1,2,4,2,5,7,2,4,9,0};
//        int[] prices = new int[]{1,2,3,4,5};
//        int[] prices = new int[]{7,1,5,3,6,4};
//        int[] prices = new int[]{1,2,3,4,5};
//        int[] prices = new int[]{7,6,4,5};
//        int[] prices = new int[]{7,6,4,3,1};
//        int[] prices = new int[]{1, 3};
//        int[] prices = new int[]{1};
//        int[] prices = new int[]{0};
        System.out.println(leetCode_123.maxProfit(prices));
    }

    private int maxProfit = 0;
    private int max1 = 0;
    private int max2 = 0;

    public int maxProfit(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0) {
            return 0;
        }
        calculate(0, prices, 1);
        return max1 + max2;
    }

    private void calculate(int preProfit, int[] prices, int i) {
        if (i == prices.length) {
            maxProfit = preProfit;
            suitProfit();
            return;
        }
        int dayProfit = prices[i] - prices[i - 1];
        if (dayProfit > 0) {
            preProfit += dayProfit;
        } else {
            maxProfit = preProfit;
            suitProfit();
            preProfit = 0;
        }
        calculate(preProfit, prices, i + 1);
    }

    private void suitProfit() {
        if (maxProfit == 0) {
            return;
        } else {
            if (max1 == 0) {
                max1 = maxProfit;
            } else if (max2 == 0) {
                max2 = maxProfit;
            } else if (maxProfit > max1) {
                max1 = maxProfit;
            } else if (maxProfit > max2) {
                max2 = maxProfit;
            }
        }
        maxProfit = 0;
    }
}
