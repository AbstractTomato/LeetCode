package DP;


/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class partitionArray {
    public boolean canPartition(int[] nums){
        if (nums == null || nums.length == 0){
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--){
                if (dp[i - num]){
                    dp[i] = true;
                }
            }
        }

        return dp[target];
    }
}
