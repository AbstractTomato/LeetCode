package DP;


import java.util.Arrays;

/**
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class stock4 {
    public int maxProfit(int k, int[] prices){
        if (prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        //如果买卖股票的次数大于数组长度的一半的话,表明可以无限次交易了,因为一次交易会耗费两天时间
        if (k >= n / 2){
            int profit = 0;

            for (int i = 1; i < prices.length; i++){
                if (prices[i] > prices[i - 1]){
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }

        //cash[i]表示空仓状态下第i次交易的最大收入
        int[] cash = new int[k + 1];
        //hold[i]表示持仓状态下第i次交易的最大收入
        int[] hold = new int[k + 1];

        Arrays.fill(hold, Integer.MIN_VALUE / 2);
        hold[0] = -prices[0];

        for (int price : prices) {
            for (int i = k; i >=1; i--){
                cash[i] = Math.max(cash[i], hold[i] + price);

                hold[i] = Math.max(hold[i], cash[i - 1] - price);
            }
        }

        return cash[k];
    }
}
