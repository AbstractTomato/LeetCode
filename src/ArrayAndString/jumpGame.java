package ArrayAndString;

public class jumpGame {
    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     */
    public boolean canJump(int[] nums){
        //定义能到达的最大距离
        int maxReach = 0;
        /*
        如果 i > maxReach,表明自己都到达不了
        反之,则可以到达
         */
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach){
                return false;
            }else {
                maxReach = Math.max(i + nums[i], maxReach);
            }
        }
        if (maxReach >= nums.length - 1){
            return true;
        }
        return false;
    }


    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
     * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
     * 0 <= j <= nums[i] 且
     * i + j < n
     * 返回到达 n - 1 的最小跳跃次数。
     */
    public int jump(int[] nums){
        //跳跃次数
        int step = 0;

        //该点出发,能到达的最远边界
        int currentEnd = 0;

        //边界内,能到达的最远边界
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd){
                //此时表明跳到这个地方,step++;
                step++;

                //更新currentEnd
                currentEnd = farthest;

                if (currentEnd >= nums.length - 1){
                    return step;
                }
            }
        }
        return step;
    }
}
