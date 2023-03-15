package com.tianwen.leetcode_2023;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月13日 22:22
 */
public class LeetCode_121 {

    public int maxProfit(int[] prices) {
        if (Objects.isNull(prices) || prices.length < 2) {
            return 0;
        }
        int scopeProfit = 0;
        for (int i = 1; i < prices.length; i ++) {
            int dayProfit = prices[i] - prices[i - 1];
            scopeProfit += dayProfit;
            maxProfit = Math.max(scopeProfit, maxProfit);
            if (scopeProfit <= 0) {
                scopeProfit = 0;
            }
        }
        return maxProfit;
    }

    private int maxProfit;
}
