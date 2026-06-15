package Section;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。
 * 同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * 返回插入之后的 intervals。
 */
public class insert {
    public int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> list = new ArrayList<>();

        int i = 0;
        int len = intervals.length;

        //处理三种情况
        //1.intervals[i][1] < newInterval[0]
        while (i < len && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        //2.重合
        while (i < len && intervals[i][0] <= newInterval[1]){
            //合并
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);

        //3.intervals[i][0] > newInterval[1]
        while (i < len && intervals[i][0] > newInterval[1]){
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
