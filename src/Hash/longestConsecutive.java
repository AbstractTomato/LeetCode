package Hash;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class longestConsecutive {
    public int longestConsecutive(int[] nums){
        //空间换时间
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (int num : nums) {
            if (set.contains(num - 1)){
                continue;
            }

            int next = num + 1;

            while (set.contains(next)){
                next++;
            }

            ans = Math.max(ans, next - num);

            if (ans * 2 >= nums.length){
                break;
            }
        }

        return ans;

    }
}
