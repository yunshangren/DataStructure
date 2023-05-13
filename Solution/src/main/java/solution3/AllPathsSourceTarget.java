package solution3;

import java.util.*;

/**
 * @author Acer
 * @create 2023/2/27 16:51
 */
public class AllPathsSourceTarget {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(graph, path, 0);
        return res;
    }

    public void dfs(int[][] graph, LinkedList<Integer> path, int curNode) {

        if (curNode == graph.length - 1) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int node : graph[curNode]) {
            path.add(node);
            dfs(graph, path, node);
            path.removeLast();
        }
    }
}
