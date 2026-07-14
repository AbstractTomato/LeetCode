package subArray;


/**
 * 给定一个长度为 n 的环形整数数组 nums ，
 * 返回 nums 的非空 子数组 的最大可能和 。
 */
public class maxSumCircularSubArray {
    public int maxSubarraySumCircular(int[] nums){
        int curMax = 0;
        int maxSum = nums[0];
        int curMin = 0;
        int minSum = nums[0];

        //整个数组之和
        int total = 0;

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(curMax, maxSum);

            curMin = Math.min(curMin + num, num);
            minSum = Math.min(curMin, minSum);

            total += num;
        }

        if (maxSum <= 0){
            return maxSum;
        }else {
            return Math.max(maxSum, total - minSum);
        }
    }
}
