package Section;


import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 区间 [a,b] 是从 a 到 b（包含）的所有整数的集合。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个区间但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class summaryRanges {
    public List<String> summaryRanges(int[] nums){
        List<String> ans = new ArrayList<>();

        if (nums == null || nums.length == 0){
            return ans;
        }

        //采用双指针
        int left = 0;
        for (int right = 0; right < nums.length; right++){
            if (right + 1 == nums.length || nums[right] + 1 != nums[right + 1]){
                StringBuilder builder = new StringBuilder();
                builder.append(nums[left]);
                if (nums[left] != nums[right]){
                    builder.append("->");
                    builder.append(nums[right]);
                }
                ans.add(builder.toString());
                left = right + 1;
            }
        }

        return ans;
    }
}
