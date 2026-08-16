package DP;


import java.util.Arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class stock3 {
    public int maxProfit(int[] prices){
        return profit(prices, 2);
    }

    private int profit(int[] prices, int k){
        if (prices == null || prices.length == 0){
            return 0;
        }

        if (k >= prices.length / 2){
            int profit = 0;
            for (int i = 1; i < prices.length; i++){
                if (prices[i] > prices[i - 1]){
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }

        int[] cash = new int[k + 1];
        int[] hold = new int[k + 1];
        Arrays.fill(hold, Integer.MIN_VALUE / 2);
        hold[0] = -prices[0];

        for (int price : prices) {
            for (int j = k; j >= 1; j--){
                cash[j] = Math.max(cash[j], hold[j] + price);

                hold[j] = Math.max(hold[j], cash[j - 1] - price);
            }
        }

        return cash[k];
    }
}
