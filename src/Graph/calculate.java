package Graph;


import java.util.*;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，
 * 其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。
 * 每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 * 如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 */
public class calculate {
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        //构建图
        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);

            graph.putIfAbsent(A, new HashMap<>());
            graph.get(A).put(B, values[i]);

            graph.putIfAbsent(B, new HashMap<>());
            graph.get(B).put(A, 1.0 / values[i]);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);

            if (!graph.containsKey(C) || !graph.containsKey(D)){
                ans[i] = -1.0;
                continue;
            }
            if (C.equals(D)){
                ans[i] = 1.0;
                continue;
            }

            //防止循环
            Set<String> visited = new HashSet<>();
            ans[i] = dfs(C, D, 1.0, visited);
        }

        return ans;
    }

    private double dfs(String current, String target, double product, Set<String> visited) {
        //添加
        visited.add(current);

        //找到了
        if (current.equals(target)){
            return product;
        }

        //当前节点的邻居
        Map<String, Double> neighbors = graph.get(current);
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String next = entry.getKey();
            Double weight = entry.getValue();

            //如果没有被访问过
            if (!visited.contains(next)){
                double result = dfs(next, target, product * weight, visited);
                if (result != -1.0){
                    return result;
                }
            }
        }

        return -1.0;
    }

}
