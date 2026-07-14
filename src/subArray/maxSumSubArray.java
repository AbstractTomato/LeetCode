package subArray;


/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 */
public class maxSumSubArray {
    public int maxSubArray(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++){
            if (dp[i - 1] <= 0){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        int ans = dp[0];
        for (int i = 1; i < dp.length; i++) {
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
