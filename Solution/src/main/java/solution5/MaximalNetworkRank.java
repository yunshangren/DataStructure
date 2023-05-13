package solution5;

/**
 * @author Acer
 * @create 2023/3/15 9:55
 */
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        // 保存每个节点的度
        int[] degree = new int[n];

        for (int[] road : roads) {
            int i = road[0];
            int j = road[1];
            connected[i][j] = true;
            connected[j][i] = true;
            degree[i]++;
            degree[j]++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, degree[i] + degree[j] - (connected[i][j] ? 1 : 0));
            }
        }
        return res;
    }
}
