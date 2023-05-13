package solution11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/18 10:00
 */
public class AllPathsSourceTarget {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,0);
        return res;
    }

    public void dfs(int[][] graph, int cur){
        if(cur == graph.length - 1){
            res.add(new ArrayList<>(path));
            res.get(res.size() - 1).add(cur);
            return;
        }
        path.add(cur);
        for (int i : graph[cur]) {
            dfs(graph,i);
        }
        path.remove(path.size() - 1);

    }
}
