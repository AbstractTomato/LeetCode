package DP;


/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */
public class lengthOfSubsequence {
    public int lengthOfLIS1(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int ans = 1;
        //表示num[i]的最长严格递增子序列
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
