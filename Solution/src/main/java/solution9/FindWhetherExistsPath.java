package solution9;

import java.util.*;

/**
 * @author Acer
 * @create 2023/4/10 19:13
 */
public class FindWhetherExistsPath {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] ints : graph) {
            adj.get(ints[0]).add(ints[1]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer i : adj.get(node)) {
                if (i == target) {
                    return true;
                }
                if (!visited[i]) {
                    queue.add(i);
                }
            }
        }
        return false;
    }


}
