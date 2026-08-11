package DP;


/**
 * 沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 *
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 *
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 *
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 *
 * 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 *
 * 返回小偷的 最小 窃取能力。
 */
public class maxMoney4 {
    public int minCapability(int[] nums, int k){
        int left = 0;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
            left = Math.min(left, num);
        }

        while (left < right){
            int mid = left + (right - left) / 2;
            if (canRob(nums, mid, k)){
                //表明当前能力够用, 需要降低上限
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canRob(int[] nums, int cap, int k){
        //偷房子的数量
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            //表明可以偷这间房
            if (nums[i] <= cap){
                //偷这一间
                count++;
                //跳过下一间
                i++;
                if (count >= k){
                    return true;
                }
            }
        }

        return false;
    }

}
