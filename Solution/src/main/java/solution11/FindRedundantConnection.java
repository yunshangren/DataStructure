package solution11;

/**
 * @author Acer
 * @create 2023/4/18 16:45
 */
public class FindRedundantConnection {
    boolean[] visited;

    public int[] findRedundantConnection(int[][] edges) {
        visited = new boolean[edges.length];
        return dfs(edges, 0);
    }

    public int[] dfs(int[][] edges, int index) {
        int i = edges[index][0] - 1;
        int j = edges[index][1] - 1;
        if (visited[i] && visited[j]) {
            return edges[index];
        } else {
            visited[i] = true;
            visited[j] = true;
            return dfs(edges, index + 1);
        }
    }
}
