package Graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class course {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        //构建图
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            //当前课程
            int course = prerequisite[0];
            //先修课程
            int pre = prerequisite[1];
            //先修课程 -> 后续课程
            graph.get(pre).add(course);
            //当前课程的入度数
            inDegree[course]++;
        }

        //将所有入度数为0的课程压入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }

        //已学完的课程
        int count = 0;
        while (!queue.isEmpty()){
            //把入度为0的课程拿出来
            Integer course = queue.poll();
            //标记一门课程已学完
            count++;

            //拿到已学完课程的后续课程
            List<Integer> list = graph.get(course);
            for (Integer i : list) {
                //将这门课的入度数减一
                inDegree[i]--;
                //如果这门课的入度数为0的话,压入队列
                if (inDegree[i] == 0){
                    queue.offer(i);
                }
            }
        }

        return count == numCourses;
    }
}
