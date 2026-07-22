package Graph;


import java.util.HashMap;
import java.util.Map;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 */
public class cloneGraph {

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node){
        if (node == null){
            return null;
        }
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (map.containsKey(node)){
            return map.get(node);
        }

        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);

        for (Node n : node.neighbors) {
            cloneNode.neighbors.add(dfs(n));
        }

        return cloneNode;
    }
}
