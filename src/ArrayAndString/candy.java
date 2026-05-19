package ArrayAndString;


import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子中，评分更高的那个会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */
public class candy {
    public int candy(int[] ratings){
        int len = ratings.length;
        //满足左规则和右规则
        int[] candy = new int[len];
        //每人至少一颗糖果
        Arrays.fill(candy, 1);

        //首先左规则
        for (int i = 1; i < len; i++){
            if (ratings[i] > ratings[i - 1]){
                candy[i] = candy[i - 1] + 1;
            }
        }

        int count = candy[len - 1];
        //右规则
        for (int i = len - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]){
                //在满足左规则的前提下,满足右规则,更新糖果数
                candy[i] = candy[i + 1] + 1;
            }

            count += candy[i];
        }

        return count;
    }
}
