package ArrayAndString;



public class maxProfits {
    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
     */
    public int maxProfit1(int[] prices){
        if (prices == null || prices.length == 0){
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }


    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。然而，你可以在 同一天 多次买卖该股票，但要确保你持有的股票不超过一股。
     *
     * 返回 你能获得的 最大 利润 。
     */
    public int maxProfit2(int[] prices){
        //本质就是找上升段,然后累加即可
        if (prices == null || prices.length == 0){
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] - prices[i - 1] > 0){
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
