package ArrayAndString;


/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //将该下标左边的元素和右边的元素进行相乘即可
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;

        //左边的乘积
        for (int i = 1; i < len; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        //右边的乘积
        int right = 1;
        for (int i = len - 1; i >= 0; i--){
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }
}
