package DP;


import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class coinExchange {
    public int coinChange(int[] coins, int amount){
        //dp[i]表示凑i块钱至少需要多少枚硬币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        //遍历硬币
        for (int coin : coins) {
            //遍历dp数组
            for (int i = coin; i <= amount; i++){
                //跟原先的自己dp[i]做比较
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
