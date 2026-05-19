package ArrayAndString;


public class removeDuplicates {
    /**
     * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     * 考虑 nums 的唯一元素的数量为 k。去重后，返回唯一元素的数量 k。
     * nums 的前 k 个元素应包含 排序后 的唯一数字。下标 k - 1 之后的剩余元素可以忽略。
     */
    public int removeDuplicates1(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int p = 0;
        int q = 1;

        while (q < nums.length){
            if (nums[p] == nums[q]){
                //如果两数相等,q后移一位
                q++;
            }else {
                nums[p + 1] = nums[q];
                p++;
                q++;
            }
        }

        return p + 1;
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
     * 使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    public int removeDuplicates2(int[] nums){
        if (nums == null || nums.length <= 2){
            return nums.length;
        }

        int slow = 2;
        int fast = 2;
        while (fast < nums.length){
            if (nums[fast] == nums[slow - 2]){
                fast++;
            }else {
                /*
                nums[slow - 2] <= nums[slow - 1] <= nums[fast]
                如果nums[slow - 2] = nums[slow - 1],此时如果nums[slow - 2] = nums[fast],就证明有三个元素相等了
                此时fast就要右移
                如果nums[slow - 2] != nums[fast],那就证明此时符合条件,直接两者右移即可
                 */
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }

    /*
    如果要求保留k位,代码如下
     */
    public int removeDuplicatesK(int[] nums, int k){
        if (nums == null || nums.length <= k){
            return nums.length;
        }

        int slow = k;
        int fast = k;
        while (fast < nums.length){
            if (nums[fast] == nums[slow - k + 1]){
                fast++;
            }else {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }

        return slow;
    }


}
