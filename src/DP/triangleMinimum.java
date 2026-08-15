package DP;


import java.util.List;
import java.util.Map;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class triangleMinimum {
    public int minimumTotal(List<List<Integer>> triangle){
        //从倒数第二层开始
        for (int i = triangle.size() - 2; i >= 0; i--){
            List<Integer> cur = triangle.get(i);
            List<Integer> next = triangle.get(i + 1);
            for (int j = 0; j < cur.size(); j++) {
                int min = Math.min(next.get(j), next.get(j + 1));

                //将当前这一层的值与下一层相邻的最小值进行相加
                cur.set(j, cur.get(j) + min);
            }
        }

        return triangle.getFirst().getFirst();
    }
}
