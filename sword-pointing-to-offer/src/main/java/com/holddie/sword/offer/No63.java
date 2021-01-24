package com.holddie.sword.offer;

/**
 * 股票的最大利润
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/27 8:59
 */
public class No63 {

    /** 题目描述： 可以有一次买入和卖出，买入必须在前，求最大利润。 */
    private int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int soFarMin = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            soFarMin = Math.min(soFarMin, price);
            maxProfit = Math.max(maxProfit, price - soFarMin);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        No63 no63 = new No63();
        System.out.println(no63.maxProfit(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
