package Section;


import java.util.Arrays;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。
 * 可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 */
public class overlap {
    public int findMinArrowShots(int[][] points){
        //排序
        Arrays.sort(points, (p, q) -> p[0] - q[0]);

        int ans = 1;
        int begin = points[0][0];
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] >= begin && points[i][0] <= end){
                begin = Math.max(begin, points[i][0]);
                end = Math.min(end, points[i][1]);
                continue;
            }
            ans++;
            begin = points[i][0];
            end = points[i][1];
        }

        return ans;
    }
}
