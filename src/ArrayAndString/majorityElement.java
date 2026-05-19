package ArrayAndString;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class majorityElement {
    public int majorityElement1(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxAll = Integer.MIN_VALUE;
        for (int num : nums) {
            Integer maxCurrent = map.get(num);
            maxAll = maxCurrent > maxAll ? maxCurrent : maxAll;
        }

        int n = nums[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxAll){
                n = entry.getKey();
            }
        }
        return n;
    }


    public int majorityElement2(int[] nums){
        int votes = 0;
        int x = 0;
        for (int num : nums) {
            if (votes == 0){
                x = num;
            }
            votes += x == num ? 1 : -1;
        }

        return x;
    }
}
