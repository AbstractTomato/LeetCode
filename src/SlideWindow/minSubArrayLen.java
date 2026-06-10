package SlideWindow;


/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class minSubArrayLen {
    //暴力解法
    public int minSubArrayLen1(int target, int[] nums){
        //正整数数组是关键,直接使用滑动窗口

        int curLen = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target){
                return 1;
            }

            for (int j = i + 1; j < nums.length; j++){
                sum += nums[j];
                if (sum >= target){
                    curLen = j - i + 1;
                    minLen = Math.min(minLen, curLen);
                }
            }
        }
        if (minLen > nums.length){
            return 0;
        }
        return minLen;
    }


    //滑动窗口
    public int minSubArrayLen2(int target, int[] nums){
        int res = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        int len = nums.length;

        //先找到满足条件的子数组窗口
        while (right < len){
            sum += nums[right];

            //此时这个窗口内已经满足条件,开始判断最小的窗口长度,即一个个地提出最左边的元素
            while (sum >= target){
                //判断窗口长度大小
                res = Math.min(res, right - left + 1);
                //剔除最左边的元素,并且左指针右移,判断剔除之后是否还满足条件
                sum -= nums[left];
                left++;
            }

            //对right做自增
            right++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
