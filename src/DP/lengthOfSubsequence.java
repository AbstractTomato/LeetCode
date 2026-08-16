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

    public int lengthOfLIS2(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums){
            int left = 0;
            int right = size;

            //利用二分查找找到第一个大于num的索引left
            while (left < right){
                int mid = left + (right - left) / 2;
                if (num > tails[mid]){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }

            tails[left] = num;
            if (left == size){
                //开辟新堆
                size++;
            }
        }

        return size;
    }
}
