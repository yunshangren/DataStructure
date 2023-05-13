package solution11;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/18 15:43
 */
public class CountProvince {


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += dfs(isConnected, i);
        }
        return res;
    }

    public int dfs(int[][] isConnected, int cur) {
        if (isConnected[cur][cur] == -1) {
            return 0;
        }
        isConnected[cur][cur] = -1;
        for (int i = 0; i < isConnected[cur].length; i++) {
            if (isConnected[cur][i] == 1) {
                dfs(isConnected, i);
            }
        }
        return 1;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        };
        System.out.println(findCircleNum(matrix));
    }
}
