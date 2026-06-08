package TwoPoint;


import java.awt.event.ActionListener;
import java.util.*;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums){
        //双指针
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0){
                    while (left < right && nums[left] == nums[++left]);
                } else if (sum < 0) {
                    while (left < right && nums[right] == nums[--right]);
                }else {
                        ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right] )));
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }

        return ans;
    }

}
