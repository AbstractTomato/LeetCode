package Section;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class merge {
    public int[][] merge(int[][] intervals){
        List<Integer> list = new ArrayList<>();

        //先按照第一个数字进行升序排序
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);

        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (i + 1 == intervals.length){
                list.add(begin);
                list.add(end);
                break;
            }
            if (end < intervals[i + 1][0]){
                list.add(begin);
                list.add(end);
                begin = intervals[i + 1][0];
                end = intervals[i + 1][1];
            }else if (end > intervals[i + 1][1]){
                continue;
            }else if (end >= intervals[i + 1][0] && end <= intervals[i + 1][1]){
                end = intervals[i + 1][1];
            }
        }

        int len = list.size() / 2;
        int[][] ans = new int[len][2];

        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = list.get(2 * i);
            ans[i][1] = list.get(2 * i + 1);
        }

        return ans;
    }
}
